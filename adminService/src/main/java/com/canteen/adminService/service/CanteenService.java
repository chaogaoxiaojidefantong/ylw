package com.canteen.adminService.service;

import com.alibaba.druid.support.json.JSONUtils;
import com.canteen.adminService.dao.CanteenMapper;
import com.canteen.adminService.dao.FoodMapper;
import com.canteen.common.pojo.Canteen;
import com.canteen.common.pojo.Food;
import com.canteen.common.util.FileUtil;
import com.canteen.common.util.UploadImg;
import com.canteen.common.vo.BiliResult;
import com.canteen.common.vo.PicUploadResult;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import redis.clients.jedis.Jedis;

import java.io.*;
import java.util.List;
import java.util.Map;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.apache.poi.hwpf.HWPFDocument;
import org.apache.poi.hwpf.converter.PicturesManager;
import org.apache.poi.hwpf.converter.WordToHtmlConverter;
import org.apache.poi.hwpf.usermodel.PictureType;
import org.apache.poi.xwpf.converter.core.BasicURIResolver;
import org.apache.poi.xwpf.converter.core.FileImageExtractor;
import org.apache.poi.xwpf.converter.core.FileURIResolver;
import org.apache.poi.xwpf.converter.xhtml.XHTMLConverter;
import org.apache.poi.xwpf.converter.xhtml.XHTMLOptions;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.w3c.dom.Document;



@Service
public class CanteenService {
    @Value("${file.dir}")
    private String fileDir;

    @Value("${file.url}")
    private String fileUrl;

    @Autowired
    CanteenMapper canteenMapper;

    @Autowired
    FoodMapper foodMapper;

    Jedis jedis = new Jedis();

    /**
     * 添加食堂
     *
     * @param canteen
     * @return
     */
    public BiliResult addCanteen(Canteen canteen) {
        Integer i1 = canteenMapper.insert(canteen);
        if (i1 == 0) {
            return BiliResult.build(201, "插入失败");
        }
        return BiliResult.oK();
    }

    /**
     * 更新食堂信息
     *
     * @param canteen
     * @return
     */
    public BiliResult updateCanteen(Canteen canteen) {
        Integer i1 = canteenMapper.updateCanteenTest(canteen);

        if (i1 == 0) {
            return BiliResult.build(201, "更新失败");
        }
        return BiliResult.oK();
    }

    /**
     * 查询食堂列表
     *
     * @param canteen
     * @return
     */
    public BiliResult selectCanteen(Canteen canteen) {
//        jedis.set("name","sansan");
//        String name=jedis.get("name");
        List<Canteen> list = canteenMapper.select(canteen);
        if (list.size() == 0) {
            return BiliResult.build(201, "查询失败或者没有数据");
        }
        return BiliResult.oK(list);
    }

    public BiliResult deleteCanteen(String ids) {
        Integer i1 = canteenMapper.deleteCanteen(ids.split(","));
        if (i1 == 0) {
            return BiliResult.build(201, "删除失败");
        }
        String []idList=ids.split(",");
        for (String  idStr:idList){
            Integer canteenId=Integer.parseInt(idStr);
            Food food=new Food();
            food.setCanteenId(canteenId);
            foodMapper.delete(food);//删除食堂里的食品
        }
        return BiliResult.oK();
    }

    public BiliResult selectOneCanteen(Canteen canteen) {
        Canteen canteen1 = canteenMapper.selectOne(canteen);
        if (canteen1 == null) {
            return BiliResult.build(201, "没有查询到数据");
        }
        return BiliResult.oK(canteen1);
    }

    public BiliResult uploadCanteenPhoto(MultipartFile file, Canteen canteen) {
        File file1 = new File(fileDir + "/canteen/" + canteen.getCanteenId());
        if (file1.exists()) {
            FileUtil.deleteFileInFolder(file1);
        }
        PicUploadResult picUploadResult = UploadImg.doImgUpload(file, fileDir, fileUrl, "canteen/" + canteen.getCanteenId());
        String imgUrl = picUploadResult.getUrl();
        if (imgUrl != null) {
            Canteen canteen1 = new Canteen();
            canteen1.setCanteenId(canteen.getCanteenId());
            canteen1.setCanteenImage(imgUrl);
            canteenMapper.updateCanteen(canteen1);
            return BiliResult.oK(imgUrl);
        }
        return BiliResult.build(201, "上传失败");
    }

    /**
     * 通过名字模糊查询
     *
     * @param canteenName 用户输入的名字
     * @return
     */
    public BiliResult selectByName(String canteenName) {
        List<Canteen> list = canteenMapper.selectByName("%" + canteenName + "%");
        if (list.size() == 0) {
            return BiliResult.build(201, "没有数据");
        }
        return BiliResult.oK(list);
    }

    public BiliResult selectT1(){
        PageHelper.startPage(1,3);
        List<Canteen>list=canteenMapper.select(null);
        PageInfo pageInfo = new PageInfo(list);
        System.out.println("hehe");
        return null;
    }

    /**
     * 上传文档下载在本地
     * @param file
     * @return
     */
    public  BiliResult uploadDoc(MultipartFile file){
        File file1=new File(fileDir+"/"+file.getOriginalFilename());
        try {
            //file.transferTo(file1);
            //Word2007ToHtml(fileDir,"smtbug",".docx");
           System.out.println(readFile(fileDir+"/html/smtbug.html"));
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return null;
    }


    /**
     * 2007版本word转换成html 2017-2-27
     *
     * @param wordPath
     *            word文件路径
     * @param wordName
     *            word文件名称无后缀
     * @param suffix
     *            word文件后缀
     * @return
     * @throws IOException
     */
    public static String Word2007ToHtml(String wordPath, String wordName, String suffix)
            throws IOException {
        String htmlPath = wordPath + File.separator +  "html"
                + File.separator;
        String htmlName = wordName + ".html";
        String imagePath = htmlPath + "image" + File.separator;

        // 判断html文件是否存在
        File htmlFile = new File(htmlPath + htmlName);
//      if (htmlFile.exists()) {
//          return htmlFile.getAbsolutePath();
//      }

        // word文件
        File wordFile = new File(wordPath + File.separator + wordName + suffix);

        // 1) 加载word文档生成 XWPFDocument对象
        InputStream in = new FileInputStream(wordFile);
        XWPFDocument document = new XWPFDocument(in);

        // 2) 解析 XHTML配置 (这里设置IURIResolver来设置图片存放的目录)
        File imgFolder = new File(imagePath);
        XHTMLOptions options = XHTMLOptions.create();
        options.setExtractor(new FileImageExtractor(imgFolder));
        // html中图片的路径 相对路径
        options.URIResolver(new BasicURIResolver("image"));
        options.setIgnoreStylesIfUnused(false);
        options.setFragment(true);

        // 3) 将 XWPFDocument转换成XHTML
        // 生成html文件上级文件夹
        File folder = new File(htmlPath);
        if (!folder.exists()) {
            folder.mkdirs();
        }
        OutputStream out = new FileOutputStream(htmlFile);
        XHTMLConverter.getInstance().convert(document, out, options);
        return htmlFile.getAbsolutePath();
    }

    //filePathAndName : 你要转换的html的 绝对路径
    public static String readFile(String filePathAndName) {
        String fileContent = "";
        try {
            File f = new File(filePathAndName);
            if(f.isFile()&&f.exists()){
                InputStreamReader read = new InputStreamReader(new FileInputStream(f),"UTF-8");
                BufferedReader reader=new BufferedReader(read);
                String line;
                while ((line = reader.readLine()) != null) {
                    //将读取到的字符拼接
                    fileContent += line;
                }
                read.close();
            }
        } catch (Exception e) {
            System.out.println("读取文件内容操作出错");
            e.printStackTrace();
        }
        System.out.println("fileContent:"+fileContent);
        return fileContent;
    }
}

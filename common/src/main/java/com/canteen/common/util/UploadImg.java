package com.canteen.common.util;


import com.canteen.common.vo.PicUploadResult;
import org.springframework.web.multipart.MultipartFile;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;


public class UploadImg {
	/**
	 * 
	 * @param file 文件
	 * @param dirPath 存在本地磁盘中的路径
	 * @param urlPath 前端展示给用户的路径
	 * @param productName 图片要放在的文件夹名
	 * @return
	 */
	public static PicUploadResult doImgUpload(MultipartFile file, String dirPath, String urlPath, String productName) {
		PicUploadResult result=new PicUploadResult();
		String fileName=file.getOriginalFilename();
		fileName=fileName.toLowerCase();
		if(!fileName.matches("^.*\\.(jpg|png|gif|jpeg)$")) {
			result.setError(1);
			return result;	//提前返回
		}
		try {
			BufferedImage bufferedImage=ImageIO.read(file.getInputStream());
			Integer width=bufferedImage.getWidth();
			Integer height=bufferedImage.getHeight();
			if(width==0||height==0) {
				result.setError(1);
				return  result;
			}
			result.setHeight(height+"");
			result.setWidth(width+"");
			String filePath=dirPath+"/"+productName;
			File mkdirFile=new File(filePath);//创建文件夹
			if(!mkdirFile.exists()) {
				mkdirFile.mkdirs();
			}
			File reallyFile=new File(filePath+"/"+fileName);
			file.transferTo(reallyFile);
			String url=urlPath+"/"+productName+"/"+fileName;
			result.setUrl(url);
			return result;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		result.setError(1);
		return result;	
	}
}

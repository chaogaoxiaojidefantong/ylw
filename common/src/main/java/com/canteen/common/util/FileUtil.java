package com.canteen.common.util;

import java.io.File;

public class FileUtil {

    /**
     *是文件则删除文件，是文件夹则删除此文件夹和此文件夹下的文件
     * @param file 文件或者文件夹
     */
    public static void deleteFile(File file){
        if (file.isFile()){//判断是否为文件，是，则删除
            System.out.println(file.getAbsoluteFile());//打印路径
            file.delete();
        }else{//不为文件，则为文件夹
            String[] childFilePath = file.list();//获取文件夹下所有文件相对路径
            for (String path:childFilePath){
                File childFile= new File(file.getAbsoluteFile()+"/"+path);
                deleteFile(childFile);//递归，对每个都进行判断
            }
            System.out.println(file.getAbsoluteFile());
            file.delete();
        }
    }

    /**
     * 删除某文件夹下的文件，不包括此文件夹下的文件夹
     * @param file
     */
    public static void deleteFileInFolder(File file){
        String[] childFilePath = file.list();
        for (String path:childFilePath){
            File childFile= new File(file.getAbsoluteFile()+"/"+path);
            if(!childFile.isDirectory()){
                deleteFile(childFile);//递归，对每个都进行判断
            }
        }
    }
}

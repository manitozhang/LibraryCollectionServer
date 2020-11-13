package com.sample.util;

import java.io.File;
import java.io.FileOutputStream;

/**
 * @Author: 张
 * @Email: 1271396448@qq.com
 * @Date: 2020/11/13
 * @DESC: 文件处理工具类
 */
public class FileUtil {

    public static void uploadFile(byte[] file, String filePath, String fileName) throws Exception {
        File targetFile = new File(filePath);
        if (!targetFile.exists()) {
            targetFile.mkdirs();
        }
        FileOutputStream out = new FileOutputStream(filePath + fileName);
        out.write(file);
        out.flush();
        out.close();
    }

}
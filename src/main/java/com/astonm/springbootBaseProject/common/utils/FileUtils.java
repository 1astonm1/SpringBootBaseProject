package com.astonm.springbootBaseProject.common.utils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * ClassName FileUtils
 * Description
 * Create by zouming
 * Date 2021/8/1 5:23 下午
 */
public class FileUtils {

    public static void SaveFileFromInputStream(InputStream stream, String path, String savefile)
            throws IOException {

        File file = new File(path + "/" + savefile);
        if (!file.exists()) {
            file.createNewFile();
        }
        FileOutputStream fs = new FileOutputStream(file);
        byte[] buffer = new byte[1024 * 1024];
        int bytesum = 0;
        int byteread = 0;
        while ((byteread = stream.read(buffer)) != -1) {
            bytesum += byteread;
            fs.write(buffer, 0, byteread);
            fs.flush();
        }
        fs.close();
        stream.close();
    }
}

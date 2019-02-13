package com.houde.jdk.http;

import com.alibaba.fastjson.JSONObject;

import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @author qiukun
 * @create 2019-02-12 19:02
 */
public class ContentTypeUtils {
    private static JSONObject jsonObject;

    private static final String JSON_PATH = "static/meta/content-type.json";
    private static final String PATH = ContentTypeUtils.class.getClassLoader().getResource(JSON_PATH).getFile();

    static {
        jsonObject = JSONObject.parseObject(readFile());
    }

    private static String readFile() {

        try {
            RandomAccessFile raf = new RandomAccessFile(PATH, "r");
            FileChannel channel = raf.getChannel();
            ByteBuffer buffer = ByteBuffer.allocate((int) channel.size());
            buffer.clear();
            channel.read(buffer);
            buffer.flip();
            return new String(buffer.array());
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    public static String getContentType(String ext) {

        return (String) jsonObject.get(ext);
    }
}

package com.houde.jdk.tcpsocketchannel;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;

/**
 * @author qiukun
 * @create 2019-02-12 16:52
 */
public class TalkUtils {
    private static final int BUFFER_SIZE = 4096;

    public static void sendMsg(SocketChannel channel, String msg) throws IOException {
        ByteBuffer buffer = ByteBuffer.allocate(BUFFER_SIZE);
        buffer.put(msg.getBytes());
        buffer.flip();
        channel.write(buffer);
    }

    public static String recvMsg(SocketChannel channel) throws IOException {
        ByteBuffer buffer = ByteBuffer.allocate(BUFFER_SIZE);
        channel.read(buffer);
        //从写模式切换到读模式
        buffer.flip();
        byte[] bytes = new byte[buffer.limit()];
        buffer.get(bytes);
        return new String(bytes);
    }
}

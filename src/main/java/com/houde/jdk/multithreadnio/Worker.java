package com.houde.jdk.multithreadnio;

import java.nio.channels.SocketChannel;

public interface Worker {
    /**加入一个新的客户端会话*/
    public void registerNewChannelTask(SocketChannel channel);
}

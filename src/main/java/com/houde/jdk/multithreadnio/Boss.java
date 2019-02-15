package com.houde.jdk.multithreadnio;

import java.nio.channels.ServerSocketChannel;

public interface Boss {
    /**加入一个新的ServerSocket*/
    public void registerAcceptChannelTask(ServerSocketChannel serverChannel);
}

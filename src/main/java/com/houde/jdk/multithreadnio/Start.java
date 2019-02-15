package com.houde.jdk.multithreadnio;

import java.net.InetSocketAddress;
import java.util.concurrent.Executors;

/**
 * 启动类
 *
 * @author qiukun
 * @create 2019-02-15 10:44
 */
public class Start {
    public static void main(String[] args) {
        //初始化线程
        NioSelectorRunnablePool nioSelectorRunnablePool = new NioSelectorRunnablePool(Executors.newCachedThreadPool(), Executors.newCachedThreadPool());
        //获取服务类
        ServerBootstrap bootstrap = new ServerBootstrap(nioSelectorRunnablePool);
        //绑定端口
        bootstrap.bind(new InetSocketAddress(9200));
        System.out.println("start... ");
    }
}

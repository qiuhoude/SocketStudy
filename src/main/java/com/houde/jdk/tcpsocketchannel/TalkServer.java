package com.houde.jdk.tcpsocketchannel;

import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Scanner;

/**
 * @author qiukun
 * @create 2019-02-12 16:35
 */
@Slf4j
public class TalkServer {

    private static final String EXIT_MARK = "exit";

    private int port;
    private String ip;

    public TalkServer(int port, String ip) {
        this.port = port;
        this.ip = ip;
    }

    public void start() throws IOException {
        // 创建服务端套接字通道，监听端口，并等待客户端连接
        ServerSocketChannel ssc = ServerSocketChannel.open();
        ServerSocket serverSocket = ssc.socket();
        serverSocket.bind(new InetSocketAddress(ip, port));
        log.info(" 服务端启动,绑定ip：{} 正在监听 port：{} ", ip, port);
        SocketChannel channel = ssc.accept();
        log.info("接受来自 {} 请求", channel.getRemoteAddress().toString().replace("/", ""));
        Scanner sc = new Scanner(System.in);
        while (true) {
            // 等待并接收客户端发送的消息
            String msg = TalkUtils.recvMsg(channel);
            log.info("客户端：");
            log.info(msg);

            // 输入信息
            System.out.println("请输入：");
            msg = sc.nextLine();
            if (EXIT_MARK.equals(msg)) {
                TalkUtils.sendMsg(channel, "bye~");
                break;
            }

            // 回复客户端消息
            TalkUtils.sendMsg(channel, msg);
        }

        // 关闭通道
        channel.close();
        ssc.close();
    }


    public static void main(String[] args) throws IOException {
        TalkServer ts = new TalkServer(8080, "0.0.0.0");
        ts.start();
    }

}

package com.slt.test;

import java.net.InetSocketAddress;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;

/**
 * Created by Administrator on 2016/8/6.
 */
public class SocketServerChannel {


    public static void main(String args[]) throws Exception {
        Selector selector=Selector.open();
        ServerSocketChannel serverSocketChannel= ServerSocketChannel.open();
        serverSocketChannel.configureBlocking(false);
        serverSocketChannel.socket().bind(new InetSocketAddress(80));
        serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);
    }


}

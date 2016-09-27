package com.slt.test;

import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by Administrator on 2016/8/6.
 */
public class SocketTest {


    public static void main(String args[]) throws Exception {
        ServerSocket serverSocket=new ServerSocket(80);
        while (true){
            Socket socket= serverSocket.accept();

            System.out.println(socket.getInetAddress()+"欢迎光临");


            Thread thread=new Thread(new SocketRunnable(socket));
            thread.start();


        }
    }


}

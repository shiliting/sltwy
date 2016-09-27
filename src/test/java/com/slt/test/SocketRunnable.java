package com.slt.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.Socket;

/**
 * Created by Administrator on 2016/9/13.
 */
public class SocketRunnable implements Runnable {
    Socket socket;


    public SocketRunnable(){}

    public SocketRunnable(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            InputStream inputStream=socket.getInputStream();

            InputStreamReader inputStreamReader=new InputStreamReader(inputStream,"UTF-8");

            BufferedReader br=new BufferedReader(inputStreamReader);
            while (br.readLine()!=null){
                if(br.readLine()==null){
                    break;
                }

                System.out.println(br.readLine());

            }
        } catch (Exception e){
            e.printStackTrace();
        } finally {
            try {
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            System.out.println("over");
        }


    }
}

package com.slt.test;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * Created by Administrator on 2016/8/6.
 */
public class DownLoadRunnable implements Runnable{
    ByteArrayOutputStream bos=new ByteArrayOutputStream();
    InputStream inputStream;
    byte[] buffer = new byte[1024];
    int len=0;

    public DownLoadRunnable(InputStream inputStream) {
        this.inputStream = inputStream;
    }

    @Override
    public void run() {
        try {
            while((len = inputStream.read(buffer)) != -1) {
//                if()
                bos.write(buffer, 0, len);
            }
        } catch (Exception e){
            e.printStackTrace();
        }finally {
            try {
                bos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}

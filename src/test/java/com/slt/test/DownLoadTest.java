package com.slt.test;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/8/6.
 */
public class DownLoadTest {
    static List<Long> downds=new ArrayList<>();
    static List<Long> changes=new ArrayList<>();
    static List<Long> writes=new ArrayList<>();

    public static void main(String[] args) {
        for(int i=0;i<10;i++){
            try{
                Long time=System.currentTimeMillis();
                downLoadFromUrl("http://101.95.48.97:8005/res/upload/interface/apptutorials/manualstypeico/6f83ce8f-0da5-49b3-bac8-fd5fc67d2725.png",
                        "百度.jpg","D:\\SLT\\");
                long d=System.currentTimeMillis()-time;
                System.out.println("time:"+d);

            }catch (Exception e) {
                e.printStackTrace();
                // TODO: handle exception
            }
        }

        System.out.println("下载时间总结："+downds.toString());
        System.out.println("转换时间总结:"+changes.toString());
        System.out.println("写入时间总结："+writes.toString());

        long sum=0;
        for(Long l:writes){
            sum=sum+l;
        }
        System.out.println("写入时间总结："+sum);
    }



    /**
     * 从网络Url中下载文件
     * @param urlStr
     * @param fileName
     * @param savePath
     * @throws IOException
     */
    public static void  downLoadFromUrl(String urlStr,String fileName,String savePath) throws IOException {
        //---------------------------计算下载时间----------------------------------------
        Long time=System.currentTimeMillis();
        URL url = new URL(urlStr);
        HttpURLConnection conn = (HttpURLConnection)url.openConnection();
        //设置超时间为3秒
        conn.setConnectTimeout(3*1000);
        //防止屏蔽程序抓取而返回403错误
        conn.setRequestProperty("User-Agent", "Mozilla/4.0 (compatible; MSIE 5.0; Windows NT; DigExt)");

        //得到输入流
        InputStream inputStream = conn.getInputStream();
        byte[] down=downByte(inputStream);
//        byte[] down=readInputStream(inputStream);
        inputStream.close();

        Long time2=System.currentTimeMillis();
        downds.add(time2-time);
        //---------------------------计算下载时间END----------------------------------------


        //---------------------------计算转换时间----------------------------------------
        Long time3=System.currentTimeMillis();
        //获取自己数组
//        byte[] getData = readInputStream(inputStream);
        Long time4=System.currentTimeMillis();
        changes.add(time4-time3);
        System.out.println("转换花费:"+(time4-time2));
        //---------------------------计算转换时间END----------------------------------------


        //---------------------------计算保存文件的时间----------------------------------------
        Long time5=System.currentTimeMillis();
        //文件保存位置
        File saveDir = new File(savePath);
        if(!saveDir.exists()){
            saveDir.mkdir();
        }
//        byte[] buffer = new byte[1024];
//        int len=0;

        File file = new File(saveDir+File.separator+fileName);
        FileOutputStream fos = new FileOutputStream(file);
//        while((len = inputStream.read(buffer)) != -1) {
//
//            fos.write(buffer, 0, len);
//        }
        fos.write(down);
        if(fos!=null){
            fos.close();
        }
        if(inputStream!=null){
            inputStream.close();
        }


        Long time6=System.currentTimeMillis();
        System.out.println("info:"+url+" download success");
        writes.add(time6-time5);
        //---------------------------计算保存文件的时间END----------------------------------------

        file.delete();

    }


    private static byte[] downByte(InputStream inputStream) throws IOException{
//        List<Byte> down=new ArrayList<>();
        byte[] down=new byte[15000];
        byte[] buffer=new byte[1024];

        int len=0;
        int pos=0;
        while((len = inputStream.read(buffer)) != -1) {
            System.arraycopy(buffer,0,down,pos,len);
            pos += len;
        }
        return down;
//        return down.toArray(new Byte[down.size()]);
    };


    /**
     * 从输入流中获取字节数组
     * @param inputStream
     * @return
     * @throws IOException
     */
    public static  byte[] readInputStream(InputStream inputStream) throws IOException {

//        DownLoadRunnable dl=new DownLoadRunnable(inputStream);
//
//        Thread thread1=new Thread(dl);
//        Thread thread2=new Thread(dl);
//        thread1.start();
//        thread2.start();
//        try {
//            thread2.join();
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        byte[] buffer = new byte[1024];
        int len = 0;
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        while((len = inputStream.read(buffer)) != -1) {
            bos.write(buffer, 0, len);
        }
        bos.close();
        return bos.toByteArray();
    }


}

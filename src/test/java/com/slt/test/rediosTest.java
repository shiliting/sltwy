package com.slt.test;

import redis.clients.jedis.Jedis;

/**
 * Created by Administrator on 2016/10/8.
 */
public class rediosTest {
    public static void main(String[] args) {
        //Connecting to Redis server on localhost
        Jedis jedis = new Jedis("127.0.0.1");
        System.out.println("Connection to server sucessfully");
        //check whether server is running or not
        System.out.println("Server is running: "+jedis.ping());

        jedis.set("name","slt");
        System.out.println("get key value:"+jedis.get("name"));
    }
}

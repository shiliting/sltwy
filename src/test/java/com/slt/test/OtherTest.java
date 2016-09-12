package com.slt.test;

import org.junit.Test;

import java.lang.reflect.Method;

/**
 * 反射
 * Created by Administrator on 2016/8/30.
 */
public class OtherTest {
    int k;

    public static void main(String args[]) throws Exception {
        Foo foo = new Foo("这个一个Foo对象！");
        Class clazzFoo = foo.getClass();
        Method m1 = clazzFoo.getDeclaredMethod("outInfo");
        Method m2 = clazzFoo.getDeclaredMethod("setMsg", String.class);
        Method m3 = clazzFoo.getDeclaredMethod("getMsg");
        m1.invoke(foo);
        m2.invoke(foo, "重新设置msg信息！");
        String msg = (String) m3.invoke(foo);
        System.out.println(msg);

    }

    @Test
    public void test(){
        System.out.println(Math.E);
        System.out.println(EnumTest.FOUR);
        EnumTest enumTest=EnumTest.FOUR;
        switch (enumTest){

        }
    }
}

class Foo {
    private String msg;

    public Foo(String msg) {
        this.msg = msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getMsg() {
        return msg;
    }

    public void outInfo() {
        System.out.println("这是测试Java反射的测试类");
    }
}
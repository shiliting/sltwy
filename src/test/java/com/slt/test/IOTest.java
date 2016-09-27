package com.slt.test;

import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

/**
 * Created by Administrator on 2016/8/6.
 */
public class IOTest {

    @Test
    public void test(){
        InputStream inputStream=new InputStream() {
            @Override
            public int read() throws IOException {
                return 0;
            }
        };
    }

}

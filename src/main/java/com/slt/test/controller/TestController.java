package com.slt.test.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Administrator on 2016/3/7.
 */
@Controller
public class TestController {

    @RequestMapping("/index")
    public String getIndex(){
        return "index";
    }
}

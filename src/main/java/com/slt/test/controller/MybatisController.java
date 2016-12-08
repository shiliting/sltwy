package com.slt.test.controller;

import com.slt.test.entity.Items;
import com.slt.test.repository.UserDao;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;

/**
 * Created by Administrator on 2016/12/8.
 */
@Controller
public class MybatisController {

    @Resource
    UserDao userDao;

    @RequestMapping("/getItems")
    public Items getItems() throws Exception{
        Items items=userDao.getItems(1L);
        return items;
    }

}

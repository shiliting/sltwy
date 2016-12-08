package com.slt.test.controller.front;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Administrator on 2016/3/7.
 */
@Controller
public class SecondController {
    private static Log log = LogFactory.getLog(SecondController.class);
//    @Autowired
//    GoodsRepository goodsRepository;

//    @Autowired
//    GoodsService goodsService;


    @RequestMapping("/second")
    public void getIndex(){

//        return "index";
    }
}

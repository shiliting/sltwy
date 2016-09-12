package com.slt.test.controller;

import com.slt.test.entity.Goods;
import com.slt.test.service.GoodsService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Administrator on 2016/3/7.
 */
@Controller
public class TestController {
    private static Log log = LogFactory.getLog(TestController.class);
//    @Autowired
//    GoodsRepository goodsRepository;

    @Autowired
    GoodsService goodsService;


    @RequestMapping("/index")
    public void getIndex(){

//        return "index";
    }

    @RequestMapping("/haveNo")
    public void haveNo(){
    }

        @RequestMapping("/indexString")
    public String indexString(){
        return "index";
    }

    @RequestMapping("/indexStringAndP")
    public String indexString(String p){
        log.info(p);
        return "index";
    }

//    @RequestMapping("/addGoods")
//    @Transactional()
//    public String addGoods( String goodsTitle) throws Exception{
//
//        Goods goods=new Goods();
//        goods.setTitle(goodsTitle);
//        goodsRepository.save(goods);
//        goods.setTitle("keyi");
//        return "index";
//    }
//
    @RequestMapping("/findGoods")
    public String findGoods(Long goodsId) throws Exception{
        Goods goods=goodsService.getOneGoods(goodsId);
        return "index";
    }
}

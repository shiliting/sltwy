package com.slt.test.controller;

import com.slt.test.entity.Goods;
import com.slt.test.entity.Manager;
import com.slt.test.repository.GoodsRepository;
import com.slt.test.repository.ManagerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Administrator on 2016/3/7.
 */
@Controller
public class TestController {
    @Autowired
    GoodsRepository goodsRepository;

    @Autowired
    ManagerRepository managerRepository;

//    @Autowired
//    GoodsService goodsService;

    @RequestMapping("/index")
    public String getIndex(){
        return "index";
    }

    @RequestMapping("/addGoods")
    @Transactional()
    public String addGoods( String goodsTitle) throws Exception{

        Manager manager=new Manager();
        manager.setEnabled(true);
        manager.setManagerField("manager");
        manager.setLoginName("slt");
        manager.setPassword("123456");
        managerRepository.save(manager);

        Goods goods=new Goods();
        goods.setTitle(goodsTitle);
        goods.setManager(manager);
        goodsRepository.save(goods);
        goods.setTitle("keyi");
        return "index";
    }

    @RequestMapping("/findGoods")
    public String findGoods(Long goodsId) throws Exception{
        Goods goods=goodsRepository.findOne(goodsId);

//        Goods goods1=goodsService.getOneGoods(goodsId);


//        Manager manager=managerRepository.findOne(goods.getManager().getId());
        return "index";
    }
}

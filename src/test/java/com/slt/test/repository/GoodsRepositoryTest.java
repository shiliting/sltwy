package com.slt.test.repository;

import com.slt.test.base.Base;
import com.slt.test.entity.Goods;
import com.slt.test.entity.Manager;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by Administrator on 2016/4/13.
 */

public class GoodsRepositoryTest extends Base {
    @Autowired
    GoodsRepository goodsRepository;

    @Autowired
    ManagerRepository managerRepository;
    @Test
    public void test(){
        Manager manager=new Manager();
        manager.setManagerField("slt");
        managerRepository.saveAndFlush(manager);
        Goods goods=new Goods();
        goods.setManager(manager);
        goods.setTitle("我的第一个商品");
        goodsRepository.saveAndFlush(goods);
        List<Goods> goodses=goodsRepository.findAll();
        for(Goods g:goodses){
            System.out.println(g.getManager().getManagerField());
        }

    }
}

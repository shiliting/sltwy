package com.slt.test.service.impl;

import com.slt.test.entity.Goods;
import com.slt.test.repository.GoodsRepository;
import com.slt.test.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

/**
 * Created by Administrator on 2016/5/4.
 */
@Service
public class GoodsServiceImpl implements GoodsService {
    @Autowired
    GoodsRepository goodsRepository;


    EntityManager entityManager;

    /**
     * 通过本地查询方法获取goods对象
     * @param goodsId
     * @return
     */
    public Goods getOneGoods(Long goodsId){
        String sql="SELECT * FROM goods WHERE ID=:gid";
        Query query=entityManager.createNativeQuery(sql,"Goods");
        query.setParameter("gid",goodsId);
        List<Goods> goodses=query.getResultList();
        return goodses.get(0);
    }
}

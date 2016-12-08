package com.slt.test.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

/**
 * Created by Administrator on 2016/3/15.
 */
@Entity
@Getter
@Setter
@Table(name = "Goods")
@Cacheable(value = false)
public class Goods {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 名称
     */
    private String title;

    @ManyToOne(cascade = CascadeType.PERSIST)
    private Items items;


    @PrePersist//实体加载前运行
    public void startGoods(){
        System.out.println("开始加载Goods");

    }
    @PostPersist//实体加载完执行
    public void endGoods(){
        System.out.println("加载Goods完毕");

    }
}

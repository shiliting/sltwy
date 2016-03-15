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
@Cacheable(value = false)
public class Goods {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 名称
     */
    private String title;
}

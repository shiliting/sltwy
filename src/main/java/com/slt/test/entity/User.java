package com.slt.test.entity;

/**
 * Created by Administrator on 2016/12/6.
 */
//@Entity
//@Getter
//@Setter
//@Table(name = "User")
//@Cacheable(value = false)
public class User {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

//    @ManyToOne(cascade = CascadeType.PERSIST)
    private Goods goods;


}

package com.slt.test.repository;

import com.slt.test.entity.Items;

/**
 * Created by Administrator on 2016/12/8.
 */
public interface UserDao {
    Items getItems(Long id);
}

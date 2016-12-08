package com.slt.test.repository;

import com.slt.test.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Administrator on 2016/3/21.
 */
@Repository
public interface UserRepository extends JpaRepository<User,Long> {
}

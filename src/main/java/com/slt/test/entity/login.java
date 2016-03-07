package com.slt.test.entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.Cacheable;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

/**
 * Created by Administrator on 2016/3/7.
 */
@Entity
@Getter
@Setter
@Inheritance(strategy = InheritanceType.JOINED)
@Cacheable(value = false)
public abstract class login  implements UserDetails {
}

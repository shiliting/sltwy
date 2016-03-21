package com.slt.test.entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by Administrator on 2016/3/7.
 */
@Entity
@Getter
@Setter
@Table(uniqueConstraints = @UniqueConstraint(columnNames = {"loginName"}))
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Login implements UserDetails {
    private static final long serialVersionUID = -349012453592429794L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    /**
     * 账号名称
     */
    @Column
    private String loginName;
    /**
     * 账号密码
     */
    private String password;
    /**
     * 是否可用
     */
    private boolean enabled = true;

    /**
     * 上次登录时间
     */
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastLoginDate;
    /**
     * 上次登录IP
     */
    private String lastLoginIP;
    @Override
    public String getUsername() {
        return loginName;
    }
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }
}

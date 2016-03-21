package com.slt.test.entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import javax.persistence.Entity;
import java.util.Arrays;
import java.util.Collection;

/**
 * Created by luffy on 2015/6/10.
 * 系统管理员(最高权限)
 *
 * @author luffy luffy.ja at gmail.com
 */
@Entity
@Setter
@Getter
public class Manager extends Login{
    private String managerField;
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Arrays.asList(
                new SimpleGrantedAuthority("ROLE_EDITOR"),//编辑权限
                new SimpleGrantedAuthority("ROLE_USER"),
                new SimpleGrantedAuthority("ROLE_ADMIN"),
                new SimpleGrantedAuthority("ROLE_GRANT")

        );
    }
}

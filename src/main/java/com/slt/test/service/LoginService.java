package com.slt.test.service;

import com.slt.test.entity.Login;
import com.slt.test.repository.LoginRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * Created by slt on 2016/3/21.
 */
@Service
public class LoginService implements UserDetailsService {

    @Autowired
    private LoginRepository loginRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Login login = loginRepository.findByLoginName(username);
        if (login == null)
            throw new UsernameNotFoundException("无效的用户名。");
        login.setLastLoginDate(new Date());
        return login;
    }

    /**
     * 新建一个可登陆用户
     *
     * @param login    准备新建的可登陆用户
     * @param password 明文密码
     */
    public <T extends Login> T newLogin(T login, CharSequence password) {
        login.setPassword(passwordEncoder.encode(password));
        login.setEnabled(true);
        return loginRepository.save(login);
    }
}

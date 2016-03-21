package com.slt.test.config;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * Created by lgh on 2015/12/26.
 */

@Configuration
@EnableWebSecurity
//@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig {
    private static String loginPage = "/back/assets/signin.html";

    @Autowired
    private PasswordEncoder passwordEncoder;
//    @Autowired
//    private UserDetailsService userDetailsService;


//    @Autowired
//    public void registerSharedAuthentication(AuthenticationManagerBuilder auth) throws Exception {
//        auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder);
//    }


    @Configuration
    public static class YmrWebSecurityConfigurerAdapter extends WebSecurityConfigurerAdapter {
//        /**
//         * 配置忽略的项
//         *
//         * @param web
//         * @throws Exception
//         */
        @Override
        public void configure(WebSecurity web) throws Exception {
            super.configure(web);
            web.ignoring().antMatchers(
                    "/resource/**",
                    "/back/assets/css/**",
                    "/back/assets/fonts/**",
                    "/back/assets/images/**",
                    "/back/assets/js/**",
                    "/back/assets/holder.js/**"
            );
        }


        @Override
        public void configure(HttpSecurity http) throws Exception {
            http
                    .headers().frameOptions().sameOrigin().and()
                    .authorizeRequests().antMatchers(
                    "/front/**",
                    "/index",
                    "/back/assets/signin.html"
            ).permitAll().anyRequest().authenticated()
                    .and()
                    .csrf().disable()
                    .formLogin()
                    .loginPage(loginPage)
                    .failureUrl(loginPage)
                    .and()
                    .httpBasic();
        }
    }
}

package com.slt.test.base;

//import com.slt.test.config.CoreConfig;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.WebApplicationContext;

import java.util.Random;

/**
 * Created by Administrator on 2016/3/22.
 */
@WebAppConfiguration
@ActiveProfiles("develop")
@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(classes = {CoreConfig.class})
@Transactional
public class Base {
    protected final Random random = new Random();
    /**
     * 自动注入应用程序上下文
     **/
    @Autowired(required = false)
    protected WebApplicationContext context;


}

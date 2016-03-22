package com.slt.test.service;

import com.slt.test.entity.Manager;
import com.slt.test.repository.ManagerRepository;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author slt
 */
@Service
public class AppService implements ApplicationListener<ContextRefreshedEvent> {

    private static final Log log = LogFactory.getLog(AppService.class);

    @Autowired
    private LoginService loginService;

    @Autowired
    private ManagerRepository managerRepository;


    @Override
    @Transactional
    public void onApplicationEvent(ContextRefreshedEvent event) {

        if (event.getApplicationContext().getParent() == null) {

            if(managerRepository.count()==0){
                Manager manager=new Manager();
                manager.setLoginName("shiliting");
                loginService.newLogin(manager,"123456");
            }

        }

    }

}

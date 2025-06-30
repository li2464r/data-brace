package com.racacia.repository.config.cache;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Component;

/**
 * @author Administrator
 * @date 2022/3/30 0030 11:38
 */
@Component
public class SpringBeanContext implements ApplicationContextAware {

    private static ApplicationContext application;

    public static ApplicationContext build(){
        return application;
    }

    @Override
    public void setApplicationContext(@NonNull ApplicationContext applicationContext) throws BeansException {
        application = applicationContext;
    }

    public Object getBean(String beanName) {
        return application.getBean(beanName);
    }

    public <T> T getBean(String beanName, Class<T> clazz) {
        return application.getBean(beanName, clazz);
    }

}

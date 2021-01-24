package com.es.camp.web.util;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * 应用上下文工具类
 */
@Slf4j
@Component
public class ApplicationUtils implements ApplicationContextAware {

    private static ApplicationContext applicationContext = null;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        if (ApplicationUtils.applicationContext == null) {
            ApplicationUtils.applicationContext = applicationContext;
        }
    }

    public static ApplicationContext getApplicationContext() {
        return applicationContext;
    }

    /**
     * 通过 name 获取 bean
     * @param name beanName
     * @return bean
     */
    public static Object getBean(String name) {
        return applicationContext.getBean(name);
    }

    /**
     * 通过 Class 类型获取 bean
     * @param clazz 类型
     * @param <T> 类型
     * @return T t
     */
    public static <T> T getBean(Class<T> clazz) {
        return applicationContext.getBean(clazz);
    }

    /**
     * 通过 class + name 获取 bean
     * @param clazz bean类型
     * @param name  bean名称
     * @param <T>  泛型
     * @return T t
     */
    public static <T> T getBean(Class<T> clazz, String name) {
        return applicationContext.getBean(name,clazz);
    }


}

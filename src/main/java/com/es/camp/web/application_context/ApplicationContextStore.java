package com.es.camp.web.application_context;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationContext;

/**
 * 保存应用上下文
 */
@Slf4j
public class ApplicationContextStore {

    private static ApplicationContext applicationContext;

    public static ApplicationContext getApplicationContext() {
        return ApplicationContextStore.applicationContext;
    }

    public static void setApplicationContext(ApplicationContext applicationContext) {
        log.info("========ApplicationContextStore：setApplicationContext Done =========");
        ApplicationContextStore.applicationContext = applicationContext;
    }
}

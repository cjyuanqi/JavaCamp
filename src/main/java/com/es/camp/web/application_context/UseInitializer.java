package com.es.camp.web.application_context;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * 获取应用上下文， 需要注册到启动的地方。
 */
@Slf4j
public class UseInitializer implements ApplicationContextInitializer<ConfigurableApplicationContext> {

    @Override
    public void initialize(ConfigurableApplicationContext applicationContext) {
        assert ApplicationContextStore.getApplicationContext() == null;
        ApplicationContextStore.setApplicationContext(applicationContext);
        assert ApplicationContextStore.getApplicationContext() != null;

        log.info("【设置 ApplicationContext 完毕】");
    }
}

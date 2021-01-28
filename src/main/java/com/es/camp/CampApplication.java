package com.es.camp;

import com.es.camp.web.application_context.ApplicationContextStore;
import com.es.camp.web.application_context.UseInitializer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableAsync
//@EnableScheduling
@SpringBootApplication
@ServletComponentScan("com.es.camp")
@ComponentScan(value = {"com.es.camp","com.es.outer"})
public class CampApplication {

    public static void main(String[] args) {
        SpringApplication.run(CampApplication.class, args);

        // 第一种方式获取应用上下文
//        SpringApplication application = new SpringApplication(CampApplication.class);
//        application.addInitializers(new UseInitializer());
//        application.run(args);

        // 第二种方式， 通过Listener 实现 ApplicationContextEvent 来获取， 很简单在 UseListener 中可实现。

        // 第三种方式 直接设置 ApplicationContext
//        ApplicationContextStore.setApplicationContext(
//                SpringApplication.run(CampApplication.class, args)
//        );

        // 第四种方式， 通过实现 ApplicationContextAware 来获取



    }

}

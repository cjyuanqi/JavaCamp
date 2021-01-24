package com.es.camp.web.service;

import com.es.camp.web.muti_usable_bean.ITemplateManagerService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

@Slf4j
@SpringBootTest
@RunWith(SpringRunner.class)
@SuppressWarnings("all")
public class TestMutiAbleUsableBean {

    /**
     * Autowired 默认按类型注入， 如果类型有多个实例，则按名称注入。
     */
//    @Autowired
//    private RedisTemplate redisTemplate;

    /**
     * 使用 Autowired 和 qualifier 可以指定类型和名称。
      */
    @Autowired
//    @Qualifier(value = "qinyiRedisTemplate")
    private RedisTemplate redisTemplate;

    /**
     * @Resourse 优先按照名称注入
      */
    @Resource
    private RedisTemplate courceRedisTemplate;

    @Autowired
    @Qualifier("paperTemplateManagerService")
    private ITemplateManagerService templateManagerService;



    @Test
    public void testAutowire() {
        assert redisTemplate != null;
        redisTemplate.getConnectionFactory().getConnection().flushAll();
        redisTemplate.opsForValue().set("name","qinyi");
    }

    @Test
    public void testResouce() {
        assert courceRedisTemplate != null;
        courceRedisTemplate.getConnectionFactory().getConnection().flushAll();
        courceRedisTemplate.opsForValue().set("name","qinyi");
    }

    @Test
    public void testBeanNull() {
        templateManagerService.print();
    }



}

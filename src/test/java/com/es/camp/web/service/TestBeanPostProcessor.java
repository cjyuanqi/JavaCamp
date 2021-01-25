package com.es.camp.web.service;


import com.es.camp.web.bean_post_processor.AVIDecoder;
import com.es.camp.web.bean_post_processor.B004;
import com.es.camp.web.bean_post_processor.DecodeManager;
import com.es.camp.web.bean_post_processor.VideoType;
import com.es.camp.web.bean_post_processor.WMVDecoder;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Random;

@Slf4j
@SpringBootTest
@RunWith(SpringRunner.class)
public class TestBeanPostProcessor {

    @Autowired
    private AVIDecoder aviDecoder;

    @Autowired
    private WMVDecoder wmvDecoder;


    @Test
    public void testEasyUseOfDecoder() {
        VideoType type = getRandomVideoType();
        switch (type) {
            case AVI:
                log.info("【开始解码】---> {}",aviDecoder.decode("video"));
                break;
            case WMV:
                log.info("【开始解码】--> {}", wmvDecoder.decode("video"));
                break;
            default:
                log.info("【解码出错】--> 格式不支持 ");

        }
    }

    @Autowired
    private DecodeManager decodeManager;



    @Test
    public void testUseDecodeManager() {
        log.info("========【解码结果】" + decodeManager.decode(getRandomVideoType(),"video"));
    }


    @Autowired
    private B004 b004;

    @Test
    public void testB004() {
        log.info("============ testB004 ===========");
        b004.toDo();
    }

    // 获取随机的 VideoType
    private VideoType getRandomVideoType() {
        return VideoType.values()[new Random().nextInt(VideoType.values().length)];
    }


}

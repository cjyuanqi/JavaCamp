package com.es.camp.web.bean_post_processor;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class WMVDecoder implements IDecoder, InitializingBean {
    @Override
    public VideoType type() {
        return VideoType.WMV;
    }

    @Override
    public String decode(String data) {
        return this.type().getDesc() + ":" + data;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        log.info("==【 WMVDecoder InitializingBean afterPropertiesSet 】");
    }
}

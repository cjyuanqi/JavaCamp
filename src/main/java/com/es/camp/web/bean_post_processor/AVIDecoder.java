package com.es.camp.web.bean_post_processor;


import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class AVIDecoder implements IDecoder {


    @Override
    public VideoType type() {
        return VideoType.AVI;
    }

    @Override
    public String decode(String data) {
        return this.type().getDesc() + ":" + data;
    }
}

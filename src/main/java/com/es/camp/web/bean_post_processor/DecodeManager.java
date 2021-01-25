package com.es.camp.web.bean_post_processor;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Slf4j
@Service
public class DecodeManager implements BeanPostProcessor {

    private static final Map<VideoType, IDecoder> videoTypeIndex = new HashMap<>(VideoType.values().length);


    public String decode(VideoType type, String data) {
        String result = null;
        switch (type) {
            case AVI:
                result = videoTypeIndex.get(VideoType.AVI).decode(data);
                break;
            case WMV:
                result = videoTypeIndex.get(VideoType.WMV).decode(data);
                break;
            default:
                log.info("decode error");
        }
        return result;
    }


    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {

        if (!(bean instanceof IDecoder)) {
            return bean;
        }

        IDecoder decoder = (IDecoder) bean;
        boolean isDecoderExist = videoTypeIndex.containsKey(decoder.type());
        if (isDecoderExist) {
            throw new IllegalStateException("重复注册");
        }
        log.info("===【BeanPostProcessor : postProcessBeforeInitialization 】--> decoder class:{}, for video type:{}", decoder.getClass(),decoder.type());
        videoTypeIndex.put(decoder.type(), decoder);
        return null;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {

        if (!(bean instanceof IDecoder)) {
            return bean;
        }
        log.info("===【BeanPostProcessor : postProcessAfterInitialization】");

        return null;
    }
}

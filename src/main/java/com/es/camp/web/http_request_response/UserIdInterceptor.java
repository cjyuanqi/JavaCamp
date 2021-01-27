package com.es.camp.web.http_request_response;

import cn.hutool.json.JSONUtil;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Slf4j
@Component
public class UserIdInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        log.info("========coming in UserIdInterceptor:preHandle");
        if (RequestParseUtil.isJson(request)) {
            String json = RequestParseUtil.getBodyString(request);

            User user = null;

            try {
                user = new ObjectMapper().readValue(json, User.class);
            } catch (JsonProcessingException e) {
                user = null;
            }

            if (null != user) {
                log.info("======= UserIdInterceptor:preHandle --> {}",user.toString());
            }
        }

        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }
}

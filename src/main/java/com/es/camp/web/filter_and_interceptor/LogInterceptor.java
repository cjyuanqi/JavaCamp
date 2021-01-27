package com.es.camp.web.filter_and_interceptor;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Slf4j
@Component
public class LogInterceptor implements HandlerInterceptor {

    private Long start = System.currentTimeMillis();

    // 处理前输出日志
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        long start = System.currentTimeMillis();
        HandlerMethod handlerMethod = (HandlerMethod)handler;

        log.info("======= LogInterceptor:preHandle-->{}",handlerMethod.getBean().getClass().getName());
        log.info("======= LogInterceptor:preHandle-->{}", handlerMethod.getMethod().getName());

        return true;
    }


    // 处理后输入日志
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        log.info("====== LogInterceptor:postHandle-->{} --> {}", request.getRequestURI(), System.currentTimeMillis() - start);
    }
}

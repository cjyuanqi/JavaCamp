package com.es.camp.web.filter_and_interceptor;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Slf4j
@Component
public class UpdateLogInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        long updateLogInterceptorStartTime = System.currentTimeMillis();
        request.setAttribute("updateLogInterceptorStartTime", updateLogInterceptorStartTime);
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        long updateLogInterceptorStartTime = (long) request.getAttribute("updateLogInterceptorStartTime");
        log.info("======= UpdateLogInterceptor:postHandle --> {}", System.currentTimeMillis() - updateLogInterceptorStartTime);
    }
}

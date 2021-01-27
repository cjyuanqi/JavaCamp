package com.es.camp.web.filter_and_interceptor;

import lombok.extern.slf4j.Slf4j;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.regex.Pattern;

@Slf4j
@WebFilter(urlPatterns = {"/*"}, filterName = "LogFilter")
public class LogFilter implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        Long start = System.currentTimeMillis();

        chain.doFilter(request,response);

        log.info("======== LogFilter print log: {} --> {}", ((HttpServletRequest)request).getRequestURI(), System.currentTimeMillis() - start);

    }
}

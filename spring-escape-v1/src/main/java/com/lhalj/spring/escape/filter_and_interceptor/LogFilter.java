package com.lhalj.spring.escape.filter_and_interceptor;

import cn.hutool.http.HttpRequest;
import lombok.extern.slf4j.Slf4j;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * 描述: 过滤器
 */
@Slf4j
@WebFilter(urlPatterns = "/*",filterName = "LogFilter")
public class LogFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain chain) throws IOException, ServletException {
        long start = System.currentTimeMillis();
        chain.doFilter(servletRequest,servletResponse);
        //往上返回
        log.info("LogFilter Print Log:{} -> {}",((HttpServletRequest)servletRequest).getRequestURI(),System.currentTimeMillis() - start);

    }

    @Override
    public void destroy() {

    }
}

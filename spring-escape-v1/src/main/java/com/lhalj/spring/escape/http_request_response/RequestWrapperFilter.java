package com.lhalj.spring.escape.http_request_response;

import lombok.extern.slf4j.Slf4j;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * 描述:
 */
@Slf4j
@WebFilter(urlPatterns = "/*",filterName = "RequestWrapperFilter")
public class RequestWrapperFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain chain) throws IOException, ServletException {

        log.info("RequestWrapperFilter Replace InputStream!");
        //获取Wrapper里面的 request
        ServletRequest requestWrapper = new RequestWrapper(
                (HttpServletRequest) servletRequest);

        chain.doFilter(requestWrapper,servletResponse);

    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void destroy() {

    }
}

package com.neosoft.apigateway.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/client")
public class ZuulLoginFilter extends ZuulFilter  {

  @Override
    public String filterType() {
        return "pre"; // filter before request is executed
        // return "post"; filter after request is executed
        //return "error"; upon request error
    }

    @Override
    public int filterOrder() {
        return 1;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() throws ZuulException {
        log.info("Request is filtered");
        HttpServletRequest httpServletRequest = RequestContext.getCurrentContext().getRequest();
        log.info("request -> {} request uri -> {} ", httpServletRequest, httpServletRequest.getRequestURI());
        return null;
    }
}

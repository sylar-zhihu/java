package com.atguigu.springmvc.handler;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.atguigu.springmvc.beans.User;

@Controller // 请求处理器
public class GetPost {

    /**
     * @RequestMapping method 映射请求方式 可以定义Get,Post
     * 
     */
    @RequestMapping(value = "/testRequestMappingMethod", method = { RequestMethod.POST })
    public String testRequestMappingMethodPost() {

        System.out.println("POST");
        return "success";
    }

    /**
     * @RequestMapping method 映射请求方式,可以写多个，用逗号分隔 可以定义Get,Post
     */
    @RequestMapping(value = "/testRequestMappingMethod", method = { RequestMethod.GET })
    public String testRequestMappingMethodGet() {
        System.out.println("Get");

        return "success";
    }

}

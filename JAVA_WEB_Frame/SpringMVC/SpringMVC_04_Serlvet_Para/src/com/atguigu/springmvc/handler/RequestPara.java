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
public class RequestPara {


//    @RequestParam 
//     映射请求参数到请求处理方法的形参 
//     1. 如果请求参数名与形参名一致， 则可以省略@RequestParam的指定。 
//     2. @RequestParam 注解标注的形参必须要赋值,可以使用required来设置为不是必须的。 
//     3.可以使用defaultValue来指定一个默认值取代null 
//     客户端的请求:testRequestParam?username=Tom&age=22
    @RequestMapping("/testRequestParam")
    public String testRequestParam(@RequestParam("username") String username, @RequestParam(value = "age", required = false, defaultValue = "0") int age) {
        // web: request.getParameter() request.getParameterMap()
        System.out.println(username + " , " + age);
        return "success";
    }



}

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

@Controller // 请求处理器
@RequestMapping(value = "/springmvc")
public class ClassRequestMapping {

    /**
     * 测试原生的Servlet API
     * 
     * @throws IOException
     * @throws ServletException
     */
    @RequestMapping("/testClassMapping")
    public String testClassMapping() {

        System.out.println("ClassMapping");
        return "success";

    }

}

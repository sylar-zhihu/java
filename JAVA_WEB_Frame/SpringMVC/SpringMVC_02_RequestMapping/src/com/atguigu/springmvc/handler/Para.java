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
// @RequestMapping(value = "/springmvc")
public class Para {

    /**
     * @RequestMapping 映射请求参数 以及 请求头信息
     *  params : 表示必须有这些参数
     *  !username 表示不能有这个参数
     */

    @RequestMapping(value = "/testRequestMappingParamsAndHeaders", params = { "username", "age=22" })
    public String testRequestMappingParamsAndHeaders() {
        System.out.println("name OK");
        return "success";
    }
    
    @RequestMapping(value = "/testRequestMappingParamsAndHeaders", params = { "!username", "age=22" })
    public String testRequestMappingParamsFlase() {
        System.out.println("noname OK");
        return "success";
    }


}

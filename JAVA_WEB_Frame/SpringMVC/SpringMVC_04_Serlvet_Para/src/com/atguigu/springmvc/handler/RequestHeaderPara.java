package com.atguigu.springmvc.handler;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestHeader;
import com.atguigu.springmvc.beans.User;

@Controller // 请求处理器
public class RequestHeaderPara {

    /**
     * @RequestHeader 映射请求头信息到请求处理方法的形参中
     */

    @RequestMapping("testRequestHeader")
    public String testRequestHeader(@RequestHeader("Accept-Language") String acceptLanguage) {
        System.out.println("acceptLanguage:" + acceptLanguage);
        return "success";
    }



}

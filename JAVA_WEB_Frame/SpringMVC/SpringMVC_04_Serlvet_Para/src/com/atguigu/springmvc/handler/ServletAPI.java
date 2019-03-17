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
public class ServletAPI {

    /**
     * 测试原生的Servlet API
     * 直接声明，就可以获取对象
     * @throws IOException
     * @throws ServletException
     */
    @RequestMapping("/testServletAPI")
    public void testServletAPI(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        System.out.println("request: " + request);
        System.out.println("response: " + response);
        // 转发
        // request.getRequestDispatcher("/WEB-INF/views/success.jsp").forward(request, response);

        // 重定向 将数据写给客户端
        // response.sendRedirect("http://www.baidu.com");
        response.getWriter().println("/springmvc/testServletAPI");
    }

  




}

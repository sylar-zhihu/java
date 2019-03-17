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
public class RestApi {

    /**
     * REST PUT
     */
    @RequestMapping(value = "/order", method = RequestMethod.PUT)
    public String testRestPUT() {
        System.out.println("REST PUT");
        return "success";
    }

    /**
     * REST POST
     */
    @RequestMapping(value = "/order", method = RequestMethod.POST)
    public String testRestPOST() {
        System.out.println("REST POST");

        return "success";
    }

    /**
     * REST DELETE
     */
    @RequestMapping(value = "/order/{id}", method = RequestMethod.DELETE)
    public String testRestDELETE(@PathVariable("id") Integer id) {
        System.out.println("REST DELETE: " + id);
        return "success";
    }

    /**
     * REST GET
     */
    @RequestMapping(value = "/order/{id}", method = RequestMethod.GET)
    public String testRestGET(@PathVariable("id") Integer id) {
        System.out.println("REST GET: " + id);
        return "success";
    }



}

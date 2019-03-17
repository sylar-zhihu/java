package hello;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 请求处理器 / 控制器
 *
 */
@Controller
public class SpringMVCHelloHandler {

    /**
     * http://localhost:8080/SpringMvc_01_Hello/hello
     * 
     * @RequestMapping: 完成请求 与 请求处理方法的映射.
     * 
     */
    @RequestMapping(value = "/hello")
    public String handleHello() {
        System.out.println("Hello SpringMVC ");
        return "success"; // 通过视图解析器解析得到具体的视图， 再转发去往该视图.
    }
}

package model.component;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import cn.itcast.springboot.javaconfig.SpringConfig;
import cn.itcast.springboot.javaconfig.User;
import cn.itcast.springboot.javaconfig.UserService;

/**
 * @author asus
 * 测试非xml的用法
 */
public class Main {
    
    public static void main(String[] args) {
        // 通过Java配置来实例化Spring容器 相当于得到xml文件
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);
        
        // 在Spring容器中获取Bean对象
        UserService userService = context.getBean(UserService.class);
        
        // 调用对象中的方法
        List<User> list = userService.queryUserList();
        for (User user : list) {
            System.out.println(user.getUsername() + ", " + user.getPassword() + ", " + user.getPassword());
        }
        
        // 销毁该容器
        context.destroy();
    }

}

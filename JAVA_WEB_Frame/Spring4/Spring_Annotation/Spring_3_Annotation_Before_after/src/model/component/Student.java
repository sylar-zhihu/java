package model.component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/*
 * 作者:
 * 日期:2018年4月17日:下午10:11:58
 * 程序作用:
**/
// bean注解
@Component("student")
// 单利 还是多利
@Scope("prototype")  
public class Student {
    // 注入属性 set方法和成员变量上都行
    @Value("sylar")
    String name;
    
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    @PostConstruct
    // 构造方法之前执行
    public void post() {
        System.out.println("执行@PostConstruct");
        
    }
    
    @PreDestroy
    // 生命结束之前 工程关闭的时候调用
    public void destroy() {
        System.out.println("执行@PreDestroy");
    }

}

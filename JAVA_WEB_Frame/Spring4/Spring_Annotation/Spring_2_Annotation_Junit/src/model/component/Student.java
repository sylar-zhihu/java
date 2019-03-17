package model.component;

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
    @Value("lijianbo")
    String name;
    
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}

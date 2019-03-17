package model.component;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/*
 * 作者:
 * 日期:2018年11月6日:下午11:20:50
 * 程序作用:
**/
@Configuration
// 配置类的注解 需要定义返回对象的方法 
public class BeanConfigure {
    
    @Bean(name="car")
    // 返回对象的注解
    public Car initCar() {
        Car car=new Car();
        car.setName("a");
        car.setPrice(1000);
        return car;
    }
    
    @Bean(name="student")
    // 返回对象的注解
    public Student initStudent() {
        Student student=new Student();
        student.setName("aab");
        return student;
    }

}

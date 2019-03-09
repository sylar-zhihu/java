package com.atguigu.spring.annotation.Component.scope;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;


@Component()
//指定对象的作用范围 singleton单例 默认就是单例
@Scope(scopeName="singleton")
public class ScopePersonSingleton {

    private String name ;



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }



    @Override
    public String toString() {
        return "ComponentPerson [name=" + name +  "]";
    }


}

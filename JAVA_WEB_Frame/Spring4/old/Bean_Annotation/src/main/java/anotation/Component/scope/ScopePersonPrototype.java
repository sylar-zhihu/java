package anotation.Component.scope;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component()
//指定对象的作用范围 多例
@Scope(scopeName="prototype")
public class ScopePersonPrototype {

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

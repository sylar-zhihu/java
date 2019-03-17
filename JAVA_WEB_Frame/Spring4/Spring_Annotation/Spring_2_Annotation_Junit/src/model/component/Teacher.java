package model.component;


import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("teacher")
public class Teacher {

    private Student student;

    public Student getStudent() {
        return student;
    }

    // 注入对象
    @Resource(name = "student")
    public void setStudent(Student student) {
        this.student = student;
    }
    
    

}

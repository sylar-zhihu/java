package model.autoWire;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

public class Teacher {

    private Student student;

    public Student getStudent() {
        return student;
    }

    @Autowired
    public void setStudent(Student student) {
        this.student = student;
    }
    
    

}

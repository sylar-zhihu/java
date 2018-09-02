package model.resource;


import javax.annotation.Resource;


public class Teacher {

    private Student student;

    public Student getStudent() {
        return student;
    }

    // 会去找name等于set后第一个字母小写的id
    @Resource// (name="student")
    public void setStudent(Student student) {
        this.student = student;
    }
    
    

}

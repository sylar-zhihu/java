package newObj;

import java.util.List;

public class Teacher {

    private String name;

    List<Student> myStudents;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Student> getMyStudents() {
        return myStudents;
    }

    public void setMyStudents(List<Student> myStudents) {
        this.myStudents = myStudents;
    }
    
    

}

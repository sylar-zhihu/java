package model;

import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

/*
 * 作者:
 * 日期:2018年4月21日:下午10:01:29
 * 程序作用:
**/
// 如果什么都不写 意味着 数据库的表就叫student
@Entity
@Table(name = "hib_1")
public class Student {

    @Id // 主键注解
    String id;

    @Column(name = "myName")// 映射属性对应的表字段
    String name;

    // 映射字段 也可以不加 默认就会加
    @Basic
    int age;
    
    @Transient // 不映射到数据库
    int age2;
    
    Date birthDay;
    
    

    public Date getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(Date birthDay) {
        this.birthDay = birthDay;
    }

    public int getAge2() {
        return age2;
    }

    public void setAge2(int age2) {
        this.age2 = age2;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

}

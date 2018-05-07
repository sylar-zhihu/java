package basic_Grammer;

/*
 * 作者:
 * 日期:2016年12月15日:下午3:09:49
 * 程序作用:如果要深复制必须实现Cloneable这个接口
**/
public class 对象拷贝 {

    public static void main(String[] args) {
        Student student1 = new Student();
        Student student2 = student1;
        System.out.println(student1 == student2);// true 直接赋值两个对象是同一个内存地址
        try {
            Student student3=(Student) student1.clone();
            System.out.println(student3 == student1);// false 深拷贝后两个对象不是同一个地址
        } catch (CloneNotSupportedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

}

class Student implements Cloneable {
    @Override
    protected Object clone() throws CloneNotSupportedException {
        // TODO Auto-generated method stub
        return super.clone();
    }

}

package 类定义;

public class 一个文件定义多个类 {

    public static void main(String[] args) {
        /*
         * 这里介绍一个文件里面定义两个类
         */
        Other_Class os = new Other_Class();
        os.bark();

    }

}

class Other_Class {

    void bark() {// 必须实现父类的抽象方法
        // TODO Auto-generated method stub
        System.out.println("狗叫");
    }
}
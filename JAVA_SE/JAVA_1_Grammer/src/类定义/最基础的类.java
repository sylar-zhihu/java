package 类定义;

/*
 * 作者:Lijianbo
 * 日期:2016年5月3日:上午11:48:15
 * 程序作用:普通的JAVA类
**/
public class 最基础的类 {
    // 定义成员变量
    int height;

    int coclor;

    // 构造方法
    public 最基础的类() {
        // TODO Auto-generated constructor stub
    }

    // 定义类方法
    private void bark() {
        // TODO Auto-generated method stub

    }

    public static void main(String[] args) {
        // 有了类然后定义一个对象
        最基础的类 dog = new 最基础的类();
        // 调用方法
        dog.bark();
    }

}

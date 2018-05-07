package 类定义.extend.demo_which;

/*
 * 作者:
 * 日期:2016年11月29日:上午9:23:55
 * 程序作用:如果接口有这个方法，子类没有调用的是父类，还是GF.
**/
public class Main {

    public static void main(String[] args) {

        Child child = new Child();
        child.show();// Father

    }

}

package thread_Demo;

/*
 * 作者:
 * 日期:2016年11月26日:下午6:56:59
 * 程序作用:
**/
public class Demo1_Extends {

    public static void main(String[] args) {
        // 启动线程
        Cat cat = new Cat();
        // 会调用run函数
        cat.start();
        // 只能启动一次 想多线程必须多个对象
//        cat.start(); // 会报错
        // 启动了一个新的线程 所以不会影响下的执行 直接输出aaaaa
        // 得到线程的名字
        Thread.currentThread().getName();
        System.out.println("aaaa");

    }

}

/**
 * 继承Thread 才能多进程
 */
class Cat extends Thread {

    // 重写run 方法
    @Override
    public void run() {
        while (true) {
            try {
                // 休息 进入 block状态 同时 释放资源 1000毫秒=1秒
                Thread.sleep(1000);
                System.out.println("hello");
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }

        }

    }

}

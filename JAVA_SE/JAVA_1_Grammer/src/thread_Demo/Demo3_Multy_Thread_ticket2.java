package thread_Demo;

/*
 * 作者:
 * 日期:2016年11月26日:下午6:56:59
 * 程序作用:多线程卖票,解决方法,共享的变量用static.但是还是会出现并发的问题。
**/
public class Demo3_Multy_Thread_ticket2 {

    public static void main(String[] args) {
        // 启动线程
        Ticket2 tickey = new Ticket2();
        Ticket2 tickey2 = new Ticket2();
        Ticket2 tickey3 = new Ticket2();
        // 会调用run函数 不会共享同一个变量
        tickey.start();
        tickey2.start();
        tickey3.start();
        // 只能启动一次 想多线程必须多个对象
        // cat.start(); // 会报错
        // 启动了一个新的线程 所以不会影响下的执行 直接输出aaaaa

    }

}

/**
 * 继承Thread 才能多进程
 */
class Ticket2 extends Thread {
    int tickeyNum = 2000;

    // 重写run 方法
    @Override
    public void run() {
        while (true) {
            try {
                // 休息 进入 block状态 同时 释放资源 1000毫秒=1秒
                Thread.sleep(1000);
                this.tickeyNum--;
                System.out.println(tickeyNum);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }

        }

    }

}

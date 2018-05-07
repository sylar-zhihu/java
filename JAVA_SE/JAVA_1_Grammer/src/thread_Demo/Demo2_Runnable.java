package thread_Demo;

/*
 * 作者:
 * 日期:2016年11月26日:下午7:35:49
 * 程序作用:
**/
public class Demo2_Runnable implements Runnable {

    public static void main(String[] args) {
        Demo2_Runnable dome2_Runnable = new Demo2_Runnable();
        Thread t = new Thread(dome2_Runnable);
        // 错误的方式 这里一个t只能start一次 想要多线程需要多个Thread对象
//        t.start();
//        t.start();// 会报错 想要多线程需要多个Thread对象
        // 正确的方式
        Thread t2 = new Thread(dome2_Runnable);
        t2.start();// 不会报错
        // 启动了一个新的线程 所以不会影响下的执行 直接输出aaaaa
        System.out.println("aaaa");

    }

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

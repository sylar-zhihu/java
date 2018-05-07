package thread_Demo;

/*
 * 作者:
 * 日期:2016年11月26日:下午6:56:59
 * 程序作用:使用锁解决并发问题
 */
public class Demo5_Join {

    public static void main(String[] args) {
        // 启动线程
        Ticket tickey = new Ticket();
        Ticket tickey2 = new Ticket();

        tickey.start();
        tickey2.start();
        // tickey  tickey2 执行完了才会向下执行
        try {
            tickey.join();
            tickey2.join();
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        // 只能启动一次 想多线程必须多个对象
        // cat.start(); // 会报错
        // 启动了一个新的线程 所以不会影响下的执行 直接输出aaaaa

    }

}

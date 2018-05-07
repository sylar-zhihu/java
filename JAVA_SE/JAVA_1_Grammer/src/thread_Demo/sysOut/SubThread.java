package thread_Demo.sysOut;

/*
 * 作者:
 * 日期:2017年4月26日:上午10:50:06
 * 程序作用:
**/
public class SubThread implements Runnable {
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

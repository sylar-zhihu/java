package thread_Demo.sysOut;

/*
 * 作者:
 * 日期:2016年11月26日:下午6:56:59
 * 程序作用:
**/
public class MainThread {

    public static void main(String[] args) throws InterruptedException {
        // 启动线程
        SubThread cat=new SubThread();
        Thread thread = new Thread(cat);
        // 会调用run函数
        thread.start();
        System.out.println("aa");


    }

}


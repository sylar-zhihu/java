package 动态代理.logTime;

import java.util.Random;

import 动态代理.Moveable;

/*
 * 作者:
 * 日期:2018年3月28日:下午1:36:33
 * 程序作用:记录方法运行的时间 修改源码
**/
public class Demo_1_ChangeCode implements Moveable {

    @Override
    public void move() {
        // 记录起始时间
        long start = System.currentTimeMillis();
        System.out.println("Tank Moving...");
        try {
            Thread.sleep(new Random().nextInt(1000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        // 记录结束时间时间
        long end = System.currentTimeMillis();
        System.out.println("运行耗时"+(end - start));

    }

}

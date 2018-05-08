package 动态代理.logTime;

import java.util.Random;

import 动态代理.Moveable;
import 动态代理.Tank;

/*
 * 作者:
 * 日期:2018年3月28日:下午1:36:33
 * 程序作用:记录方法运行的时间 实现同一个接口
**/
public class Demo_3_Interface implements Moveable {

    Tank tank;
    
    public Demo_3_Interface(Tank tank) {
        this.tank = tank;
    }

    @Override
    public void move() {
        // 记录起始时间
        long start = System.currentTimeMillis();
        // 调用父类方法
        tank.move();
        // 记录结束时间时间
        long end = System.currentTimeMillis();
        System.out.println("运行耗时" + (end - start));

    }

}

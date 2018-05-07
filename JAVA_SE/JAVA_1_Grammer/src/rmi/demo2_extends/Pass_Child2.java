package rmi.demo2_extends;

import java.io.Serializable;

/*
 * 作者:
 * 日期:2016年11月28日:下午9:48:46
 * 程序作用:
**/
public class Pass_Child2 extends Pass_Father implements Serializable {

    public void SendMsg() {
        System.out.println("child");

    }

}

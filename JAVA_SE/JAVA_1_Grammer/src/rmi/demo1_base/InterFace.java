package rmi.demo1_base;

import java.rmi.Remote;
import java.rmi.RemoteException;

/*
 * 作者:
 * 日期:2016年11月25日:下午9:41:17
 * 程序作用:借口里面方法才能远程调用 必须要继承Remote 方法
 * 必须申明一个异常
**/
public interface InterFace  extends Remote{
    
     // 自己定义一个方法 得到server time 必须申明一个异常 RemoteException
    public long getServerTime() throws RemoteException;
    

}

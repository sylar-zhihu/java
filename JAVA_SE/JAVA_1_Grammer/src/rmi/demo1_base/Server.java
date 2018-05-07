package rmi.demo1_base;

import java.rmi.RemoteException;
import java.rmi.server.RMIClientSocketFactory;
import java.rmi.server.RMIServerSocketFactory;
import java.rmi.server.UnicastRemoteObject;

/*
 * 作者:
 * 日期:2016年11月25日:下午9:44:47
 * 程序作用:server 类必须继承UnicastRemoteObject 同时实现远程调用的接口
**/
public class Server  extends UnicastRemoteObject implements InterFace{

    private static final long serialVersionUID = 7822666550352167667L;

    // 直接生成构造方法
    protected Server()
            throws RemoteException {
        // TODO Auto-generated constructor stub
    }

    @Override
    // 实现接口的方法
    public long getServerTime() throws RemoteException {
        // TODO Auto-generated method stub
        return System.currentTimeMillis();
    }


}

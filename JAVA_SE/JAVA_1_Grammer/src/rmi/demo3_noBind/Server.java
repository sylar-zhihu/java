package rmi.demo3_noBind;

import java.rmi.RemoteException;
import java.rmi.server.RMIClientSocketFactory;
import java.rmi.server.RMIServerSocketFactory;
import java.rmi.server.UnicastRemoteObject;

/*
 * 作者:
 * 日期:2016年11月25日:下午9:44:47
 * 程序作用:server 类必须继承UnicastRemoteObject 同时实现远程调用的接口
**/
public class Server extends UnicastRemoteObject implements InterFace_Server {

    InterFace_Client clinet_Rmi_Obj;

    // 直接生成构造方法
    protected Server() throws RemoteException {
        // TODO Auto-generated constructor stub
    }

    @Override
    public void sendObj(InterFace_Client clinet_Rmi_Obj) throws RemoteException {
        this.clinet_Rmi_Obj=clinet_Rmi_Obj;
    }

}

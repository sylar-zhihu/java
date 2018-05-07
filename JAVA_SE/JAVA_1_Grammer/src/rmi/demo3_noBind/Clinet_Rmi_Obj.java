package rmi.demo3_noBind;

import java.io.Serializable;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/*
 * 作者:
 * 日期:2016年11月28日:下午9:48:46
 * 程序作用:
**/
public class Clinet_Rmi_Obj extends UnicastRemoteObject implements InterFace_Client, Serializable {

    protected Clinet_Rmi_Obj() throws RemoteException {
        // TODO Auto-generated constructor stub
    }

    @Override
    public void showInfo() throws RemoteException {
        System.out.println("不知道这句话会在哪出现。出现在客户端就对了");
        
    }

}

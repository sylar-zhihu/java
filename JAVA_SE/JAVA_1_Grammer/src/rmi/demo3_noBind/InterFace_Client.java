package rmi.demo3_noBind;

import java.rmi.Remote;
import java.rmi.RemoteException;

/*
 * 作者:
 * 日期:2016年11月28日:下午11:05:26
 * 程序作用:
**/
public interface InterFace_Client extends Remote {
    public void showInfo() throws RemoteException;

}

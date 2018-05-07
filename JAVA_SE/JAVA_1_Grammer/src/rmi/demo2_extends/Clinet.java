package rmi.demo2_extends;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

/*
 * 作者:
 * 日期:2016年11月25日:下午10:14:41
 * 程序作用:客户端，调用服务器端的程序
**/
public class Clinet {

    public static void main(String[] args) {
        try {
            // 通过名字查找对应的server 把返回的对象直接转成接口  通过url调用
            InterFace server = (InterFace)Naming.lookup("rmi://localhost:2005/tt");
            Pass_Father father=new Pass_Child2();
            server.sendObj(father);
            
        } catch (MalformedURLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (RemoteException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (NotBoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

}

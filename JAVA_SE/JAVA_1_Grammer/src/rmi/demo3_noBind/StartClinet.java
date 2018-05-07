package rmi.demo3_noBind;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

/*
 * 作者:
 * 日期:2016年11月25日:下午10:14:41
 * 程序作用:客户端，调用服务器端的程序
**/
public class StartClinet {

    public static void main(String[] args) {
        try {
            // 通过名字查找对应的server 把返回的对象直接转成接口  通过url调用
            InterFace_Server server = (InterFace_Server)Naming.lookup("rmi://localhost:2005/tt");
            // 生成了一个客户端对象
            InterFace_Client clinet_Rmi_Obj =new Clinet_Rmi_Obj();
            // 把这个对象加入到服务器端的对象中;
            server.sendObj(clinet_Rmi_Obj);
            
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

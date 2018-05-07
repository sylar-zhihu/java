package rmi.demo1_base;

import java.net.MalformedURLException;
import java.rmi.AlreadyBoundException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;

/*
 * 作者:
 * 日期:2016年11月25日:下午10:06:18
 * 程序作用:启动server类
**/
public class StartServer {

    public static void main(String[] args) {
        try {
            Server server=new Server();
            // 绑定一个名字
//            Naming.bind("tt", server);
            
            // 起一个本地服务 用来绑定
            LocateRegistry.createRegistry(2005);
            // 如果有了tt对象 就替换 用bind如果已经绑定了会报错 使用rebind更好
            Naming.rebind("//localhost:2005/tt", server);
            
            System.out.println("down");
        } catch (RemoteException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (MalformedURLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            }

    }

}

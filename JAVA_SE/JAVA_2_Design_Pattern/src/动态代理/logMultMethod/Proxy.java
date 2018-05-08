package 动态代理.logMultMethod;

import java.io.File;
import java.io.FileWriter;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.net.URL;
import java.net.URLClassLoader;

import javax.tools.JavaCompiler;
import javax.tools.JavaCompiler.CompilationTask;

import 动态代理.InvocationHandler;

import javax.tools.StandardJavaFileManager;
import javax.tools.ToolProvider;
/*
 * 作者:
 * 日期:2018年3月28日:下午2:59:11
 * 程序作用:模拟JAVA的动态代理
**/
public class Proxy {
    
    /**
     * 作者：
     * 用途说明：用来产生代理类
     * @param infce
     * @param h
     * @return
     * @throws Exception
     */
    public static Object newProxyInstance(Class infce, InvocationHandler h) throws Exception { // JDK6
                                                                                             // API,
        String methodStr = "";
        String rt = "\r\n";

        Method[] methods = infce.getMethods();
        /*
         * for(Method m : methods) { methodStr += "@Override" + rt + "public void " + m.getName() +
         * "() {" + rt + "   long start = System.currentTimeMillis();" + rt +
         * "   System.out.println(\"starttime:\" + start);" + rt + "   t." + m.getName() + "();" +
         * rt + "   long end = System.currentTimeMillis();" + rt +
         * "   System.out.println(\"time:\" + (end-start));" + rt + "}"; }
         */
        for (Method m : methods) {
            methodStr += "@Override" + rt + "public void " + m.getName() + "() {" + rt + "    try {" + rt + "    Method md = " + infce.getName() + ".class.getMethod(\"" + m.getName() + "\");" + rt + "    h.invoke(this, md);" + rt + "    }catch(Exception e) {e.printStackTrace();}" + rt +

                    "}";
        }

        String src = "package com.bjsxt.proxy;" + rt + "import java.lang.reflect.Method;" + rt + "public class $Proxy1 implements " + infce.getName() + "{" + rt + "    public $Proxy1(InvocationHandler h) {" + rt + "        this.h = h;" + rt + "    }" + rt +

                "    com.bjsxt.proxy.InvocationHandler h;" + rt +

                methodStr + "}";
        String fileName = "d:/src/com/bjsxt/proxy/$Proxy1.java";
        File f = new File(fileName);
        FileWriter fw = new FileWriter(f);
        fw.write(src);
        fw.flush();
        fw.close();

        // compile
        JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
        StandardJavaFileManager fileMgr = compiler.getStandardFileManager(null, null, null);
        Iterable units = fileMgr.getJavaFileObjects(fileName);
        CompilationTask t = compiler.getTask(null, fileMgr, null, null, null, units);
        t.call();
        fileMgr.close();

        // load into memory and create an instance
        URL[] urls = new URL[] { new URL("file:/" + "d:/src/") };
        URLClassLoader ul = new URLClassLoader(urls);
        Class c = ul.loadClass("com.bjsxt.proxy.$Proxy1");
        System.out.println(c);

        Constructor ctr = c.getConstructor(InvocationHandler.class);
        Object m = ctr.newInstance(h);
        // m.move();

        return m;
    }
}

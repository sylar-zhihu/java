package 泛型.test;

import static org.junit.Assert.*;

import org.junit.Test;

import 泛型.Generic;

/*
 * 作者:
 * 日期:2018年5月7日:下午2:09:44
 * 程序作用:
**/
public class GenericTest {

    @Test
    //  基本使用测试
    public void test1() {
        // 使用的时候要指定类型
        Generic<String> generic = new Generic<String>("111111");
        Generic<Integer> generic1 = new Generic<Integer> (4444);


        System.out.println("key is " + generic.getKey());
        System.out.println("key is " + generic1.getKey());

    }
    
    @Test
    // 得到传入参数的类型
    public void test2() {
        // 使用的时候要指定类型
        Generic<String> generic = new Generic<String>("111111");
        Generic<Integer> generic1 = new Generic<Integer> (4444);
        
         generic.getTClass();// java.lang.String
         generic1.getTClass();// java.lang.Integer

    }

}

package server;

import static org.hamcrest.CoreMatchers.is;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/*
 * 作者:
 * 日期:2019年1月23日:下午9:23:14
 * 程序作用:
**/
public class TestCalculate {

    Calculate cal;

    // 执行任意一个方法之前都会执行Setup方法
    @Before
    public void setUp() {
        cal = new Calculate();
    }

    // 测试异常
    @Test(expected=java.lang.ArithmeticException.class,timeout=100)
    public void testException() {
        System.out.println(8/0);
    }
    
  
    
   
    
  
    
    

}

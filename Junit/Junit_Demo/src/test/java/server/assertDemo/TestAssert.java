package server.assertDemo;

import static org.hamcrest.CoreMatchers.is;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import server.Calculate;

/*
 * 作者:
 * 日期:2019年1月23日:下午9:23:14
 * 程序作用:
**/
public class TestAssert {

    Calculate cal;

    // 执行任意一个方法之前都会执行Setup方法
    @Before
    public void setUp() {
        cal = new Calculate();
    }

    // @Test表示是单元测试
    @Test
    public void testAdd() {
        int rel = cal.add(12, 22);
        // 断言 参数:出错的提示 方法的返回值 期望值
        Assert.assertEquals("加法有问题", rel, 34);
    }
    
    @Test
    public void testTrue() {
        // 断言 参数:出错的提示 方法的返回值 期望值
        Assert.assertTrue("判断失败",4>3);
    }
    
    @Test
    public void testAssertThat() {
        int a=8;
        // 断言 参数:出错的提示 方法的返回值 期望值
        Assert.assertThat("值不对",a, is(9));
    }
    
    

}

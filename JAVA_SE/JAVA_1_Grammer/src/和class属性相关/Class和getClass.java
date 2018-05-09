package 和class属性相关;

import static org.junit.Assert.*;

import org.junit.Test;

/*
 * 作者:
 * 日期:2018年5月7日:下午2:32:17
 * 程序作用:
**/
public class Class和getClass {

    @Test
    public void test() {
        // 一个是静态，一个是非静态
        System.out.println(Integer.class.getName());
        Integer integer=new Integer(9);
        System.out.println(integer.getClass().getName());
    }

}

package 类属性;

import static org.junit.Assert.*;

import org.junit.Test;

/*
 * 作者:
 * 日期:2018年5月7日:下午2:32:17
 * 程序作用:
**/
public class 类的包全路径 {

    @Test
    public void test() {
        // 类的包全路径
        System.out.println(Integer.class.getName());// java.lang.Integer
        // 类名
        System.out.println(Integer.class.getSimpleName());// Integer
    }

}

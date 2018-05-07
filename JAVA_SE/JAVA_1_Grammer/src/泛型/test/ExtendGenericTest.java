package 泛型.test;

import static org.junit.Assert.*;

import org.junit.Test;

import 泛型.Book;
import 泛型.ExtendGeneric;

/*
 * 作者:
 * 日期:2018年5月7日:下午5:29:50
 * 程序作用:
**/
public class ExtendGenericTest {

    @Test
    // 子类对象 调用父类方法 在父类中显示子类传入的参数
    public void test() {
        Book book=new Book("123");
        
        ExtendGeneric extendGeneric=new ExtendGeneric(book);
        extendGeneric.getTClass();
    }

}

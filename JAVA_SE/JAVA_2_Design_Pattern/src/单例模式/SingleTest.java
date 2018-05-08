package 单例模式;

import org.junit.Test;

/*
 * 作者:
 * 日期:2018年3月28日:下午1:36:33
 * 程序作用:
**/
public class SingleTest {

    @Test
    public void test() {
        /*
         * 在其他对象中调用单例 因为构造方法不公开无法new对象 只能用静态的getInstance
         */
        Single pattern = Single.getInstance();
    }

}

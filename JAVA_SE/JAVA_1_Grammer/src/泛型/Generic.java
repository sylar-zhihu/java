package 泛型;

/*
 * 作者:
 * 日期:2018年5月7日:下午2:09:16
 * 程序作用:
**/
public class Generic<T> {
    // key这个成员变量的类型为T,T的类型由外部指定
    private T key;

    public Generic(T key) { // 泛型构造方法形参key的类型也为T，T的类型由外部指定
        this.key = key;
    }

    public T getKey() { // 泛型方法getKey的返回值类型为T，T的类型由外部指定
        return key;
    }

    public void getTClass() {
        System.out.println(key.getClass().getName());
    }

}
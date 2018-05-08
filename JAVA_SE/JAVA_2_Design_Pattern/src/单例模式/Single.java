package 单例模式;

/*
 * date:2016年4月28日
 * time:下午4:15:26
 * 单例模式，只会生成一个实例对象
**/

public class Single {
    /*
     * 单例模式，只会生成一个实例对象
     */
    private static Single instance = null;

    // 私有构造方法外部不能访问
    private Single() {
        // TODO Auto-generated constructor stub
    }

    // 静态方法，通过类名去掉用 synchronized 防止多个线程同时访问
    public static synchronized Single getInstance() {
        if (Single.instance == null) {
            instance = new Single();
        }
        return instance;
    }

}
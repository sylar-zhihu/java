package 动态代理.JDKProxy;

public class UserDaoImpl implements UserDao {

    public void add() {
        System.out.println("添加用户...");
    }

    public void update() {
        System.out.println("修改用户...");
    }

}

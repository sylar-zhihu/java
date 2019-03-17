package spring;

/**
 * 用户管理DAO层实现类
 * 
 * @author jt
 *
 */
public class UserDAOImpl implements UserDAO {

    @Override
    public void save() {
        System.out.println("UserDAOImpl执行了 save ...");
    }

}

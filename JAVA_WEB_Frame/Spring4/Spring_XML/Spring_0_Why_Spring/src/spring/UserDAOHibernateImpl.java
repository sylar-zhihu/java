package spring;

public class UserDAOHibernateImpl implements UserDAO {

    @Override
    public void save() {
        System.out.println("UserDAOHibernateImpl执行了.save");
    }

}

package service;

import dao.UserDAO;
import model.User;
/*
 * 作者:
 * 日期:2018年3月27日:下午1:34:31
 * 程序作用: 和User相关的操作
**/

public class UserService {
    private UserDAO userDAO;

    public void add(User user) {
        userDAO.save(user);
    }

    public UserDAO getUserDAO() {
        return userDAO;
    }

    public void setUserDAO(UserDAO userDAO) {
        this.userDAO = userDAO;
    }
}

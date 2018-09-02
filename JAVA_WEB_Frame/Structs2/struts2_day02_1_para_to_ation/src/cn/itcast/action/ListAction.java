package cn.itcast.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import cn.itcast.domain.User;

import com.opensymphony.xwork2.ActionSupport;

public class ListAction extends ActionSupport {

    private List<User> users;

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    @Override
    public String execute() throws Exception {

        System.out.println(users);

        return null;
    }
}

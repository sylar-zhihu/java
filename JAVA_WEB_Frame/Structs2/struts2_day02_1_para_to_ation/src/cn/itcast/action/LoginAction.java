package cn.itcast.action;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

public class LoginAction extends ActionSupport {

    @Override
    public String execute() throws Exception {
        // 通过request对象来获取参数
        // 1.获取请求参数
        HttpServletRequest request = ServletActionContext.getRequest();

        String username = request.getParameter("username");
        String password = request.getParameter("password");

        // 2.判断用户名与密码是否正确
        if ("tom".equals(username) && "123".equals(password)) {

            request.getSession().setAttribute("username", username);

            return SUCCESS;
        } else {
            request.setAttribute("login.message", "用户名或密码错误");
            return "failer";
        }
    }
}

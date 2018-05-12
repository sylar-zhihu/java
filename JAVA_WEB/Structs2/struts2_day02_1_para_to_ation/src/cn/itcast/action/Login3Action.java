package cn.itcast.action;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import cn.itcast.domain.User;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

//获取请求参数  模型驱动  
public class Login3Action extends ActionSupport implements ModelDriven<User> {

	private User user = new User();
	// 实现了这个接口
	public User getModel() {
		return user;
	}

    
	@Override
	public String execute() throws Exception {
		HttpServletRequest request = ServletActionContext.getRequest();
		// 2.判断用户名与密码是否正确
		if ("tom".equals(user.getUsername())
				&& "123".equals(user.getPassword())) {

			request.getSession().setAttribute("username", user.getUsername());

			return SUCCESS;
		} else {
			request.setAttribute("login.message", "用户名或密码错误");
			return "failer";
		}
	}

}

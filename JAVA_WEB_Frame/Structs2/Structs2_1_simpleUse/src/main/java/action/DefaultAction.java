package action;

import com.opensymphony.xwork2.ActionSupport;

/*
 * 作者:
 * 日期:2018年5月12日:下午6:47:55
 * 程序作用:
**/
public class DefaultAction extends ActionSupport {

    @Override
    public String execute() throws Exception {
        System.out.println("默认访问这个方法");
        System.out.println("又跳回到default.jsp");
        return this.SUCCESS;
    }

}

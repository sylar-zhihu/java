package action;

import com.opensymphony.xwork2.Action;

public class IndexAction implements Action {

    public String add() {
        System.out.println("IndexAction add");
        return "success";
    }

    @Override
    public String execute() throws Exception {
        // TODO Auto-generated method stub
        return null;
    }
}

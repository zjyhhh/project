package servlet.action;

import servlet.data.xueqi;
import servlet.json.core.ListObject;
import servlet.json.responseUtils.ResponseUtils;
import servlet.json.status.StatusHouse;
import servlet.json.utils.JackJsonUtils;
import servlet.model.xq;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "term")
public class term extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession httpSession = request.getSession();
        String teacherNum = httpSession.getAttribute("TeacherNum").toString();
       // System.out.println(teacherNum);
        List<xq> list = xueqi.getAlLterm(teacherNum);
        ListObject listObject=new ListObject();
        listObject.setItems(list);
        listObject.setStatusObject(StatusHouse.COMMON_STATUS_OK);
        String responseText = JackJsonUtils.toJson(listObject);
        ResponseUtils.renderJson(response, responseText);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}

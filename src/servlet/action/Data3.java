package servlet.action;

import servlet.data.jxrwb;
import servlet.json.core.ListObject;
import servlet.json.responseUtils.ResponseUtils;
import servlet.json.status.StatusHouse;
import servlet.json.utils.JackJsonUtils;
import servlet.model.lilunkejiaoxue;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "Data3")
public class Data3 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession httpSession = request.getSession();
        String teacherNum = httpSession.getAttribute("TeacherNum").toString();
        System.out.println(teacherNum);
        //String teachernum = request.getParameter("TeacherNum");
        String xueq = request.getParameter("ChooseSemesterData");
       // System.out.println(teachernum);
        List<lilunkejiaoxue> list = jxrwb.getAlllilunkejiaoxue(teacherNum,xueq);
        ListObject listObject=new ListObject();
        listObject.setItems(list);
        listObject.setStatusObject(StatusHouse.COMMON_STATUS_OK);
        String responseText = JackJsonUtils.toJson(listObject);
        ResponseUtils.renderJson(response, responseText);
    }
}

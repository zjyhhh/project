package servlet.action;

import servlet.data.DBHelper;
import servlet.json.responseUtils.ResponseUtils;
import servlet.json.utils.JackJsonUtils;
import servlet.model.yesOrNot;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;


@WebServlet(name = "login")
public class login extends HttpServlet{
    protected void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
        String data = request.getParameter("TeacherNumberValue");
       //String data="2017012";
        int key = 0;
        //
        try {
            String sql9 = "select JSZGH from jskcb";
            DBHelper db9 = new DBHelper(sql9);
            ResultSet ret9 = db9.pst.executeQuery();
            while (ret9.next())
            {
                String JSZGH;
                JSZGH=ret9.getString(1);
                if(JSZGH.equals(data))
                {
                    key = 1;
                    break;
                }
            }
            ret9.close();
            db9.close();
        }
        catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        if(key == 1)
        {
           // request.getRequestDispatcher("/TeacherSum/html/TeacherSum.html").forward(request,response);
            HttpSession session = request.getSession();
            session.setAttribute("TeacherNum",data);
            yesOrNot test = new yesOrNot();
            test.setData("yes");
            String responseText = JackJsonUtils.toJson(test);
            ResponseUtils.renderJson(response, responseText);
            return;
        }
        else{
            yesOrNot test = new yesOrNot();
            test.setData("no");
            String responseText = JackJsonUtils.toJson(test);
            ResponseUtils.renderJson(response, responseText);
            return;
        }
    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            doPost(request, response);
        }
    }


package servlet.action;

import servlet.data.DBHelper;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.ResultSet;
import java.sql.SQLException;

@WebServlet(name = "login")
public class login extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String data = request.getParameter("TeacherNumberValue");
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
            return;
        }
        else{
             request.getRequestDispatcher("/TeacherSum/html/TeacherSum.html").forward(request,response);
        }
    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            doPost(request, response);
        }
    }


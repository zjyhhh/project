package servlet.action;

import com.sun.corba.se.spi.ior.Writeable;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.InputStream;
import java.io.FileInputStream;
import java.io.OutputStream;
import java.io.File;
import java.lang.reflect.Array;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Map;

import com.sun.xml.internal.bind.v2.runtime.unmarshaller.XsiNilLoader;
import jxl.Workbook;
import jxl.write.*;


@WebServlet(name = "buildExcel")
public class buildExcel extends HttpServlet {
    private static final long serialVersionUID = 1L;
    public buildExcel() {
        super();
        // TODO Auto-generated constructor stub
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取表单数据
        HttpSession httpSession = request.getSession();
        String teacherNum = httpSession.getAttribute("TeacherNum").toString();
        String data = request.getParameter("arr");
        System.out.println(data);
        String filename = teacherNum + ".xls";

//        String[] linedata = data.split("|");
//        for(int num=0;num<linedata.length;num++){
//            String[] oneline = linedata[num].split(",");


        //生成Excel表
        WritableWorkbook writableWorkbook = Workbook.createWorkbook(new File("C:\\Users\\ZJY\\Desktop\\project\\web\\download\\" + filename));
        WritableSheet writableSheet = writableWorkbook.createSheet("这是页数", 0);
        //设置第一列的长度
        writableSheet.setColumnView(0, 30);
        writableSheet.setColumnView(1, 10);
        writableSheet.setColumnView(2, 10);
        writableSheet.setColumnView(3, 10);
        try {
            double sum=0;
            //生成表头
            Label h1 = new Label(0, 0, "课程名称");
            Label h2 = new Label(1, 0, "年计划学时");
            Label h3 = new Label(2, 0, "年计划学分");
            Label h4 = new Label(3, 0, "学生人数");
            Label h5 = new Label(4, 0, "k0");
            Label h6 = new Label(5, 0, "k1");
            Label h7 = new Label(6, 0, "k2");
            Label h8 = new Label(7, 0, "B");
            Label h9 = new Label(8, 0, "C");
            Label h10 = new Label(9, 0, "小计");
            writableSheet.addCell(h1);
            writableSheet.addCell(h2);
            writableSheet.addCell(h3);
            writableSheet.addCell(h4);
            writableSheet.addCell(h5);
            writableSheet.addCell(h6);
            writableSheet.addCell(h7);
            writableSheet.addCell(h8);
            writableSheet.addCell(h9);
            writableSheet.addCell(h10);

            String[] linedata = data.split("-,");
            for (int num = 0; num < linedata.length; num++) {
                String[] oneline = linedata[num].split(",");
                Label label1 = new Label(0, num + 1, oneline[0]);
                Label label2 = new Label(1, num + 1, oneline[1]);
                Label label3 = new Label(2, num + 1, oneline[2]);
                Label label4 = new Label(3, num + 1, oneline[3]);
                Label label5 = new Label(4, num + 1, oneline[4]);
                Label label6 = new Label(5, num + 1, oneline[5]);
                Label label7 = new Label(6, num + 1, oneline[6]);
                Label label8 = new Label(7, num + 1, oneline[7]);
                Label label9 = new Label(8, num + 1, oneline[8]);
                Label label10 = new Label(9, num + 1, oneline[9]);
                sum += Double.parseDouble(oneline[9]);
                writableSheet.addCell(label1);
                writableSheet.addCell(label2);
                writableSheet.addCell(label3);
                writableSheet.addCell(label4);
                writableSheet.addCell(label5);
                writableSheet.addCell(label6);
                writableSheet.addCell(label7);
                writableSheet.addCell(label8);
                writableSheet.addCell(label9);
                writableSheet.addCell(label10);
            }
            Label totalname = new Label(8,linedata.length+1,"总计");
            Label totaldata = new Label(9,linedata.length+1,String.valueOf(sum));
            writableSheet.addCell(totaldata);
            writableSheet.addCell(totalname);
            writableWorkbook.write();
            writableWorkbook.close();
        } catch (Exception E) {
            E.printStackTrace();
        }
//        //设置文件MIME类型
//        response.setContentType(getServletContext().getMimeType(filename));
//        //设置Content-Disposition
//        response.setHeader("Content-Disposition", "attachment;filename=" + filename);
//        //获取目标文件的绝对路径,不使用Tomcat的文件
//        File file = new File("C:\\Users\\ZJY\\Desktop\\project\\web\\buildExcel\\" + filename);
//        //读取文件
//        FileInputStream in = new FileInputStream(file);
//        OutputStream out = response.getOutputStream();
//        byte buffer[] = new byte[1024];
//        int len = 0;
//        while ((len = in.read(buffer)) > 0) {
//            out.write(buffer, 0, len);
//        }
//        in.close();
//        out.close();
//    }
    }
}


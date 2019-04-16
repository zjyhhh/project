package servlet.action;

import com.sun.corba.se.spi.ior.Writeable;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.io.FileInputStream;
import java.io.OutputStream;
import java.io.File;
import java.net.URLEncoder;
import java.util.Map;

import com.sun.xml.internal.bind.v2.runtime.unmarshaller.XsiNilLoader.Array;
import com.sun.xml.internal.bind.v2.runtime.unmarshaller.XsiNilLoader;
import jxl.Workbook;
import jxl.write.*;


@WebServlet(name = "download")
public class download extends HttpServlet {
    private static final long serialVersionUID = 1L;
    public download() {
        super();
        // TODO Auto-generated constructor stub
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取表单数据
        String data = request.getParameter("arr");
        System.out.println(data);
//        String filename ="test"+".xls";
//        //生成Excel表
//        WritableWorkbook writableWorkbook = Workbook.createWorkbook(new File("/Volumes/data/IdeaProject/downloadtest/web/download/"+filename));
//        WritableSheet  writableSheet =writableWorkbook.createSheet("这是页数",0);
//        //设置第一列的长度
//        writableSheet.setColumnView(0,30);
//        try {
//            //生成表头
//            for (int i = 0; i < 4; i++) {
//                if (i == 0) {
//                    Label label1 = new Label(0, 0, "课程名称");
//                    Label label2 = new Label(1, 0, "年计划学时");
//                    Label label3 = new Label(2, 0, "年计划学分");
//                    Label label4 = new Label(2, 0, "学生人数");
//                    Label label5 = new Label(2, 0, "k0");
//                    Label label6 = new Label(2, 0, "k1");
//                    Label label7 = new Label(2, 0, "k2");
//                    Label label8 = new Label(2, 0, "B");
//                    Label label9 = new Label(2, 0, "C");
//                    writableSheet.addCell(label1);
//                    writableSheet.addCell(label2);
//                    writableSheet.addCell(label3);
//                    writableSheet.addCell(label4);
//                    writableSheet.addCell(label5);
//                    writableSheet.addCell(label6);
//                    writableSheet.addCell(label7);
//                    writableSheet.addCell(label8);
//                    writableSheet.addCell(label9);
//                }
////                else {
////                    Label label1 = new Label(0, 0, );
////                    Label label2 = new Label(1, 0, );
////                    Label label3 = new Label(2, 0, );
////                    Label label4 = new Label(2, 0, );
////                    Label label5 = new Label(2, 0, );
////                    Label label6 = new Label(2, 0, );
////                    Label label7 = new Label(2, 0, );
////                    Label label8 = new Label(2, 0, );
////                    Label label9 = new Label(2, 0, );
////                    writableSheet.addCell(label1);
////                    writableSheet.addCell(label2);
////                    writableSheet.addCell(label3);
////                    writableSheet.addCell(label4);
////                    writableSheet.addCell(label5);
////                    writableSheet.addCell(label6);
////                    writableSheet.addCell(label7);
////                    writableSheet.addCell(label8);
////                    writableSheet.addCell(label9);
//                //}
//                writableWorkbook.write();
//                writableWorkbook.close();
//            }
//        }
//        catch (Exception E){
//            E.printStackTrace();
//        }
//        //设置文件MIME类型
//        response.setContentType(getServletContext().getMimeType(filename));
//        //设置Content-Disposition
//        response.setHeader("Content-Disposition", "attachment;filename=" + filename);
//        //获取目标文件的绝对路径,不使用Tomcat的文件
//        File file = new File("/Volumes/data/IdeaProject/downloadtest/web/download/" + filename);
//        //读取文件
//        FileInputStream in = new FileInputStream(file);
//        OutputStream out = response.getOutputStream();
//        byte buffer[] = new byte[1024];
//        int len = 0;
//        while ((len = in.read(buffer)) > 0) {
//            out.write(buffer, 0, len);
//        }
//
//        in.close();
//        out.close();
//        return;
//    }
    }
}

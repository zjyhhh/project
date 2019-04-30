package servlet.data;

import servlet.model.lilunkejiaoxue;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class jxrwb {
    public static List<lilunkejiaoxue> getAlllilunkejiaoxue(String TeacherNum,String xueq){
        List<lilunkejiaoxue> list2 = new ArrayList<lilunkejiaoxue>();
        try {
            String sql = "select DISTINCT KCDM from jxrwb where JSZGH="+"'"+ TeacherNum+"'"+" and KHFS ='考查'";
            DBHelper db = new DBHelper(sql);
            ResultSet ret = db.pst.executeQuery();
            while (ret.next()) {
                String Subjectname,classname;
                double AnnualProgramCredit,Classattendance,E,panduan;
                StringBuffer Term2=new StringBuffer();
                lilunkejiaoxue li2=new lilunkejiaoxue();

                //Subjectname
                String sql2="select KCMC from jxrwb where KCDM ="+"'"+ret.getString(1)+"'";
                DBHelper db2 = new DBHelper(sql2);
                ResultSet ret2 = db2.pst.executeQuery();
                ret2.next();
                Subjectname=ret2.getString(1);
                ret2.close();
                db2.close();

                //Term2
                String sql3="select XN from jxrwb where KCDM ="+"'"+ret.getString(1)+"'";
                DBHelper db3 = new DBHelper(sql3);
                ResultSet ret3 = db3.pst.executeQuery();
                ret3.next();
                String sql4="select XQ from jxrwb where KCDM ="+"'"+ret.getString(1)+"'";
                DBHelper db4 = new DBHelper(sql4);
                ResultSet ret4 = db4.pst.executeQuery();
                ret4.next();
                Term2.append(ret3.getString(1));
                Term2.append("-");
                Term2.append(ret4.getString(1));
                ret3.close();
                db3.close();
                ret4.close();
                db4.close();

                //AnnualProgramCredit
//                String sql5="select XF from jxrwb where KCDM =" +"'"+ret.getString(1)+"'";
//                DBHelper db5 = new DBHelper(sql5);
//                ResultSet ret5 = db5.pst.executeQuery();
//                ret5.next();
//                AnnualProgramCredit=Double.parseDouble(ret5.getString(1));
//                ret5.close();
//                db5.close();

                //Classattendance//E
                String sql6="select SUM(RS) from jxrwb where KCDM=" +"'"+ret.getString(1)+"'";
//                DBHelper db6 = new DBHelper(sql6);
//                ResultSet ret6 = db6.pst.executeQuery();
//                ret6.next();
//                Classattendance=ret6.getInt(1);
//                if(Classattendance<21)
//                    E=1;
//                else if(Classattendance<41)
//                    E=0.6;
//                else if(Classattendance<101)
//                    E=0.3;
//                else E=0.15;
//                ret6.close();
//                db6.close();

                //panduan
                panduan=1;

                //classname
                String sql7="select BJMC from jxrwb where KCDM =" +"'"+ret.getString(1)+"'";
                DBHelper db7 = new DBHelper(sql7);
                ResultSet ret7 = db7.pst.executeQuery();
                ret7.next();
                classname=ret7.getString(1);
                ret7.close();
                db7.close();

                li2.setSubjectname(Subjectname);
                li2.setTerm2(Term2.toString());
                li2.setpanduan(panduan);
                li2.setclassname(classname);
                //li2.setAnnualProgramCredit(AnnualProgramCredit);
//                li2.setClassattendance(Classattendance);
//                li2.setE(E);

                if(li2.getTerm2().contains(xueq)) {
                    System.out.println("查询成功");
                    list2.add(li2);
                }
            }
            ret.close();
            db.close();
        }
        catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } //
        return list2;
        }
    }

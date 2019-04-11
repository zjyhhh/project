package servlet.data;

import servlet.model.lilunkejiaoxue;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 */
public class hqsj {

    /**
     *
     * @return
     */
    public static List<lilunkejiaoxue> getAlllilunkejiaoxue(String TeacherNum) {
        List<lilunkejiaoxue> list = new ArrayList<lilunkejiaoxue>();
		/*String sql = null;
		DBHelper db1 = null;
		sql = "select * from jskcb";// SQL
		db1 = new DBHelper(sql);//
		ResultSet ret = null;
		String sql="select * from jskcb";
		DBHelper db1 = new DBHelper(sql);*/

        try {
            String sql = "select DISTINCT XKKH from jskcb where JSZGH="+"'"+ TeacherNum+"'";
            System.out.println(sql);
            DBHelper db = new DBHelper(sql);
            ResultSet ret = db.pst.executeQuery();
            while (ret.next()) {
                double AnnualSchoolingHours=0,K0=0,people=0,K1=0,C=0,E=0,AnnualProgramCredit=0,AnnualProgramCredit2=0,Classattendance=0,D1=0,panduan=100;
                String Subjectname;
                StringBuffer Term2=new StringBuffer();


                //K0//term2
                String xkkh=ret.getString(1);
                String[] xkkhArray = xkkh.split("-");
                String sql2="select KCLB from jxrwb where KCDM =" + xkkhArray[3];
                DBHelper db2 = new DBHelper(sql2);
                ResultSet ret2 = db2.pst.executeQuery();
                ret2.next();
                if(ret2.getString(1).equals("专业领域课"))
                    K0=1.1;
                else
                    K0=1.0;
                String[] TermArray = xkkh.split("()");
                for(int i = 1;i<12;i++){
                    Term2.append(TermArray[i]);
                }
                ret2.close();
                db2.close();

                //AnnualSchoolingHours
                String sql8="select XF from jxrwb where KCDM =" + xkkhArray[3];
                DBHelper db8 = new DBHelper(sql8);
                ResultSet ret8 = db8.pst.executeQuery();
                ret8.next();
                AnnualSchoolingHours=Double.parseDouble(ret8.getString(1))*16;
                ret8.close();
                db8.close();


                //K1//people
                int zzz=0;
                String sql3="select sum(RS) from jskcb where XKKH=" +"'"+ret.getString(1)+"'";
                DBHelper db3 = new DBHelper(sql3);
                ResultSet ret3 = db3.pst.executeQuery();
                String sql13="select RS from jskcb where XKKH=" +"'"+ret.getString(1)+"'";
                DBHelper db13 = new DBHelper(sql13);
                ResultSet ret13 = db13.pst.executeQuery();
                while (ret13.next())
                {
                    zzz++;
                }
                ret13.close();
                db13.close();
                ret3.next();
                if(zzz>1)
                {
                    if(ret3.getInt(1)<101)
                        K1=1.0;
                    else
                        K1=1.0+ret3.getInt(1)*0.004-100*0.004;
                }
                else if(ret3.getInt(1)<51)
                    K1=1.0;
                else
                    K1=1.0+ret3.getInt(1)*0.004-50*0.004;
                people=ret3.getInt(1);
                ret3.close();
                db3.close();

                //C
                String sql4="select COUNT(RS) from jskcb where XKKH=" +"'"+ret.getString(1)+"'";
                DBHelper db4 = new DBHelper(sql4);
                ResultSet ret4 = db4.pst.executeQuery();
                ret4.next();
                C=(ret4.getInt(1)-1)*0.8;
                ret4.close();
                db4.close();

                //E//Classattendance
                String sql5="select SUM(RS) from jskcb where XKKH=" +"'"+ret.getString(1)+"'";
                DBHelper db5 = new DBHelper(sql5);
                ResultSet ret5 = db5.pst.executeQuery();
                ret5.next();
                Classattendance=ret5.getInt(1);
                if(ret5.getInt(1)<21)
                    E=1;
                else if(ret5.getInt(1)<41)
                    E=0.6;
                     else if(ret5.getInt(1)<101)
                         E=0.3;
                          else E=0.15;
                if(ret5.getInt(1)<31)
                    D1=1;
                     else if(ret5.getInt(1)<51)
                         D1=0.6;
                          else D1=0.3;
                ret5.close();
                db5.close();

                //Subjectname
                String sql6="select KCMC from jxrwb where KCDM =" + xkkhArray[3];
                DBHelper db6 = new DBHelper(sql6);
                ResultSet ret6 = db6.pst.executeQuery();
                ret6.next();
                Subjectname=ret6.getString(1);
                ret6.close();
                db6.close();

                String sql10="select FHKMMC from jxrwb where KCDM =" + xkkhArray[3];
                DBHelper db10 = new DBHelper(sql10);
                ResultSet ret10 = db10.pst.executeQuery();
                ret10.next();
                panduan=ret10.getInt(1);
                ret10.close();
                db10.close();


                //AnnualProgramCredit
                String sql7="select XF from jxrwb where KCDM =" + xkkhArray[3];
                DBHelper db7 = new DBHelper(sql7);
                ResultSet ret7 = db7.pst.executeQuery();
                ret7.next();
                AnnualProgramCredit=Double.parseDouble(ret7.getString(1));
                ret7.close();
                db7.close();


                //AnnualProgramCredit2
                String sql9="select XF from jxrwb where KCDM =" + xkkhArray[3];
                DBHelper db9 = new DBHelper(sql9);
                ResultSet ret9 = db9.pst.executeQuery();
                ret9.next();
                AnnualProgramCredit2=Double.parseDouble(ret9.getString(1));
                ret9.close();
                db9.close();

                //D1


                lilunkejiaoxue li=new lilunkejiaoxue();
                li.setAnnualSchoolingHours(AnnualSchoolingHours);
                li.setK0(K0);
                li.setK1(K1);
                li.setC(C);
                li.setE(E);
                li.setTerm2(Term2.toString());
                li.setpanduan(panduan);
                li.setSubjectname(Subjectname);
                li.setAnnualProgramCredit(AnnualProgramCredit);
                li.setAnnualProgramCredit2(AnnualProgramCredit2);
                li.setPeople(people);
                li.setClassattendance(Classattendance);
                //li.setD1(D1);
                String xueq = "2016-2017-2";
                System.out.println(li.getTerm2());
                if(li.getTerm2().contains(xueq)) {
                    System.out.println("查询成功");
                   list.add(li);
                }
                //list.add(li);
                //
            }
            ret.close();
            db.close();
        }
            catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } //

        return list;
    }

    /**
     * @param _id
     * @return
     */
    public static lilunkejiaoxue getStudentInfoById(String _id) {
        String sql = null;
        DBHelper db1 = null;
        sql = "select * from student where id =" + _id;//
        db1 = new DBHelper(sql);//
        ResultSet ret = null;
        lilunkejiaoxue students = new lilunkejiaoxue();
        try {
            ret = db1.pst.executeQuery();
            while (ret.next()) {

            } //
            ret.close();
            db1.close();//
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } //
        return students;
    }
}

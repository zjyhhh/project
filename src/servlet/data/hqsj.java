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
    public static List<lilunkejiaoxue> getAlllilunkejiaoxue() {
        List<lilunkejiaoxue> list = new ArrayList<lilunkejiaoxue>();
		/*String sql = null;
		DBHelper db1 = null;
		sql = "select * from jskcb";// SQL
		db1 = new DBHelper(sql);//
		ResultSet ret = null;
		String sql="select * from jskcb";
		DBHelper db1 = new DBHelper(sql);*/
        try {
            String sql = "select DISTINCT XKKH from jskcb";
            DBHelper db = new DBHelper(sql);
            ResultSet ret = db.pst.executeQuery();
            while (ret.next()) {
                double Njhxs=0,K0=0,K1=0,C=0,E=0,Njhxf=0,Rs=0,D1=0;
                String MC;


                //Njhxs
                String sql8 = "select * from jskcb where XKKH=" +"'"+ret.getString(1)+"'";
                DBHelper db8 = new DBHelper(sql8);
                ResultSet ret8 = db8.pst.executeQuery();
                ret8.next();
                String syqzz = ret8.getString(9);
                String[] syqzzArray = syqzz.split(",");
                for (int i = 0; i < syqzzArray.length; i++) {
                    String[] syqzzArray2 = syqzzArray[i].split("-");
                    Njhxs +=Integer.parseInt(syqzzArray2[1])-Integer.parseInt(syqzzArray2[0])+1;
                }
                String syzxs = ret8.getString(8);
                String[] syzxsArray = syzxs.split("-");
                Njhxs *= Double.parseDouble(syzxsArray[1]);
                ret8.close();
                db8.close();


                //K0
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
                ret2.close();
                db2.close();


                //K1
                String sql3="select AVG(RS) from jskcb where XKKH=" +"'"+ret.getString(1)+"'";
                DBHelper db3 = new DBHelper(sql3);
                ResultSet ret3 = db3.pst.executeQuery();
                ret3.next();
                if(ret3.getInt(1)<51)
                    K1=1.0;
                else
                    K1=1.0+ret3.getInt(1)*0.004-50*0.004;
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

                //E//Rs
                String sql5="select SUM(RS) from jskcb where XKKH=" +"'"+ret.getString(1)+"'";
                DBHelper db5 = new DBHelper(sql5);
                ResultSet ret5 = db5.pst.executeQuery();
                ret5.next();
                Rs=ret5.getInt(1);
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

                //MC
                String sql6="select KCMC from jxrwb where KCDM =" + xkkhArray[3];
                DBHelper db6 = new DBHelper(sql6);
                ResultSet ret6 = db6.pst.executeQuery();
                ret6.next();
                MC=ret6.getString(1);
                ret6.close();
                db6.close();

                //Njhxf
                String sql7="select XF from jxrwb where KCDM =" + xkkhArray[3];
                DBHelper db7 = new DBHelper(sql7);
                ResultSet ret7 = db7.pst.executeQuery();
                ret7.next();
                Njhxf=Double.parseDouble(ret7.getString(1));
                ret7.close();
                db7.close();

                //D1


                lilunkejiaoxue li=new lilunkejiaoxue();
                li.setNjhxs(Njhxs);
                li.setK0(K0);
                li.setK1(K1);
                li.setC(C);
                li.setE(E);
                li.setMC(MC);
                li.setNjhxf(Njhxf);
                li.setRs(Rs);
                li.setD1(D1);
                list.add(li);
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

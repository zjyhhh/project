package servlet.data;

import servlet.model.xq;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
public class xueqi {
    public static List<xq> getAlLterm(String teacherNum) {
        List<xq> list = new ArrayList<xq>();
        try {
            ArrayList<String> strArray = new ArrayList<String> ();
            String sql = "select DISTINCT XKKH from jskcb where JSZGH="+"'"+ teacherNum+"'";
            DBHelper db = new DBHelper(sql);
            ResultSet ret = db.pst.executeQuery();
            String teachername;
            String sql2 = "select DISTINCT JSXM from jskcb where JSZGH="+"'"+ teacherNum+"'";
            DBHelper db2 = new DBHelper(sql2);
            ResultSet ret2 = db2.pst.executeQuery();
            ret2.next();
            teachername=ret2.getString(1);
            ret2.close();
            db2.close();
            while (ret.next()) {
                StringBuffer Term=new StringBuffer();
                String Term1=ret.getString(1);
                String[] TermArray = Term1.split("()");
                for(int i = 1;i<12;i++){
                    Term.append(TermArray[i]);
                    }
                xq term = new  xq();

                term.setTeacherNum(teacherNum);
                term.setteacherName(teachername);
                if(!strArray.contains(Term.toString())){
                    strArray.add(Term.toString());
                    term.setTerm(Term.toString());
                    list.add(term);
                }


            }
            ret.close();
            db.close();
        }

        catch (SQLException e){
            e.printStackTrace();
        }
        return list;

    }

}

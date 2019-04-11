package servlet.data;

import servlet.model.xq;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
public class xueqi {
    public static List<xq> getAlLterm() {
        List<xq> list = new ArrayList<xq>();
        try {
            ArrayList<String> strArray = new ArrayList<String> ();
            String sql = "select XKKH from jskcb ";
            DBHelper db = new DBHelper(sql);
            ResultSet ret = db.pst.executeQuery();
            while (ret.next()) {
                StringBuffer Term=new StringBuffer();
                String Term1=ret.getString(1);
                String[] TermArray = Term1.split("()");
                for(int i = 1;i<12;i++){
                    Term.append(TermArray[i]);
                    }
                xq term = new  xq();
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

import servlet.data.DBHelper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class run {
    public static void main(String [] args)
    {
        try{
        String sql="select * from Student";
        DBHelper db = new DBHelper(sql);
        ResultSet resultSet = db.pst.executeQuery();
            while (resultSet.next())
                {
                    System.out.println(resultSet.getInt(1));
                    System.out.println(resultSet.getString(2));
                    System.out.println(resultSet.getInt(3));
                    System.out.println(resultSet.getInt(4));
                }
            }
        catch (SQLException e){
            e.printStackTrace();
        }
    }
}

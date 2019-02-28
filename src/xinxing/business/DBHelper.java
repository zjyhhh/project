package xinxing.business;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import com.microsoft.sqlserver.jdbc.SQLServerDriver;
/**
 */
public class DBHelper {
	
	 	/*public static final String url = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
	    public static final String name = "com.mysql.jdbc.Driver";  
	    public static final String user = "root";  
	    public static final String password = "111111";*/
	 //数据库驱动字符串
	 	public static final String name="com.microsoft.sqlserver.jdbc.SQLServerDriver";
	//数据库URL字符串
		public static final String url="jdbc:sqlserver://localhost:1433;";
	//数据库用户名
		public static final String user="jy";
	//数据库密码
		public static final String password="zjy709394";
	  
	    public Connection conn = null;  
	    public PreparedStatement pst = null;  
	  
	    public DBHelper(String sql) {  
	        try {  
	            Class.forName(name);//
	            conn = DriverManager.getConnection(url, user, password);//
	            pst = conn.prepareStatement(sql);//
	        } catch (Exception e) {  
	            e.printStackTrace();  
	        }  
	    }  
	  
	    public void close() {  
	        try {  
	            this.conn.close();  
	            this.pst.close();  
	        } catch (SQLException e) {  
	            e.printStackTrace();  
	        }  
	    }  

}

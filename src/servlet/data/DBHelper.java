package servlet.data;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;

/**
 */
public class DBHelper {

	//	 //数据库驱动字符串
//	 	public static final String name=com.microsoft.sqlserver.jdbc.SQLServerDriver;
//	//数据库URL字符串
//		public static final String url="jdbc:sqlserver://localhost:1433;";
//	//数据库用户名
//		public static final String user="jy";
//	//数据库密码
//		public static final String password="zjy709394";
//
	public Connection conn = null;
	public PreparedStatement pst = null;

	public DBHelper(String sql) {
		//数据库驱动字符串
		final String name = getDataProperties("driverName");
		//数据库URL字符串
		final String url = getDataProperties("url");
		//数据库用户名
		final String user = getDataProperties("user");
		//数据库密码
		final String password = getDataProperties("password");
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

	public String getDataProperties(String key) {
		Properties properties = new Properties();
		try {
			InputStream inputStream = new BufferedInputStream(new FileInputStream("C:\\Users\\ZJY\\Desktop\\project\\src\\dbhelper.properties"));
			properties.load(inputStream);
			String value = properties.getProperty(key);
			System.out.println(value);
			return value;
		} catch (Exception E) {
			E.printStackTrace();
			return "error";
		}
	}
}



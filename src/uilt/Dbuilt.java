package uilt;

import java.sql.DriverManager;
import java.sql.*;

public class Dbuilt {
	
	private static String jdbcDriver ="com.mysql.cj.jdbc.Driver";
	private static ReadProperties rp =ReadProperties.initial();
	
	public static Connection getConnection() {
		
		try {
			//�������ݿ�����
			Class.forName(jdbcDriver);
			//��ȡ���ݿ�����
			Connection connection = DriverManager.getConnection(rp.dbUrl, rp.dbUserName, rp.dbPassword);
			return connection;
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return null;
		
	}
}

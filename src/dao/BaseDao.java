package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import uilt.Dbuilt;

public abstract class BaseDao {

	protected Connection con = Dbuilt.getConnection();
	
	protected PreparedStatement pStatement = null;
	
	protected void close() {
		try {
			this.con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}

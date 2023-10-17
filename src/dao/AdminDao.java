package dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import View.IndexFrame;
import model.Admin;

public class AdminDao extends BaseDao {
	
	//登录系统
	public Admin selectAdmin(String name,String password) {
		String sqlStr = "select * from login where name = ? and password = ?";
		Admin admin = null;
		try {
			this.pStatement = this.con.prepareStatement(sqlStr);
			this.pStatement.setString(1, name);
			this.pStatement.setString(2, password);
			
			ResultSet executeQuery = this.pStatement.executeQuery();
			if(executeQuery.next()) {
				admin = new Admin(executeQuery.getInt(1),executeQuery.getString(2),executeQuery.getString(3));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			this.close();
		}
		return admin;
	}

	//修改密码
	public String revisePassword(Admin admin, String newPassword) {
		
		String resultStr = "操作失败";
		String sqlStr = "update login set password = ? where id = ? and name = ? and password = ?";
		try {
			this.pStatement = this.con.prepareStatement(sqlStr);
			this.pStatement.setString(1, newPassword);
			this.pStatement.setInt(2, admin.getId());
			this.pStatement.setString(3, admin.getName());
			this.pStatement.setString(4, admin.getPassword());
			if(this.pStatement.executeLargeUpdate() > 0) {
				resultStr = "操作成功！"; 
				IndexFrame.admin.setPassword(newPassword);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			this.close();
		}
		return resultStr;
	}

}

package dao;

import java.awt.List;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.Admin;
import model.Business;
import model.Payrollt;

public class BusinessDao extends BaseDao {

	// 新增企业信息
	public String addBusinessInfo(Business tempBusiness) {
		String resultStr = "新增失败";
		String sqlStr1 = "insert into business values (?,?,?,?)";

		try {
			this.pStatement = this.con.prepareStatement(sqlStr1);
			this.pStatement.setString(1, tempBusiness.getBno());
			this.pStatement.setString(2, tempBusiness.getBname());
			this.pStatement.setString(3, tempBusiness.getBlogin());
			this.pStatement.setString(4, tempBusiness.getBpassword());
			if (this.pStatement.executeUpdate() > 0) {
				resultStr = "添加成功";
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 

		String sqlStr2 = "create user ? @'localhost' identified by ?";
		try {
			this.pStatement = this.con.prepareStatement(sqlStr2);
			this.pStatement.setString(1,tempBusiness.getBlogin());
			this.pStatement.setString(2,tempBusiness.getBpassword());
			if(this.pStatement.executeUpdate() > 0 ) {
				resultStr = "成功创建用户";
			}	
		} catch (SQLException e) {
			e.printStackTrace();
		}			
		
		String sqlStr3 = "grant select on sxs.business to ? @'localhost'";
		try {
			this.pStatement = this.con.prepareStatement(sqlStr3);
			this.pStatement.setString(1,tempBusiness.getBlogin());
			if(this.pStatement.executeUpdate() > 0 ) {
				resultStr = "授权成功";
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		String sqlStr4 = "grant all privileges on sxs.payrollt to ? @'localhost'";
		try {
			this.pStatement = this.con.prepareStatement(sqlStr4);
			this.pStatement.setString(1,tempBusiness.getBlogin());
			if(this.pStatement.executeUpdate() > 0 ) {
				resultStr = "授权成功";
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			this.close();
		}
		
		return resultStr;
	}

	// 查看企业信息
	public ArrayList queryAllBusiness() {
		ArrayList<Business> array = new ArrayList<Business>();
		String sqlStr = "select * from business";
		try {
			this.pStatement = this.con.prepareStatement(sqlStr);
			ResultSet executeQuery = this.pStatement.executeQuery();
			while (executeQuery.next()) {
				Business tempBusiness = new Business();
				tempBusiness.setBno(executeQuery.getString(1));
				tempBusiness.setBname(executeQuery.getString(2));
				tempBusiness.setBlogin(executeQuery.getString(3));
				tempBusiness.setBpassword(executeQuery.getString(4));
				array.add(tempBusiness);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		finally {
			this.close();
		}
		return array;
	}

	// 条件查找
	public ArrayList<Business> querySomeBusiness(Business tempBusiness) {
		ArrayList<Business> array1 = new ArrayList<Business>();
		
		String aqlStr = "select * from business where bno like'%" + tempBusiness.getBno() + "%' and bname like'%"
				+ tempBusiness.getBname() + "%' and blogin like '%" + tempBusiness.getBlogin()
				+ "%' and bpassword like '%" + tempBusiness.getBpassword() + "%'";
		try {
			this.pStatement = this.con.prepareStatement(aqlStr);
			ResultSet executeQuery = this.pStatement.executeQuery();
			while (executeQuery.next()) {
				Business tempBusiness1 = new Business();
				tempBusiness1.setBno(executeQuery.getString(1));
				tempBusiness1.setBname(executeQuery.getString(2));
				tempBusiness1.setBlogin(executeQuery.getString(3));
				tempBusiness1.setBpassword(executeQuery.getString(4));
				array1.add(tempBusiness1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			this.close();
		}
		return array1;
	}
	
	//修改信息
	public String reviseBusiness(Business tempBusiness){
			String resultStr = "修改失败" ;
			String sqlStr1 = "update business set bname = ?, blogin = ?, bpassword = ? where bno = ?";
			try {
				this.pStatement = this.con.prepareStatement(sqlStr1);
				this.pStatement.setString(4,tempBusiness.getBno());
				this.pStatement.setString(1,tempBusiness.getBname());
				this.pStatement.setString(2,tempBusiness.getBlogin());
				this.pStatement.setString(3,tempBusiness.getBpassword());
				if(this.pStatement.executeUpdate() > 0 ) {
					 resultStr = "修改成功";
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			String sqlStr2 = "set password for ? @'localhost' = password(?)";
			try {
				this.pStatement = this.con.prepareStatement(sqlStr2);
				this.pStatement.setString(1,tempBusiness.getBlogin());
				this.pStatement.setString(2,tempBusiness.getBpassword());
				if(this.pStatement.executeUpdate() > 0 ) {
					 resultStr = "修改成功";
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally {
				this.close();
			}
			
			return resultStr;
		}

	// 删除信息
	public String deleteBusiness(String bno) {
		String resultStr = "删除失败";
		String sqlStr = "delete from business where bno = ?";
		try {
			this.pStatement = this.con.prepareStatement(sqlStr);
			this.pStatement.setString(1, bno);
			if (this.pStatement.executeUpdate() > 0) {
				resultStr = "删除成功";
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
		String sqlStr1 = "drop user ? @'localhost'";
		try {
			this.pStatement = this.con.prepareStatement(sqlStr1);
			this.pStatement.setString(1, bno);
			if(this.pStatement.executeUpdate() > 0) {
				resultStr = "删除成功";
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			this.close();
		}
		
		return resultStr;
	}

	// 查看当前企业信息
	public ArrayList queryThisBusiness(String blogin) {
		ArrayList<Business> array = new ArrayList<Business>();
		String sqlStr = "select * from business where bno = '"+blogin+"'" ;
		
		try {
			this.pStatement = this.con.prepareStatement(sqlStr);
			ResultSet executeQuery = this.pStatement.executeQuery();
			while (executeQuery.next()) {
				Business tempBusiness = new Business();
				tempBusiness.setBno(executeQuery.getString(1));
				tempBusiness.setBname(executeQuery.getString(2));
				tempBusiness.setBlogin(executeQuery.getString(3));
				tempBusiness.setBpassword(executeQuery.getString(4));
				array.add(tempBusiness);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			this.close();
		}
		return array;
	}

	//添加一个教师员工
	public String addTeacher(Admin a, Payrollt t) {
		String resultStr = "新增失败";
		String sqlStr1 = "insert into payrollt values (?,?,?,?,?)";

		try {
			this.pStatement = this.con.prepareStatement(sqlStr1);
			this.pStatement.setString(1, a.getName());
			this.pStatement.setString(2, t.getTno());
			this.pStatement.setString(3, t.getTname());
			this.pStatement.setString(4, "");
			this.pStatement.setString(5, "");
			if (this.pStatement.executeUpdate() > 0) {
				resultStr = "添加成功";
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			this.close();
		}
		
		return resultStr;
		
	}

	//显示劳务关系
	public ArrayList<Payrollt> queryLabors(Admin a) {
			ArrayList<Payrollt> array = new ArrayList<Payrollt>();
			String sqlStr = "select tno,tname from payrollt where bno = '"+a.getName()+"'";
			try {
				this.pStatement = this.con.prepareStatement(sqlStr);
				ResultSet executeQuery = this.pStatement.executeQuery();
				while (executeQuery.next()) {
					Payrollt temppay = new Payrollt();
					temppay.setTno(executeQuery.getString(1));
					temppay.setTname(executeQuery.getString(2));
					array.add(temppay);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			finally {
				this.close();
			}
			return array;
		}

	//显示所有教师
	public ArrayList<Payrollt> queryWages(String blogin) {
		ArrayList<Payrollt> array = new ArrayList<Payrollt>();
		String sqlStr = "select tno,tname,year,salsry from payrollt where bno = '"+blogin+"'";
		try {
			this.pStatement = this.con.prepareStatement(sqlStr);
			ResultSet executeQuery = this.pStatement.executeQuery();
			while (executeQuery.next()) {
				Payrollt temppay = new Payrollt();
				temppay.setTno(executeQuery.getString(1));
				temppay.setTname(executeQuery.getString(2));
				temppay.setYear(executeQuery.getString(3));
				temppay.setSalsry(executeQuery.getString(4));
				array.add(temppay);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			this.close();
		}
		return array;
	}

	//改工资
	public Object reviseWages(Payrollt pay) {
		String resultStr = "修改失败" ;
		String sqlStr1 = "update payrollt set year = ?, salsry = ? where bno = ? and tno = ?";
		try {
			this.pStatement = this.con.prepareStatement(sqlStr1);
			this.pStatement.setString(3,pay.getBno());
			this.pStatement.setString(4,pay.getTno());
			this.pStatement.setString(1,pay.getYear());
			this.pStatement.setString(2,pay.getSalsry());
			if(this.pStatement.executeUpdate() > 0 ) {
				 resultStr = "修改成功";
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

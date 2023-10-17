package dao;

import java.awt.List;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.Assignment;
import model.Degree;
import model.Student;
import model.Teacher;

public class StudentDao extends BaseDao{
	
	//新增学生信息
	public String addStudentInfo(Student tempStudent) {
		String resultStr = "新增失败";
		
		String sqlStr1 ="insert into student values (?,?,?,?,?,?)";
		try {
			this.pStatement = this.con.prepareStatement(sqlStr1);
			this.pStatement.setString(1,tempStudent.getSno());
			this.pStatement.setString(2,tempStudent.getSname());
			this.pStatement.setString(3,tempStudent.getSsex());
			this.pStatement.setString(4,tempStudent.getSage());
			this.pStatement.setString(5,tempStudent.getSlogin());
			this.pStatement.setString(6,tempStudent.getSpassword());
			if(this.pStatement.executeUpdate() > 0 ) {
				resultStr = "新增成功";
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}	
		
		
		String sqlStr2 = "create user ? @'localhost' identified by ?";
		try {
			this.pStatement = this.con.prepareStatement(sqlStr2);
			this.pStatement.setString(1,tempStudent.getSlogin());
			this.pStatement.setString(2,tempStudent.getSpassword());
			if(this.pStatement.executeUpdate() > 0 ) {
				resultStr = "成功创建用户";
			}	
		} catch (SQLException e) {
			e.printStackTrace();
		}	
		
		
		String sqlStr3 = "grant select on sxs.student to ? @'localhost'";
		try {
			this.pStatement = this.con.prepareStatement(sqlStr3);
			this.pStatement.setString(1,tempStudent.getSlogin());
			if(this.pStatement.executeUpdate() > 0 ) {
				resultStr = "授权成功";
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		String sqlStr4 = "grant select on sxs.assignment to ? @'localhost'";
		try {
			this.pStatement = this.con.prepareStatement(sqlStr4);
			this.pStatement.setString(1,tempStudent.getSlogin());
			if(this.pStatement.executeUpdate() > 0 ) {
				resultStr = "授权成功";
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		String sqlStr5 = "grant select on sxs.degree to ? @'localhost'";
		try {
			this.pStatement = this.con.prepareStatement(sqlStr5);
			this.pStatement.setString(1,tempStudent.getSlogin());
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

	//查看学生信息
	public ArrayList queryAllStudent() {
		ArrayList<Student> array = new ArrayList<Student>();
		String sqlStr = "select * from student";
		try {
			this.pStatement = this.con.prepareStatement(sqlStr);
			ResultSet executeQuery = this.pStatement.executeQuery();
			while(executeQuery.next()) {
				Student tempStudent = new Student();
				tempStudent.setSno(executeQuery.getString(1));
				tempStudent.setSname(executeQuery.getString(2));
				tempStudent.setSsex(executeQuery.getString(3));
				tempStudent.setSage(executeQuery.getString(4));
				tempStudent.setSlogin(executeQuery.getString(5));
				tempStudent.setSpassword(executeQuery.getString(6));
				array.add(tempStudent);
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}finally {
			this.close();
		}	
		return array;
	}

	//条件查找
	public ArrayList<Student> querySomeStudent(Student tempStudent){
		ArrayList<Student> array1 = new ArrayList<Student>();
		String aqlStr ="select * from student where sno like'%"+tempStudent.getSno()+"%' and sname like '%"+tempStudent.getSname()+"%' and ssex like '%"+tempStudent.getSsex()+"%' and sage like '%"+tempStudent.getSage()+"%' and slogin like '%"+tempStudent.getSlogin()+"%' and spassword like '%"+tempStudent.getSpassword()+"%'";
		try {
			this.pStatement = this.con.prepareStatement(aqlStr);
			ResultSet executeQuery = this.pStatement.executeQuery();
			while(executeQuery.next()) {
				Student tempStudent1 = new Student();
				tempStudent1.setSno(executeQuery.getString(1));
				tempStudent1.setSname(executeQuery.getString(2));
				tempStudent1.setSsex(executeQuery.getString(3));
				tempStudent1.setSage(executeQuery.getString(4));
				tempStudent1.setSlogin(executeQuery.getString(5));
				tempStudent1.setSpassword(executeQuery.getString(6));
				array1.add(tempStudent1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			this.close();
		}
		return array1;
	}

	//删除信息
	public String deleteStudent(String sno) {
		String resultStr = "删除失败";
		String sqlStr = "delete from student where sno = ?";
		try {
			this.pStatement = this.con.prepareStatement(sqlStr);
			this.pStatement.setString(1, sno);
			if(this.pStatement.executeUpdate() > 0) {
				resultStr = "删除成功";
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		String sqlStr1 = "drop user ? @'localhost'";
		try {
			this.pStatement = this.con.prepareStatement(sqlStr1);
			this.pStatement.setString(1, sno);
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

	//修改信息
	public String reviseStudent(Student tempStudent){
		String resultStr = "修改失败" ;
		String sqlStr1 = "update student set sname = ?, ssex = ?, sage = ?, slogin = ?, spassword = ? where sno = ?";
		try {
			this.pStatement = this.con.prepareStatement(sqlStr1);
			this.pStatement.setString(6,tempStudent.getSno());
			this.pStatement.setString(1,tempStudent.getSname());
			this.pStatement.setString(2,tempStudent.getSsex());
			this.pStatement.setString(3,tempStudent.getSage());
			this.pStatement.setString(4,tempStudent.getSlogin());
			this.pStatement.setString(5,tempStudent.getSpassword());
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
			this.pStatement.setString(1,tempStudent.getSlogin());
			this.pStatement.setString(2,tempStudent.getSpassword());
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

	//查看个人信息
	public ArrayList<Student> queryThisStudent(String sno) {
		ArrayList<Student> array = new ArrayList<Student>();
		String sqlStr = "select * from student where sno = '"+sno+"' lock in share mode";
		
		try {
			this.pStatement = this.con.prepareStatement(sqlStr);
			ResultSet executeQuery = this.pStatement.executeQuery();
			while (executeQuery.next()) {
				Student tempStudent = new Student();
				tempStudent.setSno(executeQuery.getString(1));
				tempStudent.setSname(executeQuery.getString(2));
				tempStudent.setSsex(executeQuery.getString(3));
				tempStudent.setSage(executeQuery.getString(4));
				array.add(tempStudent);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			this.close();
		}
		return array;
	}

	//查看个人任务
	public ArrayList<Assignment> queryAssignments(String sno) {
		ArrayList<Assignment> array = new ArrayList<Assignment>();
		String sqlStr = "select ano,aname,tno from assignment where sno = '"+sno+"'";	
		try {
			this.pStatement = this.con.prepareStatement(sqlStr);
			ResultSet executeQuery = this.pStatement.executeQuery();
			while (executeQuery.next()) {
				Assignment tempAssignment = new Assignment();
				tempAssignment.setAno(executeQuery.getString(1));
				tempAssignment.setAname(executeQuery.getString(2));
				tempAssignment.setTno(executeQuery.getString(3));
				array.add(tempAssignment);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			this.close();
		}
		return array;
	}

	//查看个人成绩
	public ArrayList<Degree> queryDegree(String sno) {
		ArrayList<Degree> array = new ArrayList<Degree>();
		String sqlStr = "select ano,tno from assignment  where sno = '"+sno+"'";	
		try {
			this.pStatement = this.con.prepareStatement(sqlStr);
			ResultSet executeQuery = this.pStatement.executeQuery();
			while (executeQuery.next()) {
				Degree tempDegree = new Degree();
				tempDegree.setAno(executeQuery.getString(1));
				tempDegree.setTno(executeQuery.getString(2));
				tempDegree.setRank("A");
				array.add(tempDegree);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			this.close();
		}
		return array;
	}
	
}

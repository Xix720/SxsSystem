package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.Assignment;
import model.AssignmentSc;
import model.Business;
import model.Degree;
import model.Payrollt;
import model.Teacher;

public class TeacherDao extends BaseDao {
	

	//������ʦ��Ϣ
	public String addTeacherInfo(Teacher tempTeacher) {
		String resultStr = "����ʧ��";
		String sqlStr1 ="insert into teacher values (?,?,?,?,?,?)";
		
		try {
			this.pStatement = this.con.prepareStatement(sqlStr1);
			this.pStatement.setString(1,tempTeacher.getTno());
			this.pStatement.setString(2,tempTeacher.getTname());
			this.pStatement.setString(3,tempTeacher.getTsex());
			this.pStatement.setString(4,tempTeacher.getTage());
			this.pStatement.setString(5,tempTeacher.getTlogin());
			this.pStatement.setString(6,tempTeacher.getTpassword());
			if(this.pStatement.executeUpdate() > 0 ) {
				resultStr = "��ӳɹ�";
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		String sqlStr2 = "create user ? @'localhost' identified by ?";
		try {
			this.pStatement = this.con.prepareStatement(sqlStr2);
			this.pStatement.setString(1,tempTeacher.getTlogin());
			this.pStatement.setString(2,tempTeacher.getTpassword());
			if(this.pStatement.executeUpdate() > 0 ) {
				resultStr = "�ɹ������û�";
			}	
		} catch (SQLException e) {
			e.printStackTrace();
		}	
		
		
		String sqlStr3 = "grant select on sxs.teacher to ? @'localhost'";
		try {
			this.pStatement = this.con.prepareStatement(sqlStr3);
			this.pStatement.setString(1,tempTeacher.getTlogin());
			if(this.pStatement.executeUpdate() > 0 ) {
				resultStr = "��Ȩ�ɹ�";
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		String sqlStr4 = "grant select on sxs.payrollt to ? @'localhost'";
		try {
			this.pStatement = this.con.prepareStatement(sqlStr4);
			this.pStatement.setString(1,tempTeacher.getTlogin());
			if(this.pStatement.executeUpdate() > 0 ) {
				resultStr = "��Ȩ�ɹ�";
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}
		
		String sqlStr5 = "grant all privileges on sxs.assignment to ? @'localhost'";
		try {
			this.pStatement = this.con.prepareStatement(sqlStr5);
			this.pStatement.setString(1,tempTeacher.getTlogin());
			if(this.pStatement.executeUpdate() > 0 ) {
				resultStr = "��Ȩ�ɹ�";
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		String sqlStr6 = "grant all privileges on sxs.degree to ? @'localhost'";
		try {
			this.pStatement = this.con.prepareStatement(sqlStr6);
			this.pStatement.setString(1,tempTeacher.getTlogin());
			if(this.pStatement.executeUpdate() > 0 ) {
				resultStr = "��Ȩ�ɹ�";
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}finally {
			this.close();
		}
		return resultStr;
	}

	//�鿴��ʦ��Ϣ
	public ArrayList queryAllTeacher() {
		ArrayList<Teacher> array = new ArrayList<Teacher>();
		String sqlStr = "select * from teacher";
		try {
			this.pStatement = this.con.prepareStatement(sqlStr);
			ResultSet executeQuery = this.pStatement.executeQuery();
			while(executeQuery.next()) {
				Teacher tempTeacher = new Teacher();
				tempTeacher.setTno(executeQuery.getString(1));
				tempTeacher.setTname(executeQuery.getString(2));
				tempTeacher.setTsex(executeQuery.getString(3));
				tempTeacher.setTage(executeQuery.getString(4));
				tempTeacher.setTlogin(executeQuery.getString(5));
				tempTeacher.setTpassword(executeQuery.getString(6));
				array.add(tempTeacher);
			}
		
		}catch (SQLException e) {
			e.printStackTrace();
		}finally {
			this.close();
		}	
		return array;
	}

	//��������
	public ArrayList<Teacher> querySomeTeacher(Teacher tempTeacher){
		ArrayList<Teacher> array1 = new ArrayList<Teacher>();
		String aqlStr ="select * from teacher where tno like'%"+tempTeacher.getTno()+"%' and tname like '%"+tempTeacher.getTname()+"%' and tsex like '%"+tempTeacher.getTsex()+"%' and tage like '%"+tempTeacher.getTage()+"%' and tlogin like '%"+tempTeacher.getTlogin()+"%' and tpassword like '%"+tempTeacher.getTpassword()+"%'";
		try {
			this.pStatement = this.con.prepareStatement(aqlStr);
			ResultSet executeQuery = this.pStatement.executeQuery();
			while(executeQuery.next()) {
				Teacher tempTeacher1 = new Teacher();
				tempTeacher1.setTno(executeQuery.getString(1));
				tempTeacher1.setTname(executeQuery.getString(2));
				tempTeacher1.setTsex(executeQuery.getString(3));
				tempTeacher1.setTage(executeQuery.getString(4));
				tempTeacher1.setTlogin(executeQuery.getString(5));
				tempTeacher1.setTpassword(executeQuery.getString(6));
				array1.add(tempTeacher1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			this.close();
		}
		return array1;
	}

	//ɾ����Ϣ
	public String deleteTeacher(String tno) {
		String resultStr = "ɾ��ʧ��";
		String sqlStr = "delete from teacher where tno = ?";
		try {
			this.pStatement = this.con.prepareStatement(sqlStr);
			this.pStatement.setString(1, tno);
			if(this.pStatement.executeUpdate() > 0) {
				resultStr = "ɾ���ɹ�";
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		String sqlStr1 = "drop user ? @'localhost'";
		try {
			this.pStatement = this.con.prepareStatement(sqlStr1);
			this.pStatement.setString(1, tno);
			if(this.pStatement.executeUpdate() > 0) {
				resultStr = "ɾ���ɹ�";
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			this.close();
		}
		return resultStr;
	}

	//�޸���Ϣ
	public String reviseTeacher(Teacher tempTeacher){
		String resultStr = "�޸�ʧ��" ;
		String sqlStr1 = "update teacher set tname = ?, tsex = ?, tage = ?, tlogin = ?, tpassword = ? where tno = ?";
		try {
			this.pStatement = this.con.prepareStatement(sqlStr1);
			this.pStatement.setString(6,tempTeacher.getTno());
			this.pStatement.setString(1,tempTeacher.getTname());
			this.pStatement.setString(2,tempTeacher.getTsex());
			this.pStatement.setString(3,tempTeacher.getTage());
			this.pStatement.setString(4,tempTeacher.getTlogin());
			this.pStatement.setString(5,tempTeacher.getTpassword());
			if(this.pStatement.executeUpdate() > 0 ) {
				 resultStr = "�޸ĳɹ�";
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		String sqlStr2 = "set password for ? @'localhost' = password(?)";
		try {
			this.pStatement = this.con.prepareStatement(sqlStr2);
			this.pStatement.setString(1,tempTeacher.getTlogin());
			this.pStatement.setString(2,tempTeacher.getTpassword());
			if(this.pStatement.executeUpdate() > 0 ) {
				 resultStr = "�޸ĳɹ�";
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			this.close();
		}
		return resultStr;
}
	
	// �鿴��ǰ��ʦ��Ϣ
	public ArrayList queryThisTeacher(String tlogin) {
			ArrayList<Teacher> array = new ArrayList<Teacher>();
			String sqlStr = "select * from teacher where tno = '"+tlogin+"'";
			
			try {
				this.pStatement = this.con.prepareStatement(sqlStr);
				ResultSet executeQuery = this.pStatement.executeQuery();
				while (executeQuery.next()) {
					Teacher tempTeacher = new Teacher();
					tempTeacher.setTno(executeQuery.getString(1));
					tempTeacher.setTname(executeQuery.getString(2));
					tempTeacher.setTage(executeQuery.getString(3));
					array.add(tempTeacher);
				}

			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				this.close();
			}
			return array;
		}
		
	// �鿴��ǰ��ʦ�Ĺ�����Ϣ
	public ArrayList queryThisTeachersWage(String tlogin) {
			ArrayList<Payrollt> array = new ArrayList<Payrollt>();
			String sqlStr = "select bno,year,salsry from payrollt where Tno = '"+tlogin+"'";
			
			try {
				this.pStatement = this.con.prepareStatement(sqlStr);
				ResultSet executeQuery = this.pStatement.executeQuery();
				while (executeQuery.next()) {
					Payrollt tempPay = new Payrollt();
					tempPay.setYear(executeQuery.getString(1));
					tempPay.setBno(executeQuery.getString(2));
					tempPay.setSalsry(executeQuery.getString(3));
					array.add(tempPay);
				}

			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				this.close();
			}
			return array;
		}
	
	//����������Ϣ
	public String addNewTask(Assignment tempTask) {
		String resultStr = "����ʧ��";
		String sqlStr1 ="insert into assignment values (?,?,?,?)";
		
		try {
			this.pStatement = this.con.prepareStatement(sqlStr1);
			this.pStatement.setString(1,tempTask.getAno());
			this.pStatement.setString(2,tempTask.getAname());
			this.pStatement.setString(3,tempTask.getSno());
			this.pStatement.setString(4,tempTask.getTno());
			if(this.pStatement.executeUpdate() > 0 ) {
				resultStr = "��ӳɹ�";
			}
		} catch (SQLException e) {
			e.printStackTrace();
		
		}finally {
			this.close();
		}
		return resultStr;
	}
	
	
	// �鿴��ǰ��ʦ���õ�����
	public ArrayList queryAllTasks(String tlogin) {
		ArrayList<Assignment> array = new ArrayList<Assignment>();
		ArrayList<Degree> array1 = new ArrayList<Degree>();
		String sqlStr = "select sno,ano,aname from assignment where Tno = '"+tlogin+"'";
		try {
			this.pStatement = this.con.prepareStatement(sqlStr);
			ResultSet executeQuery = this.pStatement.executeQuery();
			while (executeQuery.next()) {
				Assignment tempAssignment = new Assignment();
				tempAssignment.setSno(executeQuery.getString(1));
				tempAssignment.setAno(executeQuery.getString(2));
				tempAssignment.setAname(executeQuery.getString(3));
				array.add(tempAssignment);
			
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			this.close();
		}
		return array;
	}
	

    //�޸�������Ϣ
	public String reviseTask(Assignment tempTasksc){
		String resultStr = "�޸�ʧ��" ;
		String sqlStr1 = "update assignment set ano = ?, aname = ?, sno = ?";
		try {
			this.pStatement = this.con.prepareStatement(sqlStr1);
			this.pStatement.setString(1,tempTasksc.getAno());
			this.pStatement.setString(2,tempTasksc.getAname());
			this.pStatement.setString(3,tempTasksc.getSno());;
			if(this.pStatement.executeUpdate() > 0 ) {
				 resultStr = "�޸ĳɹ�";
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			this.close();
		}
		return resultStr;
}
	//������������
	public String addNewTasksc(Degree tempTasksc) {
		String resultStr = "����ʧ��";
		String sqlStr1 ="insert into degree values (?,?,?,?)";
		
		try {
			this.pStatement = this.con.prepareStatement(sqlStr1);
			this.pStatement.setString(1,tempTasksc.getAno());
			this.pStatement.setString(2,tempTasksc.getSno());
			this.pStatement.setString(3,tempTasksc.getRank());
			this.pStatement.setString(4,tempTasksc.getTno());
			if(this.pStatement.executeUpdate() > 0 ) {
				resultStr = "��ӳɹ�";
			}
		} catch (SQLException e) {
			e.printStackTrace();
		
		}finally {
			this.close();
		}
		return resultStr;
	}
	//�޸���������
	public String reviseRank(Degree tempTasksc){
		String resultStr = "�޸�����ʧ��" ;
		String sqlStr1 = "update degree set rank = ? where ano=?";
		try {
			this.pStatement = this.con.prepareStatement(sqlStr1);
			this.pStatement.setString(1,tempTasksc.getRank());
			this.pStatement.setString(2,tempTasksc.getAno());
			if(this.pStatement.executeUpdate() > 0 ) {
				 resultStr = "�޸ĳɹ�";
			}
		} catch (SQLException e) {
			e.printStackTrace();
		
		}finally {
			this.close();
		}
		return resultStr;
}
	// �鿴��ǰ��ʦ���õ����������
	public ArrayList queryAllSC(String tlogin) {
		ArrayList<Degree> array = new ArrayList<Degree>();
		String sqlStr = "select sno,ano,rank from degree where tno = '"+tlogin+"'";
		
		try {
			this.pStatement = this.con.prepareStatement(sqlStr);
			ResultSet executeQuery = this.pStatement.executeQuery();
			while (executeQuery.next()) {
				Degree tempAssignment = new Degree();
				tempAssignment.setSno(executeQuery.getString(1));
				tempAssignment.setAno(executeQuery.getString(2));
				tempAssignment.setRank(executeQuery.getString(3));
				array.add(tempAssignment);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			this.close();
		}
		return array;
	}

	public ArrayList<Degree> querysomeSC(Degree tempdegree) {
		// TODO Auto-generated method stub
		ArrayList<Degree> array1 = new ArrayList<Degree>();
		String aqlStr ="select sno,ano,aname,tno from assignment where sno like'%"+tempdegree.getSno()+"%' and ano like '%"+tempdegree.getAno()+"%' and aname like '%"+tempdegree.getAname()+"%' and arank like '%"+tempdegree.getRank()+"%' and tno like '%"+tempdegree.getTno()+"%'";
		try {
			this.pStatement = this.con.prepareStatement(aqlStr);
			ResultSet executeQuery = this.pStatement.executeQuery();
			while(executeQuery.next()) {
				Degree tempDg1 = new Degree();
				tempDg1.setSno(executeQuery.getString(1));
				tempDg1.setAno(executeQuery.getString(2));
				tempDg1.setAname(executeQuery.getString(3));
				tempDg1.setTno(executeQuery.getString(4));
				array1.add(tempDg1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			this.close();
		}
		return array1;
	}
	
	
}
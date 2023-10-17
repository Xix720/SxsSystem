package studentManage;

import java.awt.EventQueue;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.JInternalFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import dao.BusinessDao;
import dao.StudentDao;
import dao.TeacherDao;
import model.Admin;
import model.Business;
import model.Student;
import model.Teacher;

public class StudentInfo extends JInternalFrame {
	
	private DefaultTableModel dtm = null;

	private JTable ThisStudentInfo;
	public static Admin admin1;


	
	public StudentInfo(Admin a) {
		//界面美化
				try {
			        for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
			            if ("Nimbus".equals(info.getName())) {
			                javax.swing.UIManager.setLookAndFeel(info.getClassName());
			                break;
			            }
			        }
			    }catch(Exception e) {
			    	System.out.println(e);
			    }
		admin1 = a;
		
		setClosable(true);
		setTitle("\u67E5\u770B\u4E2A\u4EBA\u4FE1\u606F");
		setBounds(100, 100, 613, 407);
		getContentPane().setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 10, 581, 358);
		getContentPane().add(scrollPane);
		
		ThisStudentInfo = new JTable();
		ThisStudentInfo.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"学号", "姓名", "性别","年龄"
			}
		));
		scrollPane.setViewportView(ThisStudentInfo);
		Admin temptadmin = new Admin();
		this.dtm =(DefaultTableModel) ThisStudentInfo.getModel();
		queryThisStudent(admin1);

	}
	private void queryThisStudent(Admin b) {
		// TODO Auto-generated method stub
		String sno = b.getName();
		dtm.setRowCount(0);
		StudentDao studentDao = new StudentDao();
		ArrayList<Student> thisStudent= studentDao.queryThisStudent(sno);
		for(Student stc : thisStudent) {
			Vector v =new Vector();
			v.add(stc.getSno());
			v.add(stc.getSname());
			v.add(stc.getSsex());
			v.add(stc.getSage());
			dtm.addRow(v);
		}
	}
}

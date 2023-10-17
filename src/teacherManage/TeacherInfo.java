package teacherManage;

import java.awt.EventQueue;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.JInternalFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import dao.BusinessDao;
import dao.TeacherDao;
import model.Admin;
import model.Business;
import model.Teacher;

public class TeacherInfo extends JInternalFrame {
	
	private DefaultTableModel dtm = null;

	private JTable ThisTeacherInfo;
	public static Admin admin1;


	
	public TeacherInfo(Admin a) {
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
		
		ThisTeacherInfo = new JTable();
		ThisTeacherInfo.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"\u6559\u5E08\u7F16\u53F7", "\u59D3\u540D", "\u4E13\u4E1A"
			}
		));
		scrollPane.setViewportView(ThisTeacherInfo);
		Admin temptadmin = new Admin();
		this.dtm =(DefaultTableModel) ThisTeacherInfo.getModel();
		queryThisTeacher(admin1);

	}
	private void queryThisTeacher(Admin b) {
		// TODO Auto-generated method stub
		String tlogin = b.getName();
		dtm.setRowCount(0);
		TeacherDao teacherDao = new TeacherDao();
		ArrayList<Teacher> thisTeacher= teacherDao.queryThisTeacher(tlogin);
		for(Teacher stc : thisTeacher) {
			Vector v =new Vector();
			v.add(stc.getTno());
			v.add(stc.getTname());
			v.add(stc.getTage());
			dtm.addRow(v);
		}
	}
}

package studentManage;

import java.awt.EventQueue;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.JInternalFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import dao.StudentDao;
import dao.TeacherDao;
import model.Admin;
import model.Assignment;
import model.Degree;
import model.Teacher;
import model.Payrollt;

public class MyDegree extends JInternalFrame {
	private JTable myAssignment;
	public static Admin admin;

	private DefaultTableModel dtm = null;
	/**
	 * Create the frame.
	 */
	public MyDegree(Admin a) {
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
		admin = a;
		setClosable(true);
		setTitle("\u67E5\u770B\u6211\u7684\u6210\u7EE9");
		setBounds(100, 100, 609, 417);
		getContentPane().setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 10, 577, 368);
		getContentPane().add(scrollPane);
		
		myAssignment = new JTable();
		myAssignment.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"任务编号", "指导老师编号", "评级"
			}
		));
		scrollPane.setViewportView(myAssignment);
		Admin temptadmin = new Admin();
		this.dtm =(DefaultTableModel) myAssignment.getModel();
		showMyWagesInfo(admin);

	}


	private void showMyWagesInfo(Admin a) {
		// TODO Auto-generated method stub
		dtm.setRowCount(0);
		StudentDao studentDao = new StudentDao();
		ArrayList<Degree> mydegree = studentDao.queryDegree(a.getName());
		for(Degree stc : mydegree) {
			Vector v =new Vector();
			v.add(stc.getAno());
			v.add(stc.getTno());
			v.add(stc.getRank());
			dtm.addRow(v);
	}

}
}

package teacherManage;

import java.awt.EventQueue;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.JInternalFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import dao.TeacherDao;
import model.Admin;
import model.Teacher;
import model.Payrollt;

public class MyWages extends JInternalFrame {
	private JTable mywage;
	public static Admin admin;

	private DefaultTableModel dtm = null;
	/**
	 * Create the frame.
	 */
	public MyWages(Admin a) {
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
		setTitle("\u67E5\u770B\u6211\u7684\u5DE5\u8D44");
		setBounds(100, 100, 609, 417);
		getContentPane().setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 10, 577, 368);
		getContentPane().add(scrollPane);
		
		mywage = new JTable();
		mywage.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"年份", "\u53D7\u8058\u4F01\u4E1A", "\u5B9E\u53D1\u5DE5\u8D44"
			}
		));
		scrollPane.setViewportView(mywage);
		Admin temptadmin = new Admin();
		this.dtm =(DefaultTableModel) mywage.getModel();
		showMyWagesInfo(admin);

	}


	private void showMyWagesInfo(Admin a) {
		// TODO Auto-generated method stub
		dtm.setRowCount(0);
		TeacherDao teacherDao = new TeacherDao();
		ArrayList<Payrollt> mywage= teacherDao.queryThisTeachersWage(a.getName());
		for(Payrollt stc : mywage) {
			Vector v =new Vector();
			v.add(stc.getYear());
			v.add(stc.getBno());
			v.add(stc.getSalsry());
			dtm.addRow(v);
	}

}
}

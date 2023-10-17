package businessManage;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import java.awt.FlowLayout;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import model.Admin;
import model.Business;
import model.Payrollt;
import model.Teacher;
import dao.BusinessDao;
import dao.TeacherDao;

import java.awt.Color;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class Labors extends JInternalFrame {
	private JTable Teacher;
	public static Admin admin;
	private DefaultTableModel dtm = null;
	/**
	 * Launch the application.
	 */
	

	/**
	 * Create the frame.
	 */
	public Labors(Admin a) {
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
		setTitle("\u67E5\u770B\u96C7\u4F63\u6559\u5E08");
		setBounds(100, 100, 614, 408);
		getContentPane().setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 10, 582, 269);
		getContentPane().add(scrollPane);
		
		Teacher = new JTable();
		Teacher.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"\u6559\u5E08\u7F16\u53F7", "\u6559\u5E08\u59D3\u540D"
			}
		));
		scrollPane.setViewportView(Teacher);
				
		
		this.dtm =(DefaultTableModel) Teacher.getModel();
		queryLabors(admin);
		
	}

	private void queryLabors(Admin a) {
		// TODO Auto-generated method stub
		dtm.setRowCount(0);
		BusinessDao businessDao = new BusinessDao();
		ArrayList<Payrollt> allLabors = businessDao.queryLabors(a);
		for(Payrollt stc : allLabors) {
			Vector v =new Vector();
			v.add(stc.getTno());
			v.add(stc.getTname());
			dtm.addRow(v);
		}
	}
}

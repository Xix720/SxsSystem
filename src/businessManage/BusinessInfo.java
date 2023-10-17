package businessManage;


import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.table.DefaultTableModel;

import model.Admin;
import dao.BusinessDao;
import dao.StudentDao;
import model.Business;
import model.Student;

import java.awt.Font;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.JFormattedTextField;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class BusinessInfo extends JInternalFrame {

	private DefaultTableModel dtm = null;
	private JTable ThisBusinessInfo;
	public static Admin admin1;

	/**
	 * Create the frame.
	 */
	public BusinessInfo(Admin a) {
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
		setTitle("\u67E5\u770B\u4F01\u4E1A\u4FE1\u606F");
		setBounds(100, 100, 608, 404);
		getContentPane().setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 10, 576, 355);
		getContentPane().add(scrollPane);
		
		ThisBusinessInfo = new JTable();
		ThisBusinessInfo.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"\u4F01\u4E1A\u7F16\u53F7", "\u4F01\u4E1A\u540D\u79F0", "\u4F01\u4E1A\u8D26\u53F7"
			}
		));
		scrollPane.setViewportView(ThisBusinessInfo);
		Admin temptadmin = new Admin();
		this.dtm =(DefaultTableModel) ThisBusinessInfo.getModel();
		queryThisBusiness(admin1);

	}


	private void queryThisBusiness(Admin b) {
		// TODO Auto-generated method stub
		String blogin = b.getName();
		dtm.setRowCount(0);
		BusinessDao businessDao = new BusinessDao();
		ArrayList<Business> thisBusiness= businessDao.queryThisBusiness(blogin);
		for(Business stc : thisBusiness) {
			Vector v =new Vector();
			v.add(stc.getBno());
			v.add(stc.getBname());
			v.add(stc.getBlogin());
			dtm.addRow(v);
		}
	}
	}

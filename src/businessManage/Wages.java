package businessManage;

import java.awt.EventQueue;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.JInternalFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import dao.BusinessDao;
import model.Admin;
import model.Business;
import model.Payrollt;
import uilt.StrUilt;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;

public class Wages extends JInternalFrame {
	private JTable wages;
	public static Admin admin;
	private DefaultTableModel dtm = null;
	private JTextField wagesYearText;
	private JTextField wagesSalsryText;
	private JTextField wagesTnoText;
	private JTextField wagesTnameText;
	private JButton btnNewButton;
	/**
	 * Launch the application.
	 */
	

	/**
	 * Create the frame.
	 */
	public Wages(Admin a) {
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
		setTitle("\u5DE5\u8D44\u4FE1\u606F");
		setBounds(100, 100, 603, 407);
		getContentPane().setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 10, 582, 269);
		getContentPane().add(scrollPane);
		
		wages = new JTable();
		wages.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent me) {
				selectRow(me);
			}
		});
		
		wages.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"教师编号", "教师姓名", "年份", "工资"
			}
		));
		scrollPane.setViewportView(wages);
		
		JLabel lblNewLabel = new JLabel("\u7F16\u53F7");
		lblNewLabel.setBounds(59, 305, 41, 15);
		getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("\u59D3\u540D");
		lblNewLabel_1.setBounds(59, 337, 41, 15);
		getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("\u5E74\u4EFD");
		lblNewLabel_2.setBounds(227, 306, 41, 15);
		getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_2_1 = new JLabel("\u5DE5\u8D44");
		lblNewLabel_2_1.setBounds(227, 337, 58, 15);
		getContentPane().add(lblNewLabel_2_1);
		
		wagesYearText = new JTextField();
		wagesYearText.setColumns(10);
		wagesYearText.setBounds(267, 302, 92, 21);
		getContentPane().add(wagesYearText);
		
		wagesSalsryText = new JTextField();
		wagesSalsryText.setColumns(10);
		wagesSalsryText.setBounds(267, 334, 92, 21);
		getContentPane().add(wagesSalsryText);
		
		
		wagesTnoText = new JTextField();
		wagesTnoText.setColumns(10);
		wagesTnoText.setBounds(103, 302, 92, 21);
		getContentPane().add(wagesTnoText);
		
		wagesTnameText = new JTextField();
		wagesTnameText.setColumns(10);
		wagesTnameText.setBounds(103, 334, 92, 21);
		getContentPane().add(wagesTnameText);

		
		btnNewButton = new JButton("\u786E\u8BA4\u5DE5\u8D44");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				changewages(admin.getName());
			}
		});
		btnNewButton.setBounds(411, 318, 97, 23);
		getContentPane().add(btnNewButton);
		

		this.dtm =(DefaultTableModel) wages.getModel();
		queryWages(admin);
	}

	protected void changewages(String blogin) {
		// TODO Auto-generated method stub
		if(JOptionPane.showConfirmDialog(this, "是否修改此条数据？","正在修改数据...",JOptionPane.YES_NO_OPTION) == JOptionPane.OK_OPTION) {
			String tno = this.wagesTnoText.getText();
			String tname = this.wagesTnameText.getText();
			String year = this.wagesYearText.getText();
			String salsry = this.wagesSalsryText.getText();
			if(StrUilt.isEmpty(tno)&&StrUilt.isEmpty(tname)&&StrUilt.isEmpty(year)) {
				queryWages(admin);
				return;	
			}
			Payrollt pay = new Payrollt();
			pay.setBno(blogin);
			pay.setTno(tno);
			pay.setTname(tname);
			pay.setYear(blogin);
			pay.setSalsry(salsry);
			
			BusinessDao studentDao = new BusinessDao();
			JOptionPane.showMessageDialog(this, studentDao.reviseWages(pay));
			queryWages(admin);
			}
		
	}

	//显示数据
	private void queryWages(Admin admin2) {
		// TODO Auto-generated method stub
		String blogin = admin2.getName();
		dtm.setRowCount(0);
		BusinessDao businessDao = new BusinessDao();
		ArrayList<Payrollt> allwages = businessDao.queryWages(blogin);
		for(Payrollt stc : allwages) {
			Vector v =new Vector();
			v.add(stc.getTno());
			v.add(stc.getTname());
			v.add(stc.getYear());
			v.add(stc.getSalsry());
			dtm.addRow(v);
		}
		this.btnNewButton.setEnabled(false);
	}
	
	// table-选中数据
		protected void selectRow(MouseEvent me) {
			this.wagesTnoText.setText(dtm.getValueAt(this.wages.getSelectedRow(),0 ).toString());
			this.wagesTnameText.setText(dtm.getValueAt(this.wages.getSelectedRow(),1 ).toString());
			this.wagesYearText.setText(dtm.getValueAt(this.wages.getSelectedRow(),2 ).toString());
			this.wagesSalsryText.setText(dtm.getValueAt(this.wages.getSelectedRow(),3 ).toString());
			this.btnNewButton.setEnabled(true);
		}
}

package businessManage;

import java.awt.EventQueue;
import javax.swing.JInternalFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import dao.BusinessDao;
import model.Business;
import uilt.StrUilt;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.List;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Vector;
import java.awt.event.ActionEvent;
import javax.swing.JRadioButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class BusinessList extends JInternalFrame {
	private JTable businessListTable;
	private JTextField EnterpriseNum;
	private JTextField EnterpriseName;
	private JTextField EnterpriseLogin;
	private JTextField EnterprisePassword;
	private JButton reviseButton;
	private JButton deleteButton;
	private JButton resetButton;
	private JButton searchButton;
	
	
	private DefaultTableModel dtm = null;

	/**
	 * Create the frame.
	 */
	public BusinessList() {
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
		setClosable(true);
		setIconifiable(true);
		setTitle("\u67E5\u770B\u6240\u6709\u5B66\u751F");
		setBounds(100, 100, 911, 568);
		getContentPane().setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 10, 879, 403);
		getContentPane().add(scrollPane);
		
		businessListTable = new JTable();
		businessListTable.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent me) {
				selectRow(me);
			}
		});
		businessListTable.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"\u4F01\u4E1A\u7F16\u53F7", "\u4F01\u4E1A\u540D\u79F0", "\u767B\u9646\u8D26\u53F7", "\u767B\u9646\u5BC6\u7801"
			}
		));
		scrollPane.setViewportView(businessListTable);
		
		JLabel lblNewLabel = new JLabel("\u4F01\u4E1A\u7F16\u53F7");
		lblNewLabel.setFont(new Font("微软雅黑", Font.PLAIN, 15));
		lblNewLabel.setBounds(38, 452, 76, 15);
		getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_2 = new JLabel("\u4F01\u4E1A\u540D\u79F0");
		lblNewLabel_2.setFont(new Font("微软雅黑", Font.PLAIN, 15));
		lblNewLabel_2.setBounds(38, 495, 76, 15);
		getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_4 = new JLabel("\u767B\u9646\u8D26\u53F7");
		lblNewLabel_4.setFont(new Font("微软雅黑", Font.PLAIN, 15));
		lblNewLabel_4.setBounds(274, 452, 76, 15);
		getContentPane().add(lblNewLabel_4);
		
		EnterpriseNum = new JTextField();
		EnterpriseNum.setBounds(108, 451, 107, 21);
		getContentPane().add(EnterpriseNum);
		EnterpriseNum.setColumns(10);
		
		EnterpriseName = new JTextField();
		EnterpriseName.setColumns(10);
		EnterpriseName.setBounds(108, 494, 107, 21);
		getContentPane().add(EnterpriseName);
		
		EnterpriseLogin = new JTextField();
		EnterpriseLogin.setColumns(10);
		EnterpriseLogin.setBounds(360, 451, 107, 21);
		getContentPane().add(EnterpriseLogin);
		
		searchButton = new JButton("\u641C\u7D22");
		searchButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				selectBusiness(ae);
			}
		});
		searchButton.setFont(new Font("宋体", Font.PLAIN, 15));
		searchButton.setBounds(652, 450, 97, 23);
		getContentPane().add(searchButton);
		
		reviseButton = new JButton("\u4FEE\u6539");
		reviseButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				changeBusiness();
			}
		});
		reviseButton.setFont(new Font("宋体", Font.PLAIN, 15));
		reviseButton.setBounds(759, 450, 97, 23);
		getContentPane().add(reviseButton);
		
		resetButton = new JButton("\u91CD\u7F6E");
		resetButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				resetButton();
			}
		});
		resetButton.setFont(new Font("宋体", Font.PLAIN, 15));
		resetButton.setBounds(652, 493, 97, 23);
		getContentPane().add(resetButton);
		
		deleteButton = new JButton("\u5220\u9664");
		deleteButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				deleteButton(ae);
			}
		});
		deleteButton.setFont(new Font("宋体", Font.PLAIN, 15));
		deleteButton.setBounds(759, 493, 97, 23);
		getContentPane().add(deleteButton);
		
		JLabel lblNewLabel_1_1 = new JLabel("\u767B\u9646\u5BC6\u7801");
		lblNewLabel_1_1.setFont(new Font("微软雅黑", Font.PLAIN, 15));
		lblNewLabel_1_1.setBounds(274, 495, 76, 15);
		getContentPane().add(lblNewLabel_1_1);
		
		EnterprisePassword = new JTextField();
		EnterprisePassword.setColumns(10);
		EnterprisePassword.setBounds(360, 494, 107, 21);
		getContentPane().add(EnterprisePassword);

		this.dtm =(DefaultTableModel) businessListTable.getModel();
		queryAllBusiness();
	}
	
	//修改记录
	protected void changeBusiness() {
		// TODO Auto-generated method stub
		String rootpwd;
		rootpwd = JOptionPane.showInputDialog("权限密码：");
		if(JOptionPane.showConfirmDialog(this, "是否修改此条数据？","正在修改数据...",JOptionPane.YES_NO_OPTION) == JOptionPane.OK_OPTION&&rootpwd.equals("root")) {
			String bno = this.EnterpriseNum.getText();
			String bname = this.EnterpriseName.getText();
			String blogin = this.EnterpriseLogin.getText();
			String bpassword = this.EnterprisePassword.getText();
			if(StrUilt.isEmpty(bno)&&StrUilt.isEmpty(bname)&&StrUilt.isEmpty(blogin)&&StrUilt.isEmpty(bpassword)) {
				queryAllBusiness();
				return;	
			}
			Business tempStudent2 = new Business();
			tempStudent2.setBno(bno);
			tempStudent2.setBname(bname);
			tempStudent2.setBlogin(blogin);
			tempStudent2.setBpassword(bpassword);
			
			BusinessDao studentDao = new BusinessDao();
			JOptionPane.showMessageDialog(this, studentDao.reviseBusiness(tempStudent2));
			queryAllBusiness();			
		}
		
		
		
	}

	// 删除按钮-删除这一条学生信息
	protected void deleteButton(ActionEvent ae) {
		String rootpwd;
		rootpwd = JOptionPane.showInputDialog("权限密码：");
		if(JOptionPane.showConfirmDialog(this, "是否删除此条数据？","正在删除数据...",JOptionPane.YES_NO_OPTION) == JOptionPane.OK_OPTION&&rootpwd.equals("root")) {
			String bno = dtm.getValueAt(this.businessListTable.getSelectedRow(), 0).toString();
			BusinessDao businessDao = new BusinessDao();
			JOptionPane.showMessageDialog(this, businessDao.deleteBusiness(bno));
			resetButton();
			
			}
		queryAllBusiness();
	}

	// table-选中数据
	protected void selectRow(MouseEvent me) {
		this.EnterpriseNum.setText(dtm.getValueAt(this.businessListTable.getSelectedRow(),0 ).toString());
		this.EnterpriseName.setText(dtm.getValueAt(this.businessListTable.getSelectedRow(),1 ).toString());
		this.EnterpriseLogin.setText(dtm.getValueAt(this.businessListTable.getSelectedRow(),2 ).toString());
		this.EnterprisePassword.setText(dtm.getValueAt(this.businessListTable.getSelectedRow(),3 ).toString());
		this.deleteButton.setEnabled(true);
		this.reviseButton.setEnabled(true);
	}

	// 重置按钮-重置所有文本框
	protected void resetButton() {
		this.EnterpriseNum.setText("");
		this.EnterpriseName.setText("");
		this.EnterpriseLogin.setText("");
		this.EnterprisePassword.setText("");	
		this.deleteButton.setEnabled(false);
		this.reviseButton.setEnabled(false);
	}
	
	// 搜索按钮-搜索学生信息
	protected void selectBusiness(ActionEvent ae) {
		String bno = this.EnterpriseNum.getText();
		String bname = this.EnterpriseName.getText();
		String blogin = this.EnterpriseLogin.getText();
		String bpassword = this.EnterprisePassword.getText();
		if(StrUilt.isEmpty(bno)&&StrUilt.isEmpty(bname)&&StrUilt.isEmpty(blogin)&&StrUilt.isEmpty(bpassword)) {
			queryAllBusiness();
			return;	
		}
		Business tempBusiness1 = new Business();
		tempBusiness1.setBno(bno);
		tempBusiness1.setBname(bname);
		tempBusiness1.setBlogin(blogin);
		tempBusiness1.setBpassword(bpassword);
		
		dtm.setRowCount(0);
		BusinessDao businessDao = new BusinessDao();
		ArrayList<Business> allBusinessList = businessDao.querySomeBusiness(tempBusiness1);
		for(Business stc : allBusinessList) {
			Vector v1 =new Vector();
			v1.add(stc.getBno());
			v1.add(stc.getBname());
			v1.add(stc.getBlogin());
			v1.add(stc.getBpassword());
			dtm.addRow(v1);
		}
		this.deleteButton.setEnabled(false);
		this.reviseButton.setEnabled(false);
	}

	// 显示企业信息
	private void queryAllBusiness() {
		dtm.setRowCount(0);
		BusinessDao businessDao = new BusinessDao();
		ArrayList<Business> allBusinessList = businessDao.queryAllBusiness();
		for(Business stc : allBusinessList) {
			Vector v =new Vector();
			v.add(stc.getBno());
			v.add(stc.getBname());
			v.add(stc.getBlogin());
			v.add(stc.getBpassword());
			dtm.addRow(v);
		}
		this.deleteButton.setEnabled(false);
		this.reviseButton.setEnabled(false);
	}
}

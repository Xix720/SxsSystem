package businessManage;
import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JTextPane;



import java.awt.BorderLayout;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JRadioButton;


import dao.BusinessDao;
import model.Business;
import uilt.StrUilt;


public class AddNewBusiness extends JInternalFrame {
	private JTextField EnterpriseNum;
	private JTextField EnterpriseName;
	private JTextField EnterpriseLogin;
	private JTextField EnterprisePassword;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddNewBusiness frame = new AddNewBusiness();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public AddNewBusiness() {
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
		setTitle("\u6DFB\u52A0\u65B0\u4F01\u4E1A");
		setBounds(100, 100, 642, 409);
		getContentPane().setLayout(null);

		JLabel lblNewLabel = new JLabel("\u4F01\u4E1A\u7F16\u53F7");
		lblNewLabel.setFont(new Font("宋体", Font.PLAIN, 14));
		lblNewLabel.setBounds(45, 103, 58, 26);
		getContentPane().add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("\u4F01\u4E1A\u540D\u79F0");
		lblNewLabel_1.setFont(new Font("宋体", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(45, 139, 58, 26);
		getContentPane().add(lblNewLabel_1);

		JLabel lblNewLabel_3 = new JLabel("\u767B\u9646\u8D26\u53F7");
		lblNewLabel_3.setFont(new Font("宋体", Font.PLAIN, 14));
		lblNewLabel_3.setBounds(45, 185, 58, 26);
		getContentPane().add(lblNewLabel_3);

		JLabel lblNewLabel_3_1 = new JLabel("\u767B\u9646\u5BC6\u7801");
		lblNewLabel_3_1.setFont(new Font("宋体", Font.PLAIN, 14));
		lblNewLabel_3_1.setBounds(45, 231, 58, 26);
		getContentPane().add(lblNewLabel_3_1);

		EnterpriseNum = new JTextField();
		EnterpriseNum.setBounds(128, 106, 182, 21);
		getContentPane().add(EnterpriseNum);
		EnterpriseNum.setColumns(10);

		EnterpriseName = new JTextField();
		EnterpriseName.setColumns(10);
		EnterpriseName.setBounds(128, 144, 182, 21);
		getContentPane().add(EnterpriseName);

		EnterpriseLogin = new JTextField();
		EnterpriseLogin.setColumns(10);
		EnterpriseLogin.setBounds(128, 188, 182, 21);
		getContentPane().add(EnterpriseLogin);

		EnterprisePassword = new JTextField();
		EnterprisePassword.setColumns(10);
		EnterprisePassword.setBounds(128, 234, 182, 21);
		getContentPane().add(EnterprisePassword);

		JLabel lblNewLabel_4 = new JLabel("\u8BF7\u8F93\u5165\u4F01\u4E1A\u4FE1\u606F");
		lblNewLabel_4.setFont(new Font("宋体", Font.PLAIN, 17));
		lblNewLabel_4.setBounds(45, 46, 254, 26);
		getContentPane().add(lblNewLabel_4);

		JButton btnNewButton = new JButton("\u53D6\u6D88");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnNewButton.setFont(new Font("宋体", Font.PLAIN, 14));
		btnNewButton.setBounds(455, 328, 103, 26);
		getContentPane().add(btnNewButton);

		JButton btnNewButton_1 = new JButton("\u521B\u5EFA");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				buildButton(ae);
			}
		});
		btnNewButton_1.setFont(new Font("宋体", Font.PLAIN, 14));
		btnNewButton_1.setBounds(311, 328, 97, 26);
		getContentPane().add(btnNewButton_1);

	}
	
	// 创建按钮
		protected void buildButton(ActionEvent ae) {
			String bno = this.EnterpriseNum.getText();
			if (StrUilt.isEmpty(bno)) {
				JOptionPane.showMessageDialog(this, "企业编号不能为空");
				return;
			}
			String bname = this.EnterpriseName.getText();
			char[] bname1 = bname.toCharArray();
			int t = 0;
			for(t=0;t<bname1.length;t++) {
				if(Character.isDigit(bname1[t])) {
					JOptionPane.showMessageDialog(this, "请输入正确的名称！");
					return;
				}
			}
			if (StrUilt.isEmpty(bname)) {
				JOptionPane.showMessageDialog(this, "企业名称不能为空");
				return;
			}
			
			String blogin = this.EnterpriseLogin.getText();
			if (StrUilt.isEmpty(blogin)) {
				JOptionPane.showMessageDialog(this, "企业账号不能为空");
				return;
			}
			String bpassword = this.EnterprisePassword.getText();
			if (StrUilt.isEmpty(bpassword)) {
				JOptionPane.showMessageDialog(this, "企业密码不能为空");
				return;
			}
			String rootpwd;
			rootpwd = JOptionPane.showInputDialog("权限密码：");
			if(rootpwd.equals("root")) {
			Business tempBusiness = new Business(bno, bname, blogin, bpassword);
			JOptionPane.showMessageDialog(this, new BusinessDao().addBusinessInfo(tempBusiness));
			}else {
				JOptionPane.showMessageDialog(this, "密码错误");
			}
		}

		// 重置按钮
		protected void resetButton() {
			this.EnterpriseNum.setText("");
			this.EnterpriseName.setText("");
			this.EnterpriseLogin.setText("");
			this.EnterprisePassword.setText("");
		}
}

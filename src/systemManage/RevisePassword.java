package systemManage;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;

import View.IndexFrame;
import dao.AdminDao;
import uilt.StrUilt;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class RevisePassword extends JInternalFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField oldText;
	private JTextField newText;
	private JTextField againText;


	public RevisePassword() {
		setTitle("\u4FEE\u6539\u5BC6\u7801");
		
		setClosable(true);
		
		setBounds(100, 100, 360, 300);
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("\u5F53\u524D\u7528\u6237\uFF1A");
		lblNewLabel.setFont(new Font("微软雅黑", Font.PLAIN, 13));
		lblNewLabel.setBounds(38, 33, 74, 15);
		getContentPane().add(lblNewLabel);
		
		String userTypeStr = IndexFrame.userType.getName();
		String adminNameStr = IndexFrame.admin.getName();
		
		JLabel lbladmin = new JLabel("\u3010 "+userTypeStr+"\u3011"+adminNameStr);
		lbladmin.setForeground(Color.RED);
		lbladmin.setFont(new Font("微软雅黑", Font.PLAIN, 13));
		lbladmin.setBounds(126, 34, 158, 15);
		getContentPane().add(lbladmin);
		
		JLabel lblNewLabel_1 = new JLabel("\u65E7\u5BC6\u7801\uFF1A");
		lblNewLabel_1.setFont(new Font("微软雅黑", Font.PLAIN, 13));
		lblNewLabel_1.setBounds(38, 76, 74, 15);
		getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("\u65B0\u5BC6\u7801\uFF1A");
		lblNewLabel_2.setFont(new Font("微软雅黑", Font.PLAIN, 13));
		lblNewLabel_2.setBounds(38, 117, 74, 15);
		getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("\u786E\u8BA4\u5BC6\u7801\uFF1A");
		lblNewLabel_3.setFont(new Font("微软雅黑", Font.PLAIN, 13));
		lblNewLabel_3.setBounds(38, 159, 74, 15);
		getContentPane().add(lblNewLabel_3);
		
		oldText = new JTextField();
		oldText.setBounds(130, 74, 130, 21);
		getContentPane().add(oldText);
		oldText.setColumns(10);
		
		newText = new JTextField();
		newText.setColumns(10);
		newText.setBounds(130, 115, 130, 21);
		getContentPane().add(newText);
		
		againText = new JTextField();
		againText.setColumns(10);
		againText.setBounds(130, 157, 130, 21);
		getContentPane().add(againText);
		
		JButton btnNewButton = new JButton("\u91CD\u7F6E");
		btnNewButton.setFont(new Font("微软雅黑", Font.PLAIN, 13));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				resetButton();
			}
		});
		btnNewButton.setBounds(38, 205, 97, 23);
		getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("\u786E\u8BA4");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				confirmButton(ae);
			}
		});
		btnNewButton_1.setBounds(168, 205, 97, 23);
		getContentPane().add(btnNewButton_1);
		
		

	}

		//确认按钮动作
	protected void confirmButton(ActionEvent ae) {
		// TODO Auto-generated method stub
		String oldPassword = this.oldText.getText();
		String newPassword = this.newText.getText();
		String againPassword = this.againText.getText();
		if(StrUilt.isEmpty(oldPassword)) {
			JOptionPane.showMessageDialog(this, "请输入原密码");
			return;
		}
		if(StrUilt.isEmpty(newPassword)) {
			JOptionPane.showMessageDialog(this, "请输入新密码");
			return;
		}
		if(StrUilt.isEmpty(againPassword)) {
			JOptionPane.showMessageDialog(this, "请再次输入新密码");
			return;
		}
		if("系统管理员".equals(IndexFrame.userType.getName())) {
			AdminDao adminDao = new AdminDao();
			JOptionPane.showMessageDialog(this, adminDao.revisePassword(IndexFrame.admin, newPassword));
			resetButton();
			return;
		}
		if("学生".equals(IndexFrame.userType.getName())) {
			return;
		}
		if("教师".equals(IndexFrame.userType.getName())){
			return;
		}
	}
	

		//重置按钮动作
	protected void resetButton() {
		// TODO Auto-generated method stub
		this.oldText.setText("");
		this.newText.setText("");
		this.againText.setText("");
		
	}
}

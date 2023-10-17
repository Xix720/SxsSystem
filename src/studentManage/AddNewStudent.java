package studentManage;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JTextPane;

import dao.StudentDao;
import model.Student;
import uilt.StrUilt;

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

public class AddNewStudent extends JInternalFrame {
	private JTextField studentSnoText;
	private JTextField studentSnameText;
	private JTextField studentSloginText;
	private JTextField studentSpasswordText;
	private JTextField studentSageText;

	private JRadioButton maleB;
	private JRadioButton femaleB;

	/**
	 * Create the frame.
	 */
	public AddNewStudent() {
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
		setTitle("\u6DFB\u52A0\u5B66\u751F");
		setBounds(100, 100, 400, 411);
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("\u5B66\u53F7");
		lblNewLabel.setFont(new Font("宋体", Font.PLAIN, 14));
		lblNewLabel.setBounds(45, 46, 58, 26);
		getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("\u59D3\u540D");
		lblNewLabel_1.setFont(new Font("宋体", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(45, 82, 58, 26);
		getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("\u6027\u522B");
		lblNewLabel_2.setFont(new Font("宋体", Font.PLAIN, 14));
		lblNewLabel_2.setBounds(45, 118, 58, 26);
		getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("\u767B\u9646\u8D26\u53F7");
		lblNewLabel_3.setFont(new Font("宋体", Font.PLAIN, 14));
		lblNewLabel_3.setBounds(45, 190, 58, 26);
		getContentPane().add(lblNewLabel_3);
		
		JLabel lblNewLabel_3_1 = new JLabel("\u767B\u9646\u5BC6\u7801");
		lblNewLabel_3_1.setFont(new Font("宋体", Font.PLAIN, 14));
		lblNewLabel_3_1.setBounds(45, 226, 58, 26);
		getContentPane().add(lblNewLabel_3_1);
		
		studentSnoText = new JTextField();
		studentSnoText.setBounds(128, 49, 182, 21);
		getContentPane().add(studentSnoText);
		studentSnoText.setColumns(10);
		
		studentSnameText = new JTextField();
		studentSnameText.setColumns(10);
		studentSnameText.setBounds(128, 85, 182, 21);
		getContentPane().add(studentSnameText);
		
		studentSloginText = new JTextField();
		studentSloginText.setColumns(10);
		studentSloginText.setBounds(128, 193, 182, 21);
		getContentPane().add(studentSloginText);
		
		studentSpasswordText = new JTextField();
		studentSpasswordText.setColumns(10);
		studentSpasswordText.setBounds(128, 229, 182, 21);
		getContentPane().add(studentSpasswordText);
		
		JLabel lblNewLabel_4 = new JLabel("\u8BF7\u8F93\u5165\u5B66\u751F\u4FE1\u606F");
		lblNewLabel_4.setFont(new Font("宋体", Font.PLAIN, 17));
		lblNewLabel_4.setBounds(45, 10, 254, 26);
		getContentPane().add(lblNewLabel_4);
		
		JButton btnNewButton = new JButton("\u91CD\u7F6E");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				resetButton();//重置
			}
		});
		btnNewButton.setFont(new Font("宋体", Font.PLAIN, 14));
		btnNewButton.setBounds(207, 302, 103, 26);
		getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("\u521B\u5EFA");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				buildButton(ae);
			}
		});
		btnNewButton_1.setFont(new Font("宋体", Font.PLAIN, 14));
		btnNewButton_1.setBounds(45, 302, 97, 26);
		getContentPane().add(btnNewButton_1);
		
		JLabel lblNewLabel_3_2_2 = new JLabel("\u5E74\u9F84");
		lblNewLabel_3_2_2.setFont(new Font("宋体", Font.PLAIN, 14));
		lblNewLabel_3_2_2.setBounds(45, 154, 58, 26);
		getContentPane().add(lblNewLabel_3_2_2);
		
		studentSageText = new JTextField();
		studentSageText.setColumns(10);
		studentSageText.setBounds(128, 152, 182, 21);
		getContentPane().add(studentSageText);
		
		maleB = new JRadioButton("\u7537");
		maleB.setSelected(true);
		maleB.setBounds(125, 120, 52, 23);
		getContentPane().add(maleB);
		
		femaleB = new JRadioButton("\u5973");
		femaleB.setBounds(193, 120, 63, 23);
		getContentPane().add(femaleB);
		
		ButtonGroup bg = new ButtonGroup();
		bg.add(maleB);
		bg.add(femaleB);
		
		this.maleB.setFocusable(false);
		this.femaleB.setFocusable(false);
		
		btnNewButton.setFocusable(false);
		btnNewButton_1.setFocusable(false);
		
		
	}

	//创建按钮
	protected void buildButton(ActionEvent ae) {
		String sno = this.studentSnoText.getText();
		if(StrUilt.isEmpty(sno)) {
			JOptionPane.showMessageDialog(this, "学生学号不能为空");
			return;
		}
		String sname = this.studentSnameText.getText();
		char[] sname1 = sname.toCharArray();
		int t = 0;
		for(t=0;t<sname1.length;t++) {
			if(Character.isDigit(sname1[t])) {
				JOptionPane.showMessageDialog(this, "请输入正确的姓名！");
				return;
			}
		}
		if(StrUilt.isEmpty(sname)) {
			JOptionPane.showMessageDialog(this, "学生姓名不能为空");
			return;
		}
		String ssex = "男";
		if(this.femaleB.isSelected())
			ssex = "女";
		String sage = this.studentSageText.getText();	
		if(StrUilt.isEmpty(sage)) {
			JOptionPane.showMessageDialog(this, "学生年龄不能为空");
			return;
		}
		String slogin = this.studentSloginText.getText();
		if(StrUilt.isEmpty(slogin)) {
			JOptionPane.showMessageDialog(this, "学生账号不能为空");
			return;
		}
		String spassword = this.studentSpasswordText.getText();
		if(StrUilt.isEmpty(spassword)) {
			JOptionPane.showMessageDialog(this, "学生密码不能为空");
			return;
		}
		
		String rootpwd;
		rootpwd = JOptionPane.showInputDialog("权限密码：");
		if(rootpwd.equals("root")) {
			Student tempStudent = new Student(sno, sname, ssex, sage, slogin, spassword);
			JOptionPane.showMessageDialog(this,new StudentDao().addStudentInfo(tempStudent));
			
		}else {
			JOptionPane.showMessageDialog(this,"密码错误");
		}
		
	}

	//重置按钮
	protected void resetButton() {
		this.studentSnoText.setText("");
		this.studentSnameText.setText("");
		this.maleB.setSelected(true);
		this.studentSloginText.setText("");
		this.studentSpasswordText.setText("");
		this.studentSageText.setText("");	
	}
}

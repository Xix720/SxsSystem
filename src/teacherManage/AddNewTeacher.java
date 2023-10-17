package teacherManage;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JTextPane;

import dao.TeacherDao;
import model.Teacher;
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

public class AddNewTeacher extends JInternalFrame {
	private JTextField teacherTnoText;
	private JTextField teacherTnameText;
	private JTextField teacherTloginText;
	private JTextField teacherTpasswordText;
	private JTextField teacherTageText;

	private JRadioButton maleB;
	private JRadioButton femaleB;

	/**
	 * Create the frame.
	 */
	public AddNewTeacher() {
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
		setTitle("\u6DFB\u52A0\u6559\u5E08");
		setBounds(100, 100, 642, 409);
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("\u6559\u5E08\u7F16\u53F7");
		lblNewLabel.setFont(new Font("宋体", Font.PLAIN, 14));
		lblNewLabel.setBounds(45, 88, 58, 26);
		getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("\u59D3\u540D");
		lblNewLabel_1.setFont(new Font("宋体", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(45, 124, 58, 26);
		getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("\u6027\u522B");
		lblNewLabel_2.setFont(new Font("宋体", Font.PLAIN, 14));
		lblNewLabel_2.setBounds(45, 160, 58, 26);
		getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("\u767B\u9646\u8D26\u53F7");
		lblNewLabel_3.setFont(new Font("宋体", Font.PLAIN, 14));
		lblNewLabel_3.setBounds(45, 232, 58, 26);
		getContentPane().add(lblNewLabel_3);
		
		JLabel lblNewLabel_3_1 = new JLabel("\u767B\u9646\u5BC6\u7801");
		lblNewLabel_3_1.setFont(new Font("宋体", Font.PLAIN, 14));
		lblNewLabel_3_1.setBounds(45, 268, 58, 26);
		getContentPane().add(lblNewLabel_3_1);
		
		JLabel lblNewLabel_3_2_2 = new JLabel("\u5E74\u9F84");
		lblNewLabel_3_2_2.setFont(new Font("宋体", Font.PLAIN, 14));
		lblNewLabel_3_2_2.setBounds(45, 196, 58, 26);
		getContentPane().add(lblNewLabel_3_2_2);
		
		teacherTnoText = new JTextField();
		teacherTnoText.setBounds(128, 91, 182, 21);
		getContentPane().add(teacherTnoText);
		teacherTnoText.setColumns(10);
		
		teacherTnameText = new JTextField();
		teacherTnameText.setColumns(10);
		teacherTnameText.setBounds(128, 127, 182, 21);
		getContentPane().add(teacherTnameText);
		
		teacherTageText = new JTextField();
		teacherTageText.setColumns(10);
		teacherTageText.setBounds(128, 199, 182, 21);
		getContentPane().add(teacherTageText);
		
		teacherTloginText = new JTextField();
		teacherTloginText.setColumns(10);
		teacherTloginText.setBounds(128, 235, 182, 21);
		getContentPane().add(teacherTloginText);
		
		teacherTpasswordText = new JTextField();
		teacherTpasswordText.setColumns(10);
		teacherTpasswordText.setBounds(128, 271, 182, 21);
		getContentPane().add(teacherTpasswordText);
		
		JLabel lblNewLabel_4 = new JLabel("\u8BF7\u8F93\u5165\u6559\u5E08\u4FE1\u606F");
		lblNewLabel_4.setFont(new Font("宋体", Font.PLAIN, 17));
		lblNewLabel_4.setBounds(45, 42, 254, 26);
		getContentPane().add(lblNewLabel_4);
		
		JButton btnNewButton = new JButton("\u91CD\u7F6E");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				resetButton();
			}
		});
		btnNewButton.setFont(new Font("宋体", Font.PLAIN, 14));
		btnNewButton.setBounds(207, 312, 103, 26);
		getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("\u521B\u5EFA");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				buildButton(ae);
			}
		});
		btnNewButton_1.setFont(new Font("宋体", Font.PLAIN, 14));
		btnNewButton_1.setBounds(45, 312, 97, 26);
		getContentPane().add(btnNewButton_1);
		
		btnNewButton.setFocusable(false);
		btnNewButton_1.setFocusable(false);
		
		maleB = new JRadioButton("\u7537");
		maleB.setBounds(127, 162, 58, 23);
		getContentPane().add(maleB);
		
		femaleB = new JRadioButton("\u5973");
		femaleB.setBounds(199, 162, 103, 23);
		getContentPane().add(femaleB);
		
		ButtonGroup bg = new ButtonGroup();
		bg.add(maleB);
		bg.add(femaleB);
		
		this.maleB.setFocusable(false);
		this.femaleB.setFocusable(false);
		
		

	}

	
	//创建按钮
	protected void buildButton(ActionEvent ae) {
		String tno = this.teacherTnoText.getText();
		if(StrUilt.isEmpty(tno)) {
			JOptionPane.showMessageDialog(this, "教师编号不能为空");
			return;
		}
		String tname = this.teacherTnameText.getText();
		char[] tname1 = tname.toCharArray();
		int t = 0;
		for(t=0;t<tname1.length;t++) {
			if(Character.isDigit(tname1[t])) {
				JOptionPane.showMessageDialog(this, "请输入正确的姓名！");
				return;
			}
		}
		if(StrUilt.isEmpty(tname)) {
			JOptionPane.showMessageDialog(this, "教师姓名不能为空");
			return;
		}
		String tsex = "男";
		if(this.femaleB.isSelected())
			tsex = "女";
		String tage = this.teacherTageText.getText();
		if(Integer.parseInt(tage)<18||Integer.parseInt(tage)>25) {
			JOptionPane.showMessageDialog(this, "年龄应当在18-25周岁!");
			return;
		}
		if(StrUilt.isEmpty(tage)) {
			JOptionPane.showMessageDialog(this, "教师年龄不能为空");
			return;
		}
		String tlogin = this.teacherTloginText.getText();
		if(StrUilt.isEmpty(tlogin)) {
			JOptionPane.showMessageDialog(this, "教师账号不能为空");
			return;
		}
		String tpassword = this.teacherTpasswordText.getText();
		if(StrUilt.isEmpty(tpassword)) {
			JOptionPane.showMessageDialog(this, "教师密码不能为空");
			return;
		}
		
		String rootpwd;
		rootpwd = JOptionPane.showInputDialog("权限密码：");
		if(rootpwd.equals("root")){
		Teacher tempTeacher = new Teacher(tno, tname, tsex, tage, tlogin, tpassword);
		JOptionPane.showMessageDialog(this,new TeacherDao().addTeacherInfo(tempTeacher));
		}else {
			JOptionPane.showMessageDialog(this, "密码错误");
		}
		
	}

	protected void resetButton() {
		this.teacherTnoText.setText("");
		this.teacherTnameText.setText("");
		this.maleB.setSelected(true);
		this.teacherTloginText.setText("");
		this.teacherTpasswordText.setText("");
		this.teacherTageText.setText("");	
	}
}

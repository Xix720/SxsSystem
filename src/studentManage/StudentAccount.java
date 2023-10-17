package studentManage;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import model.Admin;

import javax.swing.JSeparator;
import javax.swing.BoxLayout;
import javax.swing.JTabbedPane;
import javax.swing.JSplitPane;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.UIManager;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import javax.swing.JToolBar;
import javax.swing.JComboBox;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JMenuBar;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class StudentAccount extends JFrame {

	private JPanel contentPane;
	public static Admin admin;
	
	private JButton btnNewButton_1_1;
	private JButton btnNewButton_1_2;
	private JButton btnNewButton_1;
	private JButton btnNewButton_1_2_1;


	/**
	 * Create the frame.
	 */
	public StudentAccount(Admin a) {
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
		
		setTitle("学生页面");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 985, 655);
		contentPane = new JPanel();
		contentPane.setBackground(UIManager.getColor("ColorChooser.background"));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		
		btnNewButton_1_1 = new JButton("\u4E2A\u4EBA\u4FE1\u606F");
		btnNewButton_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ShowStudentInfo(admin);
			}
		});
		btnNewButton_1_1.setFont(new Font("微软雅黑", Font.PLAIN, 16));
		btnNewButton_1_1.setBounds(0, 0, 121, 66);
		contentPane.add(btnNewButton_1_1);
		
		btnNewButton_1 = new JButton("\u67E5\u770B\u4EFB\u52A1");
		btnNewButton_1.setFont(new Font("微软雅黑", Font.PLAIN, 16));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ShowMyAssignments(admin);
			}
		});
		btnNewButton_1.setBounds(0, 64, 121, 66);
		contentPane.add(btnNewButton_1);
		
		btnNewButton_1_2 = new JButton("\u67E5\u770B\u6210\u7EE9");
		btnNewButton_1_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ShowDegree(admin);
			}
		});
		btnNewButton_1_2.setFont(new Font("微软雅黑", Font.PLAIN, 16));
		btnNewButton_1_2.setBounds(0, 129, 121, 66);
		contentPane.add(btnNewButton_1_2);
		
		btnNewButton_1_2_1 = new JButton("退出系统");
		btnNewButton_1_2_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnNewButton_1_2_1.setFont(new Font("微软雅黑", Font.PLAIN, 16));
		btnNewButton_1_2_1.setBounds(0, 193, 121, 66);
		contentPane.add(btnNewButton_1_2_1);
	}

	//个人信息
	protected void ShowStudentInfo(Admin admin1) {
		// TODO Auto-generated method stub
				StudentInfo studentinfo = new StudentInfo(admin1);
				studentinfo.setVisible(true);
				contentPane.add(studentinfo);
		
	}
	
	//看任务
	protected void ShowMyAssignments(Admin admin2) {
		// TODO Auto-generated method stub
		MyAssignments myAssignments = new MyAssignments(admin2);
		myAssignments.setVisible(true);
		contentPane.add(myAssignments);
		
	}

	protected void ShowDegree(Admin admin3) {
		// TODO Auto-generated method stub
		MyDegree mydegree = new MyDegree(admin3);
		mydegree.setVisible(true);
		contentPane.add(mydegree);
	}

	


}

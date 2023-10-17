package View;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import businessManage.AddNewBusiness;
import businessManage.BusinessList;
import model.Admin;
import model.UserType;
import studentManage.AddNewStudent;
import studentManage.StudentList;
import systemManage.RevisePassword;
import teacherManage.AddNewTeacher;
import teacherManage.TeacherList;

import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JCheckBox;
import javax.swing.JMenu;
import java.awt.Font;
import javax.swing.JMenuItem;
import javax.swing.JDesktopPane;
import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTabbedPane;

public class IndexFrame extends JFrame {

	private JPanel contentPane;
	private JDesktopPane desktopPane;

	
	public static UserType userType;
	public static Admin admin;

	/**
	 * Create the frame.
	 */
	public IndexFrame(UserType u,Admin a) {
		//��������
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
		
		userType = u;
		admin = a;
		
		setTitle("ʵϰ������ϵͳ ����Ա");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1100, 700);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBackground(new Color(173, 216, 230));
		setJMenuBar(menuBar);
		
		
		//ϵͳ����
		JMenu mnNewMenu = new JMenu("ϵͳ����");
		mnNewMenu.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 15));
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmNewMenuItem =  new JMenuItem("�޸�����");
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				revisePassword(ae);//�޸�����
			}
		});
		mntmNewMenuItem.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 12));
		mnNewMenu.add(mntmNewMenuItem);
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("�˳�ϵͳ");
		mntmNewMenuItem_1.addActionListener(new ActionListener() {
			//�˳�ϵͳ
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		mntmNewMenuItem_1.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 12));
		mnNewMenu.add(mntmNewMenuItem_1);
		
		
		//��ҵ����
		JMenu mnNewMenu_1 = new JMenu("��ҵ����");
		mnNewMenu_1.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 15));
		menuBar.add(mnNewMenu_1);
		
		JMenuItem mntmNewMenuItem_2 = new JMenuItem("\u4F01\u4E1A\u5217\u8868");
		mntmNewMenuItem_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				businessList(ae);
			}
		});
		mnNewMenu_1.add(mntmNewMenuItem_2);
		
		JMenuItem mntmNewMenuItem_2_1 = new JMenuItem("�����ҵ");
		mntmNewMenuItem_2_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				addNewBusiness(ae);
			}
		});
		mnNewMenu_1.add(mntmNewMenuItem_2_1);
		
		JMenu mnNewMenu_1_1 = new JMenu("\u5B66\u751F\u7BA1\u7406");
		mnNewMenu_1_1.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 15));
		menuBar.add(mnNewMenu_1_1);
		
		JMenuItem mntmNewMenuItem_2_2 = new JMenuItem("\u67E5\u770B\u5B66\u751F\u4FE1\u606F");
		mntmNewMenuItem_2_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				studentList(ae);//�鿴ѧ����Ϣ
			}
		});
		mnNewMenu_1_1.add(mntmNewMenuItem_2_2);
		
		JMenuItem mntmNewMenuItem_2_1_3 = new JMenuItem("\u6DFB\u52A0\u5B66\u751F");
		mntmNewMenuItem_2_1_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				addNewStudent(ae);
			}
		});
		mnNewMenu_1_1.add(mntmNewMenuItem_2_1_3);
		
		JMenu mnNewMenu_1_1_1 = new JMenu("\u6559\u5E08\u7BA1\u7406");
		mnNewMenu_1_1_1.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 15));
		menuBar.add(mnNewMenu_1_1_1);
		
		JMenuItem mntmNewMenuItem_2_2_1 = new JMenuItem("\u67E5\u770B\u73B0\u6709\u6559\u5E08");
		mntmNewMenuItem_2_2_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				teacherList(ae);
			}
		});
		mnNewMenu_1_1_1.add(mntmNewMenuItem_2_2_1);
		
		JMenuItem mntmNewMenuItem_2_1_3_1 = new JMenuItem("\u6DFB\u52A0\u6559\u5E08");
		mntmNewMenuItem_2_1_3_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				addNewTeacher(ae);
			}
		});
		mnNewMenu_1_1_1.add(mntmNewMenuItem_2_1_3_1);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		desktopPane = new JDesktopPane();
		desktopPane.setBackground(Color.YELLOW);
		desktopPane.setBounds(219, 153, 1, 1);
		contentPane.add(desktopPane);
	}




	


	//ϵͳ����-�޸�����
	protected void revisePassword(ActionEvent ae) {		
		RevisePassword revisepassword = new	RevisePassword();
		revisepassword.setVisible(true);
		contentPane.add(revisepassword);	
	}
	
	//�鿴��ҵ
	protected void businessList(ActionEvent ae) {
		BusinessList businessList = new BusinessList();
		businessList.setVisible(true);
		contentPane.add(businessList);	
	}
	
	//��������ҵ
	protected void addNewBusiness(ActionEvent ae) {
		AddNewBusiness addNewBusiness = new	AddNewBusiness();
		addNewBusiness.setVisible(true);
		contentPane.add(addNewBusiness);		
	}
	
	//�鿴ѧ��
	protected void studentList(ActionEvent ae) {
		StudentList studentList = new StudentList();
		studentList.setVisible(true);
		contentPane.add(studentList);	
	}
	
	// ���ѧ��
	protected void addNewStudent(ActionEvent ae) {
		AddNewStudent addNewStudent = new AddNewStudent();
		addNewStudent.setVisible(true);
		contentPane.add(addNewStudent);		
	}

	//��ӽ�ʦ
	protected void addNewTeacher(ActionEvent ae) {
		AddNewTeacher addNewTeacher = new AddNewTeacher();
		addNewTeacher.setVisible(true);
		contentPane.add(addNewTeacher);	
	}
	
	//�鿴��ʦ
	protected void teacherList(ActionEvent ae) {
		TeacherList teacherList = new TeacherList();
		teacherList.setVisible(true);
		contentPane.add(teacherList);	
		
	}



}

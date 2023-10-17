package teacherManage;

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
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class TeacherAccount extends JFrame {

	private JPanel contentPane;
	public static Admin admin;

	/**
	 * Create the frame.
	 */
	public TeacherAccount(Admin a) {
		//½çÃæÃÀ»¯
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
		
		setTitle("\u6559\u5E08\u8D26\u53F7");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 985, 655);
		contentPane = new JPanel();
		contentPane.setBackground(UIManager.getColor("ColorChooser.background"));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton_1 = new JButton("\u67E5\u770B\u5DE5\u8D44");
		btnNewButton_1.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 16));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ShowMyWages();
			}
		});
		btnNewButton_1.setBounds(0, 64, 121, 66);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_1_1 = new JButton("\u4E2A\u4EBA\u4FE1\u606F");
		btnNewButton_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ShowTeacherInfo(e);
			}
		});
		btnNewButton_1_1.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 16));
		btnNewButton_1_1.setBounds(0, -1, 121, 66);
		contentPane.add(btnNewButton_1_1);
		
		JButton btnNewButton_1_2 = new JButton("\u4EFB\u52A1\u5217\u8868");
		btnNewButton_1_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ShowTaskInfo(e);
			}
		});
		btnNewButton_1_2.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 16));
		btnNewButton_1_2.setBounds(0, 190, 121, 66);
		contentPane.add(btnNewButton_1_2);
		
		JButton btnNewButton_1_2_1 = new JButton("\u5E03\u7F6E\u4EFB\u52A1");
		btnNewButton_1_2_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddNewTask();
			}
		});
		btnNewButton_1_2_1.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 16));
		btnNewButton_1_2_1.setBounds(0, 126, 121, 66);
		contentPane.add(btnNewButton_1_2_1);
		
		JButton btnNewButton_1_2_2 = new JButton("\u4EFB\u52A1\u8BC4\u7EA7");
		btnNewButton_1_2_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Setrankt();
			}
		});
		btnNewButton_1_2_2.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 16));
		btnNewButton_1_2_2.setBounds(0, 255, 121, 66);
		contentPane.add(btnNewButton_1_2_2);
		
		JButton btnNewButton_1_2_2_1 = new JButton("\u67E5\u770B\u8BC4\u7EA7");
		btnNewButton_1_2_2_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				showmarks();
			}
		});
		btnNewButton_1_2_2_1.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 16));
		btnNewButton_1_2_2_1.setBounds(0, 318, 121, 66);
		contentPane.add(btnNewButton_1_2_2_1);
	}

	protected void showmarks() {
		// TODO Auto-generated method stub
		MarkSystem m1 = new MarkSystem(admin);
		m1.setVisible(true);
		contentPane.add(m1);
	}

	protected void AddNewTask() {
		// TODO Auto-generated method stub
		NewTask t1 = new NewTask(admin);
		t1.setVisible(true);
		contentPane.add(t1);
	}

	protected void ShowTaskInfo(ActionEvent e) {
		// TODO Auto-generated method stub
		Tasksc wage = new Tasksc(admin);
		wage.setVisible(true);
		contentPane.add(wage);
	}

	protected void ShowMyWages() {
		// TODO Auto-generated method stub
		MyWages mywage = new MyWages(admin);
		mywage.setVisible(true);
		contentPane.add(mywage);
		
	}

	protected void ShowTeacherInfo(ActionEvent e) {
		// TODO Auto-generated method stub
		TeacherInfo teacherinfo = new TeacherInfo(admin);
		teacherinfo.setVisible(true);
		contentPane.add(teacherinfo);
	}
	
	protected void Setrankt() {
		// TODO Auto-generated method stub
		Setrank setrank = new Setrank(admin);
		setrank.setVisible(true);
		contentPane.add(setrank);
	}
	
	
}

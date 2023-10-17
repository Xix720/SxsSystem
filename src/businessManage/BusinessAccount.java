package businessManage;


import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import businessManage.BusinessList;
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

public class BusinessAccount extends JFrame {

	private JPanel contentPane;
	public static Admin admin;


	/**
	 * Create the frame.
	 */
	public BusinessAccount(Admin a) {
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
		setTitle("\u4F01\u4E1A\u8D26\u53F7");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 985, 655);
		contentPane = new JPanel();
		contentPane.setBackground(UIManager.getColor("ColorChooser.background"));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton_1 = new JButton("\u96C7\u4F63\u5173\u7CFB");
		btnNewButton_1.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 16));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ShowAllTeachers();
			}
		});
		btnNewButton_1.setBounds(0, 127, 121, 66);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_1_1 = new JButton("\u4F01\u4E1A\u4FE1\u606F");
		btnNewButton_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ShowBusinessInfo(e);
			}
		});
		btnNewButton_1_1.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 16));
		btnNewButton_1_1.setBounds(0, -1, 121, 66);
		contentPane.add(btnNewButton_1_1);
		
		JButton btnNewButton_1_2 = new JButton("\u5DE5\u8D44\u8BB0\u5F55");
		btnNewButton_1_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ShowWagesInfo(e);
			}
		});
		btnNewButton_1_2.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 16));
		btnNewButton_1_2.setBounds(0, 191, 121, 66);
		contentPane.add(btnNewButton_1_2);
		
		JButton btnNewButton_1_3 = new JButton("\u6DFB\u52A0\u6559\u5E08");
		btnNewButton_1_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				AddNewTeacher(ae);
			}
		});
		btnNewButton_1_3.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 16));
		btnNewButton_1_3.setBounds(0, 63, 121, 66);
		contentPane.add(btnNewButton_1_3);
	}

	protected void AddNewTeacher(ActionEvent ae) {
		// TODO Auto-generated method stub
		BusinessTeacher newTeacher = new BusinessTeacher(admin);
		newTeacher.setVisible(true);
		contentPane.add(newTeacher);
		
	}

	protected void ShowWagesInfo(ActionEvent e) {
		// TODO Auto-generated method stub
		Wages wage = new Wages(admin);
		wage.setVisible(true);
		contentPane.add(wage);
	}

	protected void ShowAllTeachers() {
		// TODO Auto-generated method stub
		Labors labor = new Labors(admin);
		labor.setVisible(true);
		contentPane.add(labor);
		
	}

	protected void ShowBusinessInfo(ActionEvent e) {

		BusinessInfo businessinfo = new BusinessInfo(admin);
		businessinfo.setVisible(true);
		contentPane.add(businessinfo);
	}
}

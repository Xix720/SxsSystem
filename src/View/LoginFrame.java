package View;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.border.EmptyBorder;

import businessManage.BusinessAccount;
import dao.AdminDao;
import model.Admin;
import model.UserType;
import studentManage.StudentAccount;
import teacherManage.TeacherAccount;
import uilt.ReadProperties;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.awt.event.ActionEvent;

public class LoginFrame extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField adminName;
	private JTextField adminPsd;
	private JComboBox adminTypeComb;
	
	private static String jdbcDriver ="com.mysql.cj.jdbc.Driver";
	private static ReadProperties rp =ReadProperties.initial();

	
	
	public String dbUrl ;
	public String dbUserName;
	public String dbPassword;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginFrame frame = new LoginFrame();
					//���ñ���
					
					ImageIcon bg = new ImageIcon("src/image/cover.JPG");
					JLabel jl3=new JLabel(bg);
					jl3.setSize(bg.getIconWidth(),bg.getIconHeight());
					frame.getLayeredPane().add(jl3,new Integer(Integer.MIN_VALUE));
					//�����Ϊ͸��
					JPanel pan = (JPanel)frame.getContentPane();
					pan.setOpaque(false);
					
					//��ӵ����
					frame.setSize(bg.getIconWidth(),bg.getIconHeight());
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
	public LoginFrame() {
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
				
				
		setTitle(" \u767B\u5F55\u9875\u9762");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 628, 417);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("\u5B9E\u4E60\u751F\u4FE1\u606F\u7BA1\u7406\u7CFB\u7EDF");
		lblNewLabel.setFont(new Font("����", Font.PLAIN, 40));
		lblNewLabel.setBounds(126, 10, 380, 64);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("\u7528\u6237\u540D\uFF1A");
		lblNewLabel_1.setFont(new Font("΢���ź�", Font.PLAIN, 18));
		lblNewLabel_1.setBounds(126, 123, 76, 18);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("\u5BC6\u7801\uFF1A");
		lblNewLabel_2.setFont(new Font("΢���ź�", Font.PLAIN, 18));
		lblNewLabel_2.setBounds(126, 171, 90, 18);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("\u7528\u6237\u7C7B\u578B\uFF1A");
		lblNewLabel_3.setFont(new Font("΢���ź�", Font.PLAIN, 18));
		lblNewLabel_3.setBounds(126, 223, 100, 19);
		contentPane.add(lblNewLabel_3);
		
		adminTypeComb = new JComboBox();
		adminTypeComb.setModel(new DefaultComboBoxModel(new UserType [] {
				UserType.ADMIN,UserType.TEACHER,UserType.STUDENT,UserType.BUSINESS
		}));//�����˵�
		adminTypeComb.setFont(new Font("΢���ź�", Font.PLAIN, 15));
		adminTypeComb.setBounds(275, 221, 156, 36);
		contentPane.add(adminTypeComb);
		
		adminName = new JTextField();
		adminName.setFont(new Font("΢���ź�", Font.PLAIN, 13));
		adminName.setBounds(274, 121, 157, 30);
		contentPane.add(adminName);
		adminName.setColumns(10);
		
		adminPsd = new JPasswordField();
		
		adminPsd.setFont(new Font("΢���ź�", Font.PLAIN, 13));
		adminPsd.setBounds(274, 169, 157, 30);
		contentPane.add(adminPsd);
		adminPsd.setColumns(10);
		
		
		JButton btnNewButton = new JButton("\u767B\u5F55");//��¼
		btnNewButton.setFont(new Font("΢���ź�", Font.PLAIN, 18));
		btnNewButton.setBounds(353, 286, 108, 49);
		contentPane.add(btnNewButton);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				confirmButton(ae);
			}
		});
				
		JButton btnNewButton_1 = new JButton("\u91CD\u7F6E");//����
		btnNewButton_1.setFont(new Font("΢���ź�", Font.PLAIN, 18));
		btnNewButton_1.setBounds(129, 286, 108, 49);
		contentPane.add(btnNewButton_1);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				resetButton(ae);
			}
		});
		
		btnNewButton.setFocusable(false);//ȡ����ť�����ֵĿ��
		btnNewButton_1.setFocusable(false);
		
		setLocationRelativeTo(null);//ҳ����ת 
		
	}
	
	
	protected void confirmButton(ActionEvent ae) {
		String name = this.adminName.getText();
		String password = this.adminPsd.getText();
		UserType userType = (UserType) this.adminTypeComb.getSelectedItem();
		//����У��
		if(password.length()<6) {
			JOptionPane.showMessageDialog(this, "���볤�ȱ��������λ");
			return;
		}
		
		if("ϵͳ����Ա".equals(userType.getName())) {
			AdminDao adminDao = new AdminDao();
			Admin admin = adminDao.selectAdmin(name, password);
			if(admin == null) {
				JOptionPane.showMessageDialog(this, "�û������������");
				return;
			}
			IndexFrame indexFrame = new IndexFrame(userType, admin);
			//���ñ���
			
			ImageIcon bg = new ImageIcon("src/image/inner.jpg");
			JLabel jl3=new JLabel(bg);
			jl3.setSize(bg.getIconWidth(),bg.getIconHeight());
			indexFrame.getLayeredPane().add(jl3,new Integer(Integer.MIN_VALUE));
			//�����Ϊ͸��
			JPanel pan = (JPanel)indexFrame.getContentPane();
			pan.setOpaque(false);
			
			//��ӵ����
			indexFrame.setSize(bg.getIconWidth(),bg.getIconHeight());
			indexFrame.setVisible(true);
			this.dispose();				
		}
		if("ѧ��".equals(userType.getName())) {
			rp.dbUserName = name;
			rp.dbPassword = password;
			try {
				//�������ݿ�����
				Class.forName(jdbcDriver);
				//��ȡ���ݿ�����
				Connection connection = DriverManager.getConnection(rp.dbUrl, rp.dbUserName, rp.dbPassword);
			}catch(Exception e) {
				e.printStackTrace();
			}
			Admin admin = new Admin();
			admin.setName(name);
			admin.setPassword(password);
			StudentAccount studentaccount = new StudentAccount(admin);
			//���ñ���
			
			ImageIcon bg = new ImageIcon("src/image/inner.jpg");
			JLabel jl3=new JLabel(bg);
			jl3.setSize(bg.getIconWidth(),bg.getIconHeight());
			studentaccount.getLayeredPane().add(jl3,new Integer(Integer.MIN_VALUE));
			//�����Ϊ͸��
			JPanel pan = (JPanel)studentaccount.getContentPane();
			pan.setOpaque(false);
			
			//��ӵ����
			studentaccount.setSize(bg.getIconWidth(),bg.getIconHeight());
			studentaccount.setVisible(true);
			this.dispose();
		}
		if("��ʦ".equals(userType.getName())){
			rp.dbUserName = name;
			rp.dbPassword = password;
			try {
				//�������ݿ�����
				Class.forName(jdbcDriver);
				//��ȡ���ݿ�����
				Connection connection = DriverManager.getConnection(rp.dbUrl, rp.dbUserName, rp.dbPassword);
			}catch(Exception e) {
				e.printStackTrace();
			}
			Admin admin = new Admin();
			admin.setName(name);
			admin.setPassword(password);
			TeacherAccount teacheraccount = new TeacherAccount(admin);
			//���ñ���
			
			ImageIcon bg = new ImageIcon("src/image/inner.jpg");
			JLabel jl3=new JLabel(bg);
			jl3.setSize(bg.getIconWidth(),bg.getIconHeight());
			teacheraccount.getLayeredPane().add(jl3,new Integer(Integer.MIN_VALUE));
			//�����Ϊ͸��
			JPanel pan = (JPanel)teacheraccount.getContentPane();
			pan.setOpaque(false);
			
			//��ӵ����
			teacheraccount.setSize(bg.getIconWidth(),bg.getIconHeight());
			teacheraccount.setVisible(true);
			this.dispose();
		}
		if("��ҵ".equals(userType.getName())){
			rp.dbUserName = name;
			rp.dbPassword = password;
			try {
				//�������ݿ�����
				Class.forName(jdbcDriver);
				//��ȡ���ݿ�����
				Connection connection = DriverManager.getConnection(rp.dbUrl, rp.dbUserName, rp.dbPassword);
			}catch(Exception e) {
				e.printStackTrace();
			}
			
			Admin admin = new Admin();
			admin.setName(name);
			admin.setPassword(password);
			BusinessAccount businessaccount = new BusinessAccount(admin);
			//���ñ���
			
			ImageIcon bg = new ImageIcon("src/image/inner.jpg");
			JLabel jl3=new JLabel(bg);
			jl3.setSize(bg.getIconWidth(),bg.getIconHeight());
			businessaccount.getLayeredPane().add(jl3,new Integer(Integer.MIN_VALUE));
			//�����Ϊ͸��
			JPanel pan = (JPanel)businessaccount.getContentPane();
			pan.setOpaque(false);
			
			//��ӵ����
			businessaccount.setSize(bg.getIconWidth(),bg.getIconHeight());
			businessaccount.setVisible(true);
			this.dispose();
		}
	}
	
	protected void resetButton(ActionEvent ae) {/*����*/
		this.adminName.setText("");
		this.adminPsd.setText("");
		this.adminTypeComb.setSelectedIndex(0);
	}
}

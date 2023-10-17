package studentManage;

import java.awt.EventQueue;
import javax.swing.JInternalFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import dao.StudentDao;
import model.Student;
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

public class StudentList extends JInternalFrame {
	private JTable studentListTable;
	private JTextField studentSnoText;
	private JTextField studentnameText;
	private JTextField studentloginText;
	private JTextField studentpasswordText;
	private JTextField studentageText;
	private JTextField studentsexText;
	private JButton reviseButton;
	private JButton deleteButton;
	private JButton resetButton;
	private JButton searchButton;
	
	
	private DefaultTableModel dtm = null;

	/**
	 * Create the frame.
	 */
	public StudentList() {
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
		
		studentListTable = new JTable();
		studentListTable.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent me) {
				selectRow(me);
			}
		});
		studentListTable.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"\u5B66\u53F7", "\u59D3\u540D", "\u6027\u522B",  "\u5E74\u9F84", "\u767B\u9646\u8D26\u53F7", "\u767B\u9646\u5BC6\u7801"
			}
		));
		scrollPane.setViewportView(studentListTable);
		
		JLabel lblNewLabel = new JLabel("\u5B66\u53F7");
		lblNewLabel.setFont(new Font("微软雅黑", Font.PLAIN, 15));
		lblNewLabel.setBounds(38, 452, 76, 15);
		getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("\u6027\u522B");
		lblNewLabel_1.setFont(new Font("微软雅黑", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(226, 452, 44, 15);
		getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("\u59D3\u540D");
		lblNewLabel_2.setFont(new Font("微软雅黑", Font.PLAIN, 15));
		lblNewLabel_2.setBounds(38, 495, 59, 15);
		getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("\u5E74\u9F84");
		lblNewLabel_3.setFont(new Font("微软雅黑", Font.PLAIN, 15));
		lblNewLabel_3.setBounds(226, 495, 44, 15);
		getContentPane().add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("\u767B\u9646\u8D26\u53F7");
		lblNewLabel_4.setFont(new Font("微软雅黑", Font.PLAIN, 15));
		lblNewLabel_4.setBounds(412, 452, 76, 15);
		getContentPane().add(lblNewLabel_4);
		
		studentSnoText = new JTextField();
		studentSnoText.setBounds(85, 451, 107, 21);
		getContentPane().add(studentSnoText);
		studentSnoText.setColumns(10);
		
		studentnameText = new JTextField();
		studentnameText.setColumns(10);
		studentnameText.setBounds(85, 494, 107, 21);
		getContentPane().add(studentnameText);
		
		studentloginText = new JTextField();
		studentloginText.setColumns(10);
		studentloginText.setBounds(498, 451, 107, 21);
		getContentPane().add(studentloginText);
		
		searchButton = new JButton("\u641C\u7D22");
		searchButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				selectStudent(ae);
			}
		});
		searchButton.setFont(new Font("宋体", Font.PLAIN, 15));
		searchButton.setBounds(652, 450, 97, 23);
		getContentPane().add(searchButton);
		
		reviseButton = new JButton("\u4FEE\u6539");
		reviseButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				reviseButton(ae);
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
		lblNewLabel_1_1.setBounds(412, 495, 76, 15);
		getContentPane().add(lblNewLabel_1_1);
		
		studentpasswordText = new JTextField();
		studentpasswordText.setColumns(10);
		studentpasswordText.setBounds(498, 494, 107, 21);
		getContentPane().add(studentpasswordText);
		
		studentsexText = new JTextField();
		studentsexText.setColumns(10);
		studentsexText.setBounds(280, 452, 107, 20);
		getContentPane().add(studentsexText);
		
		studentageText = new JTextField();
		studentageText.setColumns(10);
		studentageText.setBounds(280, 494, 107, 21);
		getContentPane().add(studentageText);

		this.dtm =(DefaultTableModel) studentListTable.getModel();
		queryAllStudent();
	}
	

	// 显示学生信息
	private void queryAllStudent() {
		dtm.setRowCount(0);
		StudentDao studentDao = new StudentDao();
		ArrayList<Student> allStudentList = studentDao.queryAllStudent();
		for(Student stc : allStudentList) {
			Vector v =new Vector();
			v.add(stc.getSno());
			v.add(stc.getSname());
			v.add(stc.getSsex());
			v.add(stc.getSage());
			v.add(stc.getSlogin());
			v.add(stc.getSpassword());
			dtm.addRow(v);
		}
		this.deleteButton.setEnabled(false);
		this.reviseButton.setEnabled(false);
	}
	
	// 搜索按钮-搜索学生信息
	protected void selectStudent(ActionEvent ae) {
		String sno = this.studentSnoText.getText();
		String sname = this.studentnameText.getText();
		String ssex = this.studentsexText.getText();
		String sage = this.studentageText.getText();
		String slogin = this.studentloginText.getText();
		String spassword = this.studentpasswordText.getText();
		if(StrUilt.isEmpty(sno)&&StrUilt.isEmpty(sname)&&StrUilt.isEmpty(ssex)&&
				StrUilt.isEmpty(sage)&&StrUilt.isEmpty(slogin)&&StrUilt.isEmpty(spassword)) {
			queryAllStudent();
			return;	
		}
		Student tempStudent1 = new Student();
		tempStudent1.setSno(sno);
		tempStudent1.setSname(sname);
		tempStudent1.setSsex(ssex);
		tempStudent1.setSage(sage);
		tempStudent1.setSlogin(slogin);
		tempStudent1.setSpassword(spassword);
		
		dtm.setRowCount(0);
		StudentDao studentDao = new StudentDao();
		ArrayList<Student> allStudentList = studentDao.querySomeStudent(tempStudent1);
		for(Student stc : allStudentList) {
			Vector v1 =new Vector();
			v1.add(stc.getSno());
			v1.add(stc.getSname());
			v1.add(stc.getSsex());
			v1.add(stc.getSage());
			v1.add(stc.getSlogin());
			v1.add(stc.getSpassword());
			dtm.addRow(v1);
		}
		this.deleteButton.setEnabled(false);
		this.reviseButton.setEnabled(false);
	}
	
	// 修改按钮-修改学生数据
	protected void reviseButton(ActionEvent ae) {
		String rootpwd;
		rootpwd = JOptionPane.showInputDialog("权限密码：");
		if(JOptionPane.showConfirmDialog(this, "是否修改此条数据？","正在修改数据...",JOptionPane.YES_NO_OPTION) == JOptionPane.OK_OPTION&&rootpwd.equals("root")) {
			String sno = this.studentSnoText.getText();
			String sname = this.studentnameText.getText();
			char[] sname1 = sname.toCharArray();
			int t = 0;
			for(t=0;t<sname1.length;t++) {
				if(Character.isDigit(sname1[t])) {
					JOptionPane.showMessageDialog(this, "请输入正确的姓名！");
					return;
				}
			}
			String ssex = this.studentsexText.getText();
			String sage = this.studentageText.getText();
			String slogin = this.studentloginText.getText();
			String spassword = this.studentpasswordText.getText();
			if(StrUilt.isEmpty(sno)&&StrUilt.isEmpty(sname)&&StrUilt.isEmpty(ssex)&&
					StrUilt.isEmpty(sage)&&StrUilt.isEmpty(slogin)&&StrUilt.isEmpty(spassword)) {
				queryAllStudent();
				return;	
			}
			Student tempStudent2 = new Student();
			tempStudent2.setSno(sno);
			tempStudent2.setSname(sname);
			tempStudent2.setSsex(ssex);
			tempStudent2.setSage(sage);
			tempStudent2.setSlogin(slogin);
			tempStudent2.setSpassword(spassword);
			
			StudentDao studentDao = new StudentDao();
			JOptionPane.showMessageDialog(this, studentDao.reviseStudent(tempStudent2));
			queryAllStudent();			
		}
		
	}
	
	// 重置按钮-重置所有文本框
	protected void resetButton() {
			this.studentSnoText.setText("");
			this.studentnameText.setText("");
			this.studentsexText.setText("");
			this.studentloginText.setText("");
			this.studentpasswordText.setText("");
			this.studentageText.setText("");	
			this.deleteButton.setEnabled(false);
			this.reviseButton.setEnabled(false);
		}

	// 删除按钮-删除这一条学生信息
	protected void deleteButton(ActionEvent ae) {
		String rootpwd;
		rootpwd = JOptionPane.showInputDialog("权限密码：");
		if(JOptionPane.showConfirmDialog(this, "是否删除此条数据？","正在删除数据...",JOptionPane.YES_NO_OPTION) == JOptionPane.OK_OPTION&&rootpwd.equals("root")) {
			String sno = dtm.getValueAt(this.studentListTable.getSelectedRow(), 0).toString();
			StudentDao studentDao = new StudentDao();
			JOptionPane.showMessageDialog(this, studentDao.deleteStudent(sno));
			resetButton();
			}
		queryAllStudent();	
	}

	// table-选中数据
	protected void selectRow(MouseEvent me) {
		this.studentSnoText.setText(dtm.getValueAt(this.studentListTable.getSelectedRow(),0 ).toString());
		this.studentnameText.setText(dtm.getValueAt(this.studentListTable.getSelectedRow(),1 ).toString());
		this.studentsexText.setText(dtm.getValueAt(this.studentListTable.getSelectedRow(),2 ).toString());
		this.studentageText.setText(dtm.getValueAt(this.studentListTable.getSelectedRow(),3 ).toString());
		this.studentloginText.setText(dtm.getValueAt(this.studentListTable.getSelectedRow(),4 ).toString());
		this.studentpasswordText.setText(dtm.getValueAt(this.studentListTable.getSelectedRow(),5 ).toString());
		this.deleteButton.setEnabled(true);
		this.reviseButton.setEnabled(true);
	}

		

}

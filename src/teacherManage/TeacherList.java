package teacherManage;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import dao.StudentDao;
import dao.TeacherDao;
import model.Student;
import model.Teacher;
import uilt.StrUilt;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Vector;
import java.awt.event.ActionEvent;

public class TeacherList extends JInternalFrame {
	private JTable teacherListTable;
	
	private JTextField teacherTnoText;
	private JTextField teachernameText;
	private JTextField teachersexText;
	private JTextField teacherloginText;
	private JTextField teacherageText;
	private JTextField teacherpasswordText;
	
	private JButton searchButton;
	private JButton resetButton;
	private JButton reviseButton;
	private JButton deleteButton;

	private DefaultTableModel dtm = null;

	/**
	 * Create the frame.
	 */
	public TeacherList() {
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
		
		setTitle("\u67E5\u770B\u6240\u6709\u6559\u5E08");
		setBounds(100, 100, 911, 600);
		getContentPane().setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 10, 879, 409);
		getContentPane().add(scrollPane);
		
		teacherListTable = new JTable();
		teacherListTable.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent me) {
				selectRow(me);
			}
		});
		teacherListTable.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"\u6559\u5E08\u7F16\u53F7", "\u59D3\u540D", "\u6027\u522B", "年龄", "\u767B\u9646\u8D26\u53F7", "\u767B\u9646\u5BC6\u7801"
			}
		));
		scrollPane.setViewportView(teacherListTable);
		
		JLabel lblNewLabel = new JLabel("\u7F16\u53F7");
		lblNewLabel.setFont(new Font("微软雅黑", Font.PLAIN, 15));
		lblNewLabel.setBounds(38, 452, 76, 15);
		getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("\u6027\u522B");
		lblNewLabel_1.setFont(new Font("微软雅黑", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(226, 452, 76, 15);
		getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("\u59D3\u540D");
		lblNewLabel_2.setFont(new Font("微软雅黑", Font.PLAIN, 15));
		lblNewLabel_2.setBounds(38, 495, 59, 15);
		getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("\u767B\u5F55\u5BC6\u7801");
		lblNewLabel_3.setFont(new Font("微软雅黑", Font.PLAIN, 15));
		lblNewLabel_3.setBounds(417, 497, 76, 15);
		getContentPane().add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("\u767B\u9646\u8D26\u53F7");
		lblNewLabel_4.setFont(new Font("微软雅黑", Font.PLAIN, 15));
		lblNewLabel_4.setBounds(417, 452, 76, 15);
		getContentPane().add(lblNewLabel_4);

		JLabel lblNewLabel_6 = new JLabel("\u5E74\u9F84");
		lblNewLabel_6.setFont(new Font("微软雅黑", Font.PLAIN, 15));
		lblNewLabel_6.setBounds(226, 497, 58, 15);
		getContentPane().add(lblNewLabel_6);
		
		teacherTnoText = new JTextField();
		teacherTnoText.setBounds(88, 451, 107, 21);
		getContentPane().add(teacherTnoText);
		teacherTnoText.setColumns(10);
		
		teachernameText = new JTextField();
		teachernameText.setColumns(10);
		teachernameText.setBounds(88, 494, 107, 21);
		getContentPane().add(teachernameText);
		
		teachersexText = new JTextField();
		teachersexText.setColumns(10);
		teachersexText.setBounds(276, 451, 107, 21);
		getContentPane().add(teachersexText);
		
		teacherloginText = new JTextField();
		teacherloginText.setColumns(10);
		teacherloginText.setBounds(503, 451, 107, 21);
		getContentPane().add(teacherloginText);
		
		teacherageText = new JTextField();
		teacherageText.setColumns(10);
		teacherageText.setBounds(276, 494, 107, 21);
		getContentPane().add(teacherageText);
		
		teacherpasswordText = new JTextField();
		teacherpasswordText.setColumns(10);
		teacherpasswordText.setBounds(503, 494, 107, 21);
		getContentPane().add(teacherpasswordText);

		//搜索
		searchButton = new JButton("\u641C\u7D22");
		searchButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				selectButton(ae);
			}
		});
		searchButton.setFont(new Font("宋体", Font.PLAIN, 15));
		searchButton.setBounds(652, 450, 97, 23);
		getContentPane().add(searchButton);
		
		//修改
		reviseButton = new JButton("\u4FEE\u6539");
		reviseButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				reviseButton();
			}
		});
		reviseButton.setFont(new Font("宋体", Font.PLAIN, 15));
		reviseButton.setBounds(759, 450, 97, 23);
		getContentPane().add(reviseButton);
		
		//重置
		resetButton = new JButton("\u91CD\u7F6E");
		resetButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				resetButton();
			}
		});
		resetButton.setFont(new Font("宋体", Font.PLAIN, 15));
		resetButton.setBounds(652, 493, 97, 23);
		getContentPane().add(resetButton);
		
		//删除
		deleteButton = new JButton("\u5220\u9664");
		deleteButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				deleteButton(ae);
			}
		});
		deleteButton.setFont(new Font("宋体", Font.PLAIN, 15));
		deleteButton.setBounds(759, 493, 97, 23);
		getContentPane().add(deleteButton);
		
		this.dtm =(DefaultTableModel) teacherListTable.getModel();
		queryAllTeacher();
		
		
	}
	
	// 显示老师信息
	private void queryAllTeacher() {
		dtm.setRowCount(0);
		TeacherDao teacherDao = new TeacherDao();
		ArrayList<Teacher> allTeacherList = teacherDao.queryAllTeacher();
		for(Teacher stc : allTeacherList) {
			Vector v =new Vector();
			v.add(stc.getTno());
			v.add(stc.getTname());
			v.add(stc.getTsex());
			v.add(stc.getTage());
			v.add(stc.getTlogin());
			v.add(stc.getTpassword());
			dtm.addRow(v);
		}
		this.deleteButton.setEnabled(false);
		this.reviseButton.setEnabled(false);		
	}
	
	// 搜索按钮-搜索老师信息
	protected void selectButton(ActionEvent ae) {
			String tno = this.teacherTnoText.getText();
			String tname = this.teachernameText.getText();
			String tsex = this.teachersexText.getText();
			String tage = this.teacherageText.getText();
			String tlogin = this.teacherloginText.getText();
			String tpassword = this.teacherpasswordText.getText();
			if(StrUilt.isEmpty(tno)&&StrUilt.isEmpty(tname)&&StrUilt.isEmpty(tsex)&&
					StrUilt.isEmpty(tage)&&StrUilt.isEmpty(tlogin)&&StrUilt.isEmpty(tpassword)) {
				queryAllTeacher();
				return;	
			}
			Teacher tempTeacher1 = new Teacher();
			tempTeacher1.setTno(tno);
			tempTeacher1.setTname(tname);
			tempTeacher1.setTsex(tsex);
			tempTeacher1.setTage(tage);
			tempTeacher1.setTlogin(tlogin);
			tempTeacher1.setTpassword(tpassword);
			
			dtm.setRowCount(0);
			TeacherDao teacherDao = new TeacherDao();
			ArrayList<Teacher> allTeacherList = teacherDao.querySomeTeacher(tempTeacher1);
			for(Teacher stc : allTeacherList) {
				Vector v1 =new Vector();
				v1.add(stc.getTno());
				v1.add(stc.getTname());
				v1.add(stc.getTsex());
				v1.add(stc.getTage());
				v1.add(stc.getTlogin());
				v1.add(stc.getTpassword());
				dtm.addRow(v1);
			}
			this.deleteButton.setEnabled(false);
			this.reviseButton.setEnabled(false);
		}

	// 重置按钮	
	protected void resetButton() {
		this.teacherTnoText.setText("");
		this.teachernameText.setText("");
		this.teachersexText.setText("");
		this.teacherloginText.setText("");
		this.teacherpasswordText.setText("");
		this.teacherageText.setText("");	
		this.deleteButton.setEnabled(false);
		this.reviseButton.setEnabled(false);
		
	}

	// 删除按钮-删除这一条学生信息	
	protected void deleteButton(ActionEvent ae) {
		String rootpwd;
		rootpwd = JOptionPane.showInputDialog("权限密码：");
			if(JOptionPane.showConfirmDialog(this, "是否删除此条数据？","正在删除数据...",JOptionPane.YES_NO_OPTION) == JOptionPane.OK_OPTION&&rootpwd.equals("root")) {
				String tno = dtm.getValueAt(this.teacherListTable.getSelectedRow(), 0).toString();
				TeacherDao teacherDao = new TeacherDao();
				JOptionPane.showMessageDialog(this, teacherDao.deleteTeacher(tno));
				resetButton();
				}
			queryAllTeacher();			
		}
	
	//修改按钮
	protected void reviseButton() {
		String rootpwd;
		rootpwd = JOptionPane.showInputDialog("权限密码：");
		
		if(JOptionPane.showConfirmDialog(this, "是否修改此条数据？","正在修改数据...",JOptionPane.YES_NO_OPTION) == JOptionPane.OK_OPTION&&rootpwd.equals("root")) {
			String tno = this.teacherTnoText.getText();
			String tname = this.teachernameText.getText();
			String tsex = this.teachersexText.getText();
			String tage = this.teacherageText.getText();
			String tlogin = this.teacherloginText.getText();
			String tpassword = this.teacherpasswordText.getText();
			if(StrUilt.isEmpty(tno)&&StrUilt.isEmpty(tname)&&StrUilt.isEmpty(tsex)&&
					StrUilt.isEmpty(tage)&&StrUilt.isEmpty(tlogin)&&StrUilt.isEmpty(tpassword)) {
				queryAllTeacher();
				return;	
			}
			Teacher tempTeacher2 = new Teacher();
			tempTeacher2.setTno(tno);
			tempTeacher2.setTname(tname);
			tempTeacher2.setTsex(tsex);
			tempTeacher2.setTage(tage);
			tempTeacher2.setTlogin(tlogin);
			tempTeacher2.setTpassword(tpassword);
			
			TeacherDao teacherDao = new TeacherDao();
			JOptionPane.showMessageDialog(this, teacherDao.reviseTeacher(tempTeacher2));
			queryAllTeacher();			
		}
		
	}
	
	// table-选中数据
	protected void selectRow(MouseEvent me) {
		this.teacherTnoText.setText(dtm.getValueAt(this.teacherListTable.getSelectedRow(),0 ).toString());
		this.teachernameText.setText(dtm.getValueAt(this.teacherListTable.getSelectedRow(),1 ).toString());
		this.teachersexText.setText(dtm.getValueAt(this.teacherListTable.getSelectedRow(),2 ).toString());
		this.teacherageText.setText(dtm.getValueAt(this.teacherListTable.getSelectedRow(),3 ).toString());
		this.teacherloginText.setText(dtm.getValueAt(this.teacherListTable.getSelectedRow(),4 ).toString());
		this.teacherpasswordText.setText(dtm.getValueAt(this.teacherListTable.getSelectedRow(),5 ).toString());
		this.deleteButton.setEnabled(true);
		this.reviseButton.setEnabled(true);
	}
	
}

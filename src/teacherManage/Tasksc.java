package teacherManage;

import java.awt.EventQueue;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.JInternalFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import dao.StudentDao;
import dao.TeacherDao;
import model.Admin;
import model.Assignment;
import model.Degree;
import model.Student;
import model.Teacher;
import uilt.StrUilt;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;

public class Tasksc extends JInternalFrame {
	private JTable Tasks;
	private DefaultTableModel dtm = null;

	public static Admin admin;
	private JTextField TaskNum;
	private JTextField Sno;
	private JButton searchButton;
	private JButton UpdateButton;
	private JLabel lblNewLabel_2;
	private JTextField TaskName;

	/**
	 * Create the frame.
	 */
	public Tasksc(Admin a) {
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
		setClosable(true);
		setTitle("\u6211\u5E03\u7F6E\u7684\u4EFB\u52A1");
		setBounds(100, 100, 610, 410);
		getContentPane().setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 10, 578, 270);
		getContentPane().add(scrollPane);
		
		Tasks = new JTable();
		Tasks.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				selectRow(e);
			}
		});
		Tasks.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"\u5B66\u53F7", "\u4EFB\u52A1\u7F16\u53F7", "\u4EFB\u52A1\u540D\u79F0"
			}
		));
		scrollPane.setViewportView(Tasks);
		
		JLabel lblNewLabel = new JLabel("\u4EFB\u52A1\u7F16\u53F7");
		lblNewLabel.setFont(new Font("微软雅黑", Font.PLAIN, 16));
		lblNewLabel.setBounds(48, 335, 99, 36);
		getContentPane().add(lblNewLabel);
		
		TaskNum = new JTextField();
		TaskNum.setBounds(127, 345, 99, 21);
		getContentPane().add(TaskNum);
		TaskNum.setColumns(10);
		
		UpdateButton = new JButton("\u4FEE\u6539");
		UpdateButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				reviseButton(e);
			}
		});
		UpdateButton.setBounds(470, 344, 97, 23);
		getContentPane().add(UpdateButton);
		
		JLabel lblNewLabel_1 = new JLabel("\u5B66\u53F7");
		lblNewLabel_1.setFont(new Font("微软雅黑", Font.PLAIN, 16));
		lblNewLabel_1.setBounds(48, 290, 99, 36);
		getContentPane().add(lblNewLabel_1);
		
		Sno = new JTextField();
		Sno.setColumns(10);
		Sno.setBounds(127, 304, 99, 21);
		getContentPane().add(Sno);
		
		searchButton = new JButton("\u641C\u7D22");
		searchButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				searchBySnoe(e);
			}
		});
		searchButton.setBounds(470, 299, 97, 23);
		getContentPane().add(searchButton);
		
		lblNewLabel_2 = new JLabel("\u4EFB\u52A1\u540D\u79F0");
		lblNewLabel_2.setFont(new Font("微软雅黑", Font.PLAIN, 16));
		lblNewLabel_2.setBounds(256, 315, 64, 36);
		getContentPane().add(lblNewLabel_2);
		
		TaskName = new JTextField();
		TaskName.setColumns(10);
		TaskName.setBounds(333, 325, 99, 21);
		getContentPane().add(TaskName);
		Admin temptadmin = new Admin();
		this.dtm =(DefaultTableModel) Tasks.getModel();
		queryAllTasks(admin);

	}

	//搜索学生和任务
	protected void searchBySnoe(ActionEvent e) {
		// TODO Auto-generated method stub
		String sno = this.Sno.getText();
		if(StrUilt.isEmpty(sno)) {
			JOptionPane.showMessageDialog(this, "学号不存在");
			return;	
		}
		Assignment tempassignment1 = new Assignment();
		tempassignment1.setSno(sno);
		
		dtm.setRowCount(0);
		StudentDao studentDao = new StudentDao();
		ArrayList<Assignment> allStudentTaskList = studentDao.queryAssignments(tempassignment1.getSno());
		for(Assignment stc : allStudentTaskList) {
			Vector v1 =new Vector();
			v1.add(stc.getSno());
			v1.add(stc.getAno());
			v1.add(stc.getAname());
			dtm.addRow(v1);
		}
	}
	
	//查看任务列表
	private void queryAllTasks(Admin b) {
		// TODO Auto-generated method stub
		String tlogin = b.getName();
		dtm.setRowCount(0);
		TeacherDao teacherDao = new TeacherDao();
		ArrayList<Assignment> allTasks= teacherDao.queryAllTasks(tlogin);
		for(Assignment stc : allTasks) {
			Vector v =new Vector();
			v.add(stc.getSno());
			v.add(stc.getAno());
			v.add(stc.getAname());
			dtm.addRow(v);
		
		}
		
	}
	// 修改按钮-修改任务信息
		protected void reviseButton(ActionEvent ae) {
			if(JOptionPane.showConfirmDialog(this, "是否修改此条数据？","正在修改数据...",JOptionPane.YES_NO_OPTION) == JOptionPane.OK_OPTION) {
				String sno = this.Sno.getText();
				String ano = this.TaskNum.getText();
				String aname = this.TaskName.getText();
				if(StrUilt.isEmpty(sno)&&StrUilt.isEmpty(ano)&&StrUilt.isEmpty(aname)) {
					queryAllTasks(admin);
					return;	
				}
				Assignment tempsc = new Assignment();
				tempsc.setSno(sno);
				tempsc.setAno(ano);
				tempsc.setAname(aname);

				TeacherDao teacherDao = new TeacherDao();
				JOptionPane.showMessageDialog(this, teacherDao.reviseTask(tempsc));
				queryAllTasks(admin);			
			}
			
		}
	// table-选中数据
		protected void selectRow(MouseEvent me) {
			this.Sno.setText(dtm.getValueAt(this.Tasks.getSelectedRow(),0 ).toString());
			this.TaskNum.setText(dtm.getValueAt(this.Tasks.getSelectedRow(),1 ).toString());
			this.TaskName.setText(dtm.getValueAt(this.Tasks.getSelectedRow(),2 ).toString());
		}
}

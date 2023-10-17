package teacherManage;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import dao.StudentDao;
import dao.TeacherDao;
import model.Admin;
import model.Assignment;
import model.Degree;
import uilt.StrUilt;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Vector;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;

public class MarkSystem extends JInternalFrame {
	private JTable TaskSC;
	public static Admin admin;
	private JTextField arankField_3;
	private DefaultTableModel dtm = null;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MarkSystem frame = new MarkSystem(admin);
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
	public MarkSystem(Admin a) {
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
		admin = a;
		setTitle("\u4EFB\u52A1\u8BC4\u7EA7");
		setBounds(100, 100, 603, 400);
		getContentPane().setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 10, 581, 274);
		getContentPane().add(scrollPane);
		
		TaskSC = new JTable();
		TaskSC.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				selectRow(e);
			}
		});
		TaskSC.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"\u5B66\u53F7", "\u4EFB\u52A1\u7F16\u53F7", "\u4EFB\u52A1\u8BC4\u7EA7"
			}
		));
		scrollPane.setViewportView(TaskSC);
		
		arankField_3 = new JTextField();
		arankField_3.setColumns(10);
		arankField_3.setBounds(103, 297, 91, 21);
		getContentPane().add(arankField_3);
		
		JLabel lblNewLabel_3 = new JLabel("\u4EFB\u52A1\u8BC4\u7EA7");
		lblNewLabel_3.setForeground(Color.DARK_GRAY);
		lblNewLabel_3.setFont(new Font("宋体", Font.PLAIN, 16));
		lblNewLabel_3.setBounds(20, 294, 73, 24);
		getContentPane().add(lblNewLabel_3);
		
		JButton MarkButton = new JButton("\u4FEE\u6539");
		MarkButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				reviseButton(e);
			}
		});
		MarkButton.setBounds(262, 296, 97, 23);
		getContentPane().add(MarkButton);
		Admin temptadmin = new Admin();
		this.dtm =(DefaultTableModel) TaskSC.getModel();
		querySC(admin);
	}
	//查看评分列表
		private void querySC(Admin b) {
			// TODO Auto-generated method stub
			String tlogin = b.getName();
			dtm.setRowCount(0);
			TeacherDao teacherDao = new TeacherDao();
			ArrayList<Degree> allTasks= teacherDao.queryAllSC(tlogin);
			for(Degree stc : allTasks) {
				Vector v =new Vector();
				v.add(stc.getSno());
				v.add(stc.getAno());
				v.add(stc.getRank());
				dtm.addRow(v);
			}
		}
		// 修改按钮-修改任务评级
				protected void reviseButton(ActionEvent ae) {
					if(JOptionPane.showConfirmDialog(this, "是否给该任务评级？","正在修改评级...",JOptionPane.YES_NO_OPTION) == JOptionPane.OK_OPTION) {
						String arank = this.arankField_3.getText();
						if(StrUilt.isEmpty(arank)) {
							querySC(admin);
							return;	
						}
						Degree tempsc = new Degree();
						tempsc.setRank(arank);
						TeacherDao teacherDao = new TeacherDao();
						JOptionPane.showMessageDialog(this, teacherDao.reviseRank(tempsc));
						querySC(admin);			
					}
					
				}
	// table-选中数据
			protected void selectRow(MouseEvent me) {
				this.arankField_3.setText(dtm.getValueAt(this.TaskSC.getSelectedRow(),0 ).toString());
			
			}
}

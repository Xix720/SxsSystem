package teacherManage;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import dao.TeacherDao;
import model.Admin;
import model.Assignment;
import model.Degree;
import model.Payrollt;
import uilt.StrUilt;

public class Setrank extends JInternalFrame {


		private JTextField TaskNum;
		private JTextField TaskName;
		private JTextField TaskHandler;

		public static Admin admin;

		/**
		 * Create the frame.
		 */
		public Setrank(Admin a) {
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
			setTitle("任务评级");
			setBounds(100, 100, 611, 409);
			getContentPane().setLayout(null);
			
			JLabel lblNewLabel = new JLabel("\u5B66\u53F7");
			lblNewLabel.setFont(new Font("微软雅黑", Font.PLAIN, 16));
			lblNewLabel.setBounds(63, 138, 68, 25);
			getContentPane().add(lblNewLabel);
			
			TaskNum = new JTextField();
			TaskNum.setBounds(141, 92, 117, 21);
			getContentPane().add(TaskNum);
			TaskNum.setColumns(10);
			
			JLabel lblNewLabel_1 = new JLabel("\u8BC4\u7EA7");
			lblNewLabel_1.setFont(new Font("微软雅黑", Font.PLAIN, 16));
			lblNewLabel_1.setBounds(63, 197, 68, 25);
			getContentPane().add(lblNewLabel_1);
			
			JLabel lblNewLabel_2 = new JLabel("\u4EFB\u52A1\u7F16\u53F7");
			lblNewLabel_2.setFont(new Font("微软雅黑", Font.PLAIN, 16));
			lblNewLabel_2.setBounds(63, 88, 68, 25);
			getContentPane().add(lblNewLabel_2);
			
			TaskName = new JTextField();
			TaskName.setColumns(10);
			TaskName.setBounds(141, 142, 117, 21);
			getContentPane().add(TaskName);
			
			TaskHandler = new JTextField();
			TaskHandler.setColumns(10);
			TaskHandler.setBounds(141, 201, 117, 21);
			getContentPane().add(TaskHandler);
			
			JButton btnNewButton = new JButton("\u786E\u5B9A");
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					addNewTask();
				}
			});
			btnNewButton.setBounds(63, 272, 97, 23);
			getContentPane().add(btnNewButton);
			
			JButton btnNewButton_1 = new JButton("\u91CD\u7F6E");
			btnNewButton_1.setBounds(222, 272, 97, 23);
			getContentPane().add(btnNewButton_1);

		}

		protected void addNewTask() {
			// TODO Auto-generated method stub
			String Ano = this.TaskNum.getText();
			if(StrUilt.isEmpty(Ano)) {
				JOptionPane.showMessageDialog(this, "任务编号不能为空");
				return;
			}
			String Sno = this.TaskName.getText();
			if(StrUilt.isEmpty(Sno)) {
				JOptionPane.showMessageDialog(this, "任务名不能为空");
				return;
			}
			String rank = this.TaskHandler.getText();
			if(StrUilt.isEmpty(rank)) {
				JOptionPane.showMessageDialog(this, "需指定任务评级");
				return;
			}
			if(!rank.equals("A") && !rank.equals("B") && !rank.equals("C") && !rank.equals("D")&& !rank.equals("E")) {
				JOptionPane.showMessageDialog(this, "输入正确评级A,B,C,D,E");
				return;
			}
				
		
			Degree tempTask= new Degree();
			tempTask.setAno(Ano);
			tempTask.setSno(Sno);
			tempTask.setRank(rank);
			tempTask.setTno(admin.getName());
			
			
			JOptionPane.showMessageDialog(this,new TeacherDao().addNewTasksc(tempTask));
			
		}
	
}

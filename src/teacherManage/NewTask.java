package teacherManage;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;

import dao.TeacherDao;
import model.Admin;
import model.Assignment;
import uilt.StrUilt;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class NewTask extends JInternalFrame {
	private JTextField TaskNum;
	private JTextField TaskName;
	private JTextField TaskHandler;

	public static Admin admin;

	/**
	 * Create the frame.
	 */
	public NewTask(Admin a) {
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
		setTitle("\u5E03\u7F6E\u65B0\u4EFB\u52A1");
		setBounds(100, 100, 611, 409);
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("\u4EFB\u52A1\u540D");
		lblNewLabel.setFont(new Font("微软雅黑", Font.PLAIN, 16));
		lblNewLabel.setBounds(63, 138, 68, 25);
		getContentPane().add(lblNewLabel);
		
		TaskNum = new JTextField();
		TaskNum.setBounds(141, 92, 117, 21);
		getContentPane().add(TaskNum);
		TaskNum.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("\u6307\u5B9A\u5B66\u53F7");
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
		
		JButton btnNewButton = new JButton("\u6DFB\u52A0");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addNewTask(e);
			}
		});
		btnNewButton.setBounds(135, 298, 97, 23);
		getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("\u91CD\u7F6E");
		btnNewButton_1.setBounds(358, 298, 97, 23);
		getContentPane().add(btnNewButton_1);

	}

	protected void addNewTask(ActionEvent e) {
		// TODO Auto-generated method stub
		String Ano = this.TaskNum.getText();
		if(StrUilt.isEmpty(Ano)) {
			JOptionPane.showMessageDialog(this, "任务编号不能为空");
			return;
		}
		String Aname = this.TaskName.getText();
		if(StrUilt.isEmpty(Aname)) {
			JOptionPane.showMessageDialog(this, "任务名不能为空");
			return;
		}
		String AHandler = this.TaskHandler.getText();
		if(StrUilt.isEmpty(AHandler)) {
			JOptionPane.showMessageDialog(this, "需指定任务完成者");
			return;
		}
	
		Assignment tempTask= new Assignment(Ano,Aname,AHandler,this.admin.getName());
		JOptionPane.showMessageDialog(this,new TeacherDao().addNewTask(tempTask));
		
	}
}

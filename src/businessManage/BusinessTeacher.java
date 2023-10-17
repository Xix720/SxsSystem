package businessManage;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;

import model.Admin;
import model.Payrollt;
import uilt.StrUilt;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import dao.BusinessDao;

import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class BusinessTeacher extends JInternalFrame {
	private JTextField TeacherTnoText;
	private JTextField TeacherTnameText;
	
	public static Admin admin;

	
	/**
	 * Create the frame.
	 */
	public BusinessTeacher(Admin a) {
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
		
		setTitle("\u6DFB\u52A0\u6559\u5E08");
		setBounds(100, 100, 370, 260);
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("\u7F16\u53F7");
		lblNewLabel.setFont(new Font("微软雅黑", Font.PLAIN, 15));
		lblNewLabel.setBounds(71, 51, 58, 15);
		getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("\u59D3\u540D");
		lblNewLabel_1.setFont(new Font("微软雅黑", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(71, 104, 58, 15);
		getContentPane().add(lblNewLabel_1);
		
		TeacherTnoText = new JTextField();
		TeacherTnoText.setBounds(139, 50, 130, 21);
		getContentPane().add(TeacherTnoText);
		TeacherTnoText.setColumns(10);
		
		TeacherTnameText = new JTextField();
		TeacherTnameText.setColumns(10);
		TeacherTnameText.setBounds(139, 103, 130, 21);
		getContentPane().add(TeacherTnameText);
		
		JButton btnNewButton = new JButton("\u6DFB\u52A0");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddNew(e);
			}
		});
		btnNewButton.setBounds(109, 153, 97, 23);
		getContentPane().add(btnNewButton);

	}


	protected void AddNew(ActionEvent e) {
		String tno = this.TeacherTnoText.getText();
		if (StrUilt.isEmpty(tno)) {
			JOptionPane.showMessageDialog(this, "教师编号不能为空");
			return;
		}
		String tname = this.TeacherTnameText.getText();
		if (StrUilt.isEmpty(tname)) {
			JOptionPane.showMessageDialog(this, "教师名称不能为空");
			return;
		}
		Payrollt temppay = new Payrollt();
		temppay.setTno(tno);
		temppay.setTname(tname);
		JOptionPane.showMessageDialog(this, new BusinessDao().addTeacher(admin,temppay));
			
	}

}

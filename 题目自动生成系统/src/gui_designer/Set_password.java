package gui_designer;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.File;
import java.text.SimpleDateFormat;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;

import user.*;
import assignment_string.Var;
import java.awt.Color;

public class Set_password {

	JFrame frame;
	private JPasswordField passwordField;
	private JPasswordField passwordField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Set_password window = new Set_password();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Set_password() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setTitle("注册界面");
		frame.setResizable(false);
		frame.setBounds(100, 100, 532, 327);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setLocationRelativeTo(null);
		JLabel label_1 = new JLabel("请输入密码：");
		label_1.setFont(new Font("宋体", Font.PLAIN, 25));
		label_1.setBounds(46, 59, 172, 46);
		frame.getContentPane().add(label_1);
		
		JButton button = new JButton("注册并登录");
		button.setBackground(Color.WHITE);
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String s1 = passwordField.getText();
				String s2 = passwordField_1.getText();
				if(s1.equals(s2)==false) {
					JOptionPane.showMessageDialog(frame,"前后两次输入密码不一致，请重新输入！");
					passwordField.setText("");
					passwordField_1.setText("");
					passwordField.requestFocus();
					return;
				}
				Boolean f1 = false;
				Boolean f2  = false;
				Boolean f3  = false;
				Boolean f4  = false;
				if(s1.length()>=6&&s1.length()<=10) {
					f1 = true;
				}
				for(int i=0;i<s1.length();i++) {
					char c = s1.charAt(i);
					if(c>='0'&&c<='9') {
						f2 = true;
					}
					if(c>='a'&&c<='z') {
						f3 = true;
					}
					if(c>='A'&&c<='Z') {
						f4 = true;
					}
				}
				if(f1==false||f2==false||f3==false||f4==false) {
					JOptionPane.showMessageDialog(frame, "您输入密码不满足条件！（6-10位，必须包含大小写英文字母和数字）");
					passwordField.setText("");
					passwordField_1.setText("");
					passwordField.requestFocus();
					return;
				}
//				String password_rule = "^(?![0-9]+$)(?![a-zA-Z]+$)[0-9A-Za-z]{8,16}$";
//				if(!s1.matches(password_rule)) {
//					JOptionPane.showMessageDialog(frame, "您输入密码不满足条件！（6-10位，必须包含大小写英文字母和数字）");
//					passwordField.setText("");
//					passwordField_1.setText("");
//					passwordField.requestFocus();
//					return;
//				}
				User u2 = new User(Var.str,s1);
				User_register .register(u2);
				File dir = new File(Var.str);
				dir.mkdirs();
				//跳转到登录后的界面
				Choose c = new Choose();
				c.frame.setVisible(true);
				frame.dispose();
			}
		});
		button.setFont(new Font("宋体", Font.PLAIN, 15));
		button.setBounds(340, 221, 115, 35);
		frame.getContentPane().add(button);
		
		JButton button_1 = new JButton("取消");
		button_1.setBackground(Color.WHITE);
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Login l = new Login();
				l.frame.setVisible(true);
				frame.dispose();
			}
		});
		button_1.setFont(new Font("宋体", Font.PLAIN, 15));
		button_1.setBounds(46, 221, 65, 35);
		frame.getContentPane().add(button_1);
		
		JLabel label_2 = new JLabel("确认密码：");
		label_2.setFont(new Font("宋体", Font.PLAIN, 25));
		label_2.setBounds(71, 136, 184, 46);
		frame.getContentPane().add(label_2);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(217, 59, 180, 35);
		frame.getContentPane().add(passwordField);
		
		passwordField_1 = new JPasswordField();
		passwordField_1.setBounds(217, 136, 180, 35);
		frame.getContentPane().add(passwordField_1);
		
		JButton button_2 = new JButton("重置");
		button_2.setBackground(Color.WHITE);
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				passwordField.setText("");
				passwordField_1.setText("");
			}
		});
		button_2.setFont(new Font("宋体", Font.PLAIN, 15));
		button_2.setBounds(190, 221, 65, 35);
		frame.getContentPane().add(button_2);
		ImageIcon img = new ImageIcon("H:\\\\java\\\\fyp_test\\\\src\\\\fyp_test\\1.jpg");
		JLabel jl_bg = new JLabel(img); //背景
		jl_bg.setBounds(0, 0, img.getIconWidth(), img.getIconHeight()); //设置位置和大小，先setLayout(null)
	    frame.getLayeredPane().add(jl_bg, new Integer(Integer.MIN_VALUE));
	    ((JPanel)frame.getContentPane()).setOpaque(false); //设置透明
	}
}

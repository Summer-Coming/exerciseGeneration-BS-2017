package gui_designer;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import assignment_string.Var;
import user.User;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.File;
import java.text.SimpleDateFormat;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;
import java.awt.Window.Type;
import user.*;
import java.awt.Color;
import java.awt.SystemColor;
public class Login {

	JFrame frame;
	private JTextField textField;
	private JPasswordField passwordField;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login window = new Login();
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
	public Login() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.WHITE);
		frame.setBackground(Color.WHITE);
		frame.setForeground(Color.BLACK);
		frame.setFont(new Font("Dialog", Font.PLAIN, 30));
		frame.setType(Type.UTILITY);
		frame.setTitle("登录界面");
		frame.setResizable(false);
		frame.setBounds(100, 100, 430, 339);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setLocationRelativeTo(null); 
		//frame.getContentPane().setVisible(false);
		JLabel lblNewLabel = new JLabel("手机号：");
		lblNewLabel.setFont(new Font("宋体", Font.PLAIN, 25));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(46, 59, 123, 29);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel label = new JLabel("密码：");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setFont(new Font("宋体", Font.PLAIN, 25));
		label.setBounds(46, 131, 123, 33);
		frame.getContentPane().add(label);
	    
		
		textField = new JTextField();
		textField.setFont(new Font("宋体", Font.PLAIN, 20));
		textField.setBounds(179, 46, 180, 35);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JButton button = new JButton("登录");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		button.setFont(new Font("宋体", Font.PLAIN, 25));
		button.setBounds(65, 293, 95, 47);
		
		
		JButton button_1 = new JButton("重置");
		button_1.setForeground(Color.BLACK);
		button_1.setBackground(Color.WHITE);
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField.setText("");
				passwordField.setText("");
			}
		});
		button_1.setFont(new Font("宋体", Font.PLAIN, 15));
		button_1.setBounds(179, 214, 65, 35);
		frame.getContentPane().add(button_1);
		
		JButton button_2 = new JButton("注册");
		button_2.setForeground(Color.BLACK);
		button_2.setBackground(Color.WHITE);
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ShortMessages_register r1 = new ShortMessages_register();
				r1.frame.setVisible(true);
				frame.dispose();
				
			}
		});
		button_2.setFont(new Font("宋体", Font.PLAIN, 15));
		button_2.setBounds(303, 214, 65, 35);
		frame.getContentPane().add(button_2);
		
		passwordField = new JPasswordField();
		passwordField.setFont(new Font("宋体", Font.PLAIN, 20));
		passwordField.setBounds(179, 131, 180, 35);
		frame.getContentPane().add(passwordField);
		
		JButton button_3 = new JButton("登录");
		button_3.setForeground(Color.BLACK);
		button_3.setBackground(Color.WHITE);
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String userName = textField.getText();
				String password = passwordField.getText();
				Var.str = userName;
				//定义用户名和密码规则
				String userName_rule = "\\d{11}";
				//String password_rule = "^(?![0-9]+$)(?![a-z]+$)(?![A-Z]+$)[0-9A-Za-z]{8,16}$";
				//String password_rule = "\\w{6,10}";
				//str.matches("^.*[a-zA-Z]+.*$") && str.matches("^.*[0-9]+.*$")
				//数据校验
				if(!userName.matches(userName_rule)) {
					JOptionPane.showMessageDialog(frame, "您输入的手机号不满足条件！");
					textField.setText("");
					textField.requestFocus();
					return;
				}
				Boolean f1 = false;
				Boolean f2  = false;
				Boolean f3  = false;
				Boolean f4  = false;
				if(password.length()>=6&&password.length()<=10) {
					f1 = true;
				}
				for(int i=0;i<password.length();i++) {
					char c = password.charAt(i);
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
					passwordField.requestFocus();
					return;
				}
//				if(!password.matches(password_rule)) {
//					JOptionPane.showMessageDialog(frame, "您输入密码不满足条件！（6-10位，必须包含大小写英文字母和数字）");
//					passwordField.setText("");
//					passwordField.requestFocus();
//					return;
//				}
				
				//封装成用户对象
				User user = new User(userName, password);
				//判断用户是否已经注册，符合条件
				Boolean flag = User_register.login(userName, password);
				if(flag==false) {
					JOptionPane.showMessageDialog(frame, "您登录的账户不存在，请重新登录！");
					textField.setText("");
					passwordField.setText("");
					textField.requestFocus();
				}
				else {
					
					File dir = new File(userName);
					dir.mkdirs();
					
					Choose c = new Choose();
					c.frame.setVisible(true);
					frame.dispose();
				}
			}
		});
		button_3.setFont(new Font("宋体", Font.PLAIN, 15));
		button_3.setBounds(61, 214, 65, 35);
		frame.getContentPane().add(button_3);
		ImageIcon img = new ImageIcon("H:\\\\java\\\\fyp_test\\\\src\\\\fyp_test\\1.jpg");
		JLabel jl_bg = new JLabel(img); //背景
		jl_bg.setBounds(0, 0, img.getIconWidth(), img.getIconHeight()); //设置位置和大小，先setLayout(null)
	    frame.getLayeredPane().add(jl_bg, new Integer(Integer.MIN_VALUE));
	    ((JPanel)frame.getContentPane()).setOpaque(false); //设置透明

		 
		
	}
}


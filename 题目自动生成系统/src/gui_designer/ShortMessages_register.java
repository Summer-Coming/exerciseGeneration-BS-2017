package gui_designer;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import java.awt.Font;
import javax.swing.JTextField;

import com.aliyuncs.exceptions.ClientException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import user.*;
import assignment_string.Var;
import identifying_code.Send;

import java.awt.Color;
import java.awt.Window.Type;

public class ShortMessages_register {

	JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	String s2 = null;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ShortMessages_register window = new ShortMessages_register();
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
	public ShortMessages_register() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setType(Type.UTILITY);
		frame.setResizable(false);
		frame.setBackground(Color.WHITE);
		frame.getContentPane().setBackground(Color.WHITE);
		frame.setTitle("短信注册界面");
		frame.setBounds(0, -39, 575, 324);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setLocationRelativeTo(null); 
		JLabel label = new JLabel("手机号：");
		label.setFont(new Font("宋体", Font.PLAIN, 25));
		label.setBounds(46, 59, 174, 46);
		frame.getContentPane().add(label);
		
		textField = new JTextField();
		textField.setFont(new Font("宋体", Font.PLAIN, 20));
		textField.setBounds(179, 59, 180, 35);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		

		JButton button = new JButton("获取验证码");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String str = textField.getText();
				String userName_rule = "\\d{11}";
				if(!str.matches(userName_rule)) {
					JOptionPane.showMessageDialog(frame, "您输入的手机号不满足条件！");
					textField.setText("");
					textField.requestFocus();
					return;
				}
				//System.out.println(str+"33333333");
				try {
					s2 = Send.main(str);
				} catch (ClientException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		button.setBackground(Color.WHITE);
		button.setForeground(Color.BLACK);
		button.setFont(new Font("宋体", Font.PLAIN, 15));
		button.setBounds(405, 59, 110, 35);
		frame.getContentPane().add(button);
		
		JLabel label_1 = new JLabel("验证码：");
		label_1.setFont(new Font("宋体", Font.PLAIN, 25));
		label_1.setBounds(46, 131, 174, 46);
		frame.getContentPane().add(label_1);
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("宋体", Font.PLAIN, 20));
		textField_1.setColumns(10);
		textField_1.setBounds(179, 131, 180, 35);
		frame.getContentPane().add(textField_1);
		
		JButton button_2 = new JButton("注册");
		button_2.setBackground(Color.WHITE);
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//页面跳转之前的准备工作
				Var.str =textField.getText(); 
				String s1 = textField_1.getText();
				System.out.println(s1);
				if(s1.equals(s2)) {
					Set_password r2 = new Set_password();
					r2.frame.setVisible(true);
					frame.dispose();
				}
				else {
					JOptionPane.showMessageDialog(frame, "您输入的验证码不正确，请重新输入！");
					textField_1.requestFocus();
				}
				
			}
		});
		button_2.setFont(new Font("宋体", Font.PLAIN, 15));
		button_2.setBounds(333, 214, 65, 35);
		frame.getContentPane().add(button_2);
		
		JButton button_1 = new JButton("取消");
		button_1.setBackground(Color.WHITE);
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Login l = new Login();
				l.frame.setVisible(true);
				frame.dispose();
			}
		});
		button_1.setFont(new Font("宋体", Font.PLAIN, 15));
		button_1.setBounds(149, 214, 65, 35);
		frame.getContentPane().add(button_1);
		
		ImageIcon img = new ImageIcon("H:\\\\java\\\\fyp_test\\\\src\\\\fyp_test\\1.jpg");
		JLabel jl_bg = new JLabel(img); //背景
		jl_bg.setBounds(0, 0, img.getIconWidth(), img.getIconHeight()); //设置位置和大小，先setLayout(null)
	    frame.getLayeredPane().add(jl_bg, new Integer(Integer.MIN_VALUE));
	    ((JPanel)frame.getContentPane()).setOpaque(false); //设置透明
	}
}

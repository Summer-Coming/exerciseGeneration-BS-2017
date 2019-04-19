package gui_designer;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JCheckBox;
import java.awt.BorderLayout;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import assignment_string.Var;

import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.text.SimpleDateFormat;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class Choose {

	JFrame frame;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Choose window = new Choose();
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
	public Choose() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.WHITE);
		frame.setBackground(Color.WHITE);
		frame.setTitle("选择界面");
		frame.setBounds(100, 100, 498, 392);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setLocationRelativeTo(null);
		JRadioButton radioButton = new JRadioButton("小学");
		radioButton.setBackground(Color.WHITE);
		radioButton.setFont(new Font("宋体", Font.PLAIN, 20));
		radioButton.setBounds(48, 94, 127, 57);
		frame.getContentPane().add(radioButton);
		
		JRadioButton radioButton_2 = new JRadioButton("初中");
		radioButton_2.setBackground(Color.WHITE);
		radioButton_2.setFont(new Font("宋体", Font.PLAIN, 20));
		radioButton_2.setBounds(177, 94, 127, 57);
		frame.getContentPane().add(radioButton_2);
		
		JRadioButton radioButton_1 = new JRadioButton("高中");
		radioButton_1.setBackground(Color.WHITE);
		radioButton_1.setFont(new Font("宋体", Font.PLAIN, 20));
		radioButton_1.setBounds(306, 94, 127, 57);
		frame.getContentPane().add(radioButton_1);
		
		//让小学、初中和高中三个按钮达到互斥的效果
		ButtonGroup schoolGroup = new ButtonGroup();
		schoolGroup.add(radioButton);
		schoolGroup.add(radioButton_2);
		schoolGroup.add(radioButton_1);
		
		JLabel label = new JLabel("请选择出题类型：");
		label.setFont(new Font("宋体", Font.PLAIN, 25));
		label.setBounds(48, 39, 284, 49);
		frame.getContentPane().add(label);
		
		JLabel label_1 = new JLabel("请输入生成的题目数量：");
		label_1.setFont(new Font("宋体", Font.PLAIN, 25));
		label_1.setBounds(48, 166, 295, 49);
		frame.getContentPane().add(label_1);
		
		textField = new JTextField();
		textField.setFont(new Font("宋体", Font.PLAIN, 25));
		textField.setBounds(353, 167, 72, 47);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JButton button = new JButton("生成试卷");
		button.setBackground(Color.WHITE);
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String str = textField.getText();
				Pattern pattern = Pattern.compile("[0-9]*");
		           Matcher isNum = pattern.matcher(str);
		           if( !isNum.matches() ){
		               JOptionPane.showMessageDialog(frame, "您输入的题目数量不符合要求，请重新输入！");
		               textField.setText("");
		               textField.requestFocus();
		               return;
		           }
				Var.exerciseNum = Integer.parseInt(str);
				if(radioButton.isSelected()) {
					Var.type = "小学";
				}
				if(radioButton_2.isSelected()) {
					Var.type = "初中";
				}
				if(radioButton_1.isSelected()) {
					Var.type = "高中";
				}
				if(Var.type==null) {
					JOptionPane.showMessageDialog(frame, "您未选择题目类型，请选择！");
		               return;
				}
				SimpleDateFormat date_format = new SimpleDateFormat("yyyy-MM-dd-hh-mm-ss");
				Var.date_str = date_format.format(System.currentTimeMillis());
				FileOutputStream fos = null;
				try {
					 fos = new FileOutputStream(Var.str+"\\"+Var.date_str+".txt");
				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				Var.ps = new PrintStream(fos);
				
				Exercise e = new Exercise();
				e.frame.setVisible(true);
				frame.dispose();
			}
		});
		button.setFont(new Font("宋体", Font.PLAIN, 25));
		button.setBounds(140, 266, 140, 50);
		frame.getContentPane().add(button);
//		ImageIcon img = new ImageIcon("H:\\\\java\\\\fyp_test\\\\src\\\\fyp_test\\1.jpg");
//		JLabel jl_bg = new JLabel(img); //背景
//		jl_bg.setBounds(0, 0, img.getIconWidth(), img.getIconHeight()); //设置位置和大小，先setLayout(null)
//	    frame.getLayeredPane().add(jl_bg, new Integer(Integer.MIN_VALUE));
//	    ((JPanel)frame.getContentPane()).setOpaque(false); //设置透明
	}
}

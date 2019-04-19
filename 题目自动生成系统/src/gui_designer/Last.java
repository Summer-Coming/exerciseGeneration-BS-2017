package gui_designer;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JRadioButton;

import assignment_string.Var;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class Last {

	JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Last window = new Last();
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
	public Last() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.WHITE);
		frame.setBounds(100, 100, 372, 409);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setLocationRelativeTo(null); 
		
		JLabel lblNewLabel = new JLabel("本次完成题目：");
		lblNewLabel.setFont(new Font("宋体", Font.PLAIN, 25));
		lblNewLabel.setBounds(47, 29, 227, 46);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("请选择：");
		lblNewLabel_1.setFont(new Font("宋体", Font.PLAIN, 25));
		lblNewLabel_1.setBounds(47, 253, 199, 46);
		frame.getContentPane().add(lblNewLabel_1);
		
		JRadioButton radioButton = new JRadioButton("退出");
		radioButton.setBackground(Color.WHITE);
		radioButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});
		radioButton.setFont(new Font("宋体", Font.PLAIN, 20));
		radioButton.setBounds(47, 305, 89, 46);
		frame.getContentPane().add(radioButton);
		
		JRadioButton radioButton_1 = new JRadioButton("继续做题");
		radioButton_1.setBackground(Color.WHITE);
		radioButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Var.ps = null;
				Var.rightAnswer = 0;
				Choose c = new Choose();
				c.frame.setVisible(true);
				frame.dispose();
			}
		});
		radioButton_1.setFont(new Font("宋体", Font.PLAIN, 20));
		radioButton_1.setBounds(162, 307, 141, 42);
		frame.getContentPane().add(radioButton_1);
		double d = (double)Var.rightAnswer/Var.exerciseNum;
		double dd = (double)Math.round((d*100)*100)/100;
		JLabel lblNewLabel_2 = new JLabel("最终您的得分为："+String.valueOf(dd));
		lblNewLabel_2.setFont(new Font("宋体", Font.PLAIN, 25));
		lblNewLabel_2.setBounds(47, 195, 531, 46);
		frame.getContentPane().add(lblNewLabel_2);
		
		JLabel label_2 = new JLabel(String.valueOf(Var.exerciseNum)+" 道");
		label_2.setFont(new Font("宋体", Font.PLAIN, 25));
		label_2.setBounds(236, 29, 125, 46);
		frame.getContentPane().add(label_2);
		
		JLabel label_3 = new JLabel("满分：100分");
		label_3.setFont(new Font("宋体", Font.PLAIN, 25));
		label_3.setBounds(47, 128, 181, 57);
		frame.getContentPane().add(label_3);
		
		JLabel label_1 = new JLabel("本次做对题目：");
		label_1.setFont(new Font("宋体", Font.PLAIN, 25));
		label_1.setBounds(47, 84, 227, 46);
		frame.getContentPane().add(label_1);
		
		JLabel label_4 = new JLabel(String.valueOf(Var.rightAnswer)+" 道");
		label_4.setFont(new Font("宋体", Font.PLAIN, 25));
		label_4.setBounds(236, 85, 67, 46);
		frame.getContentPane().add(label_4);
	}
}

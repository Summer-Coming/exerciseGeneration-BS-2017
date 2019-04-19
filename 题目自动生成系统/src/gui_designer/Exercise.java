package gui_designer;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JRadioButton;

import assignment_string.Var;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Random;
import java.awt.event.ActionEvent;
import Produce_exercise.*;
import java.awt.Color;
public class Exercise {

	JFrame frame;
	int num = Var.exerciseNum;
	int count = 1;
	String type = Var.type;
	double l = 0;
	//static int rightAnswer = 0;
	int rr =0;
	int n =0;
	Calculate pe = new Calculate();
	Cal_Junior cj = new Cal_Junior();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Exercise window = new Exercise();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		//System.out.println(rightAnswer);
	}

	/**
	 * Create the application.
	 */
	public Exercise() {
		initialize();
		//Var.rightAnswer = rightAnswer;
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.WHITE);
		frame.setTitle("测试题目界面");
		frame.setBounds(100, 100, 675, 460);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setLocationRelativeTo(null);
		JLabel lblNewLabel = new JLabel();
		String ss = null;
		if(type.equals("小学")) {
			ss = Produce_exercise.Exercise.primary_producing(count);
			Var.ps.println(ss);
			l = (double) Math.round(pe.caculate(ss.substring(ss.indexOf("、")+1))*100)/100;
//			System.out.println(l);
		}
		if(type.equals("初中")) {
			ss = Produce_exercise.Exercise.junior_producing(count);
			Var.ps.println(ss);
			l = (double)Math.round(cj.cal_junior(Var.junior_str)*100)/100;
//			System.out.println(cj.cal_junior(Var.junior_str)+"*******");
//			System.out.println(l+"------");
			
		}
		if(type.equals("高中")) {
			ss=Produce_exercise.Exercise.senior_producing(count);
			Var.ps.println(ss);
			l = (double)Math.round(cj.cal_junior(Var.senior_str)*100)/100;
//			System.out.println(cj.cal_junior(Var.senior_str)+"*******");
//			System.out.println(l+"------");
		}
		lblNewLabel.setText(ss);
		
		
		
		String s = String.valueOf(l);
		
		lblNewLabel.setFont(new Font("宋体", Font.PLAIN, 30));
		lblNewLabel.setBounds(69, 91, 559, 74);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("第"+count+"题");
		lblNewLabel_1.setFont(new Font("宋体", Font.PLAIN, 25));
		lblNewLabel_1.setBounds(69, 23, 164, 58);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("共"+num+"道题");
		lblNewLabel_2.setFont(new Font("宋体", Font.PLAIN, 25));
		lblNewLabel_2.setBounds(261, 30, 188, 45);
		frame.getContentPane().add(lblNewLabel_2);
		Random r = new Random();
		
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton();
		rdbtnNewRadioButton.setBackground(Color.WHITE);
		rdbtnNewRadioButton.setFont(new Font("宋体", Font.PLAIN, 25));
		rdbtnNewRadioButton.setBounds(69, 184, 223, 58);
		frame.getContentPane().add(rdbtnNewRadioButton);
		
		JRadioButton radioButton = new JRadioButton();
		radioButton.setBackground(Color.WHITE);
		radioButton.setFont(new Font("宋体", Font.PLAIN, 25));
		radioButton.setBounds(314, 184, 187, 58);
		frame.getContentPane().add(radioButton);
		
		JRadioButton radioButton_1 = new JRadioButton();
		radioButton_1.setBackground(Color.WHITE);
		radioButton_1.setFont(new Font("宋体", Font.PLAIN, 25));
		radioButton_1.setBounds(69, 265, 223, 58);
		frame.getContentPane().add(radioButton_1);
		
		JRadioButton radioButton_2 = new JRadioButton();
		radioButton_2.setBackground(Color.WHITE);
		radioButton_2.setFont(new Font("宋体", Font.PLAIN, 25));
		radioButton_2.setBounds(314, 265, 187, 58);
		frame.getContentPane().add(radioButton_2);
		
		ButtonGroup schoolGroup = new ButtonGroup();
		schoolGroup.add(rdbtnNewRadioButton);
		schoolGroup.add(radioButton);
		schoolGroup.add(radioButton_2);
		schoolGroup.add(radioButton_1);
		
		rr = r.nextInt(100)+1;
		n = r.nextInt(4)+1;
		//System.out.println(n);
		double d = (double)Math.round((l+rr)*100)/100;
		if(n==1) {
			rdbtnNewRadioButton.setText(s);
			radioButton.setText(String.valueOf(d));
			rr = r.nextInt(100)+1;
			d = (double)Math.round((l+rr)*100)/100;
			radioButton_1.setText(String.valueOf(d));
			rr = r.nextInt(100)+1;
			d = (double)Math.round((l+rr)*100)/100;
			radioButton_2.setText(String.valueOf(d));
		}
		if(n==2) {
			rdbtnNewRadioButton.setText(String.valueOf(d));
			radioButton.setText(s);
			rr = r.nextInt(100)+1;
			d = (double)Math.round((l+rr)*100)/100;
			radioButton_1.setText(String.valueOf(d));
			rr = r.nextInt(100)+1;
			d = (double)Math.round((l+rr)*100)/100;
			radioButton_2.setText(String.valueOf(d));
		}
		if(n==3) {
			rdbtnNewRadioButton.setText(String.valueOf(d));
			rr = r.nextInt(100)+1;
			d = (double)Math.round((l+rr)*100)/100;
			radioButton.setText(String.valueOf(d));
			radioButton_1.setText(s);
			rr = r.nextInt(100)+1;
			d = (double)Math.round((l+rr)*100)/100;
			radioButton_2.setText(String.valueOf(d));
		}
		if(n==4) {
			rdbtnNewRadioButton.setText(String.valueOf(d));
			rr = r.nextInt(100)+1;
			d = (double)Math.round((l+rr)*100)/100;
			radioButton.setText(String.valueOf(d));
			rr = r.nextInt(100)+1;
			d = (double)Math.round((l+rr)*100)/100;
			radioButton_1.setText(String.valueOf(d));
			radioButton_2.setText(s);
		}
		JButton button = new JButton("提交");
		button.setBackground(Color.WHITE);
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(n==1&&rdbtnNewRadioButton.isSelected()) {
					Var.rightAnswer++;
					JOptionPane.showMessageDialog(frame, "选择正确");
				}
				else if(n==2&&radioButton.isSelected()) {
					Var.rightAnswer++;
					JOptionPane.showMessageDialog(frame, "选择正确");
				}
				else if(n==3&&radioButton_1.isSelected()) {
					Var.rightAnswer++;
					JOptionPane.showMessageDialog(frame, "选择正确");
				}
				else if(n==4&&radioButton_2.isSelected()) {
					Var.rightAnswer++;
					JOptionPane.showMessageDialog(frame, "选择正确");
				}
				else {
					JOptionPane.showMessageDialog(frame, "选择错误");
				}
				//System.out.println(Var.rightAnswer);
				
				String str = null;

				if(count==num) {
					String []s = new String[num];
					BufferedReader  br = null;
					try {
						br = new BufferedReader(new FileReader(Var.str+"\\"+Var.date_str+".txt"));
						//br = new BufferedReader(new FileReader(Var.str+"\\"+"2018-10-07-11-30-03.txt"));
						String line = null;
						int cnt=0;
						while((line = br.readLine())!=null) {
							s[cnt++]=line.substring(line.indexOf("、")+1);
						}
						Arrays.sort(s);
						Boolean flag = true;
						for(int i=1;i<num;i++) {
							if(s[i].equals(s[i-1])) {
								flag=false;
							}
						}
						if(flag==false) {
							System.out.println("生成题目有重复！");
						}
						else {
							System.out.println("生成题目没有重复！");
						}
						
					}catch (IOException e) {
						e.printStackTrace();
					}
					finally {
						try {
							br.close();
						}catch (IOException e) {
							e.printStackTrace();
						}
					}
					
					//跳出结果，下一个界面
					Last last = new Last();
					last.frame.setVisible(true);
					frame.dispose();
				}
				if(count<num) {
					lblNewLabel_1.setText("第"+(count+1)+"题");
					if(type.equals("小学")) {
						str = Produce_exercise.Exercise.primary_producing(++count);
						Var.ps.println(str);
						String st = str.substring(str.indexOf("、")+1);
						l =(double) Math.round((pe.caculate(st)*100))/100;
						//System.out.println(l);
					}
					if(type.equals("初中")) {
						str = Produce_exercise.Exercise.junior_producing(++count);
						Var.ps.println(str);
						//System.out.println(Var.junior_str);
						l =(double)Math.round(cj.cal_junior(Var.junior_str)*100)/100 ;
						//System.out.println(cj.cal_junior(Var.junior_str)+"*******");
						//System.out.println(l+"------");
					}
					if(type.equals("高中")) {
						str = Produce_exercise.Exercise.senior_producing(++count);
						Var.ps.println(str);
						l = (double) Math.round(cj.cal_junior(Var.senior_str)*100)/100;
						//Var.senior_str = null;
						//System.out.println(cj.cal_junior(Var.senior_str)+"*******");
						//System.out.println(l+"------");
					}
					lblNewLabel.setText(str);
					
					rr = r.nextInt(100)+1;
					n = r.nextInt(4)+1;
					double d = (double)Math.round((l+rr)*100)/100;
					if(n==1) {
						rdbtnNewRadioButton.setText(String.valueOf(l));
						radioButton.setText(String.valueOf(d));
						rr = r.nextInt(100)+1;
						d = (double)Math.round((l+rr)*100)/100;
						radioButton_1.setText(String.valueOf(d));
						rr = r.nextInt(100)+1;
						d = (double)Math.round((l+rr)*100)/100;
						radioButton_2.setText(String.valueOf(d));
					}
					if(n==2) {
						rdbtnNewRadioButton.setText(String.valueOf(d));
						radioButton.setText(String.valueOf(l));
						rr = r.nextInt(100)+1;
						d = (double)Math.round((l+rr)*100)/100;
						radioButton_1.setText(String.valueOf(d));
						rr = r.nextInt(100)+1;
						d = (double)Math.round((l+rr)*100)/100;
						radioButton_2.setText(String.valueOf(d));
					}
					if(n==3) {
						rdbtnNewRadioButton.setText(String.valueOf(d));
						rr = r.nextInt(100)+1;
						d = (double)Math.round((l+rr)*100)/100;
						radioButton.setText(String.valueOf(d));
						radioButton_1.setText(String.valueOf(l));
						rr = r.nextInt(100)+1;
						d = (double)Math.round((l+rr)*100)/100;
						radioButton_2.setText(String.valueOf(d));
					}
					if(n==4) {
						rdbtnNewRadioButton.setText(String.valueOf(d));
						rr = r.nextInt(100)+1;
						d = (double)Math.round((l+rr)*100)/100;
						radioButton.setText(String.valueOf(d));
						rr = r.nextInt(100)+1;
						d = (double)Math.round((l+rr)*100)/100;
						radioButton_1.setText(String.valueOf(d));
						radioButton_2.setText(String.valueOf(l));
					}
				}
				schoolGroup.clearSelection();
			}
		});
		button.setFont(new Font("宋体", Font.PLAIN, 25));
		button.setBounds(179, 351, 90, 45);
		frame.getContentPane().add(button);
		
		JLabel label = new JLabel("");
		label.setBounds(52, 54, 58, 15);
		frame.getContentPane().add(label);
	
	}
}


package Produce_exercise;

import java.util.Random;

import assignment_string.Var;
import java.lang.Math;
public class Exercise {
	public static String primary_producing(int n) {
		String str = null;
		str =String.valueOf(n) +"、";
		Random ran = new Random();
		boolean flag =ran.nextBoolean(); 
		flag = !flag;//flag表示随机判断题目中是否含有括号
		char []c = {'+','-','*','/'};
		int operator = 0;//加减乘除运算随机选
		int number = ran.nextInt(100)+1;
		int num_operator = ran.nextInt(4)+1; //操作符（加减乘除）的个数决定了式子长度,0~4个操作符，决定1~5个操作数
		
		//当只有一个或两个操作数，这种情况下，为了更加规范，是不加括号的
		/*补充：操作数只有一个，即“2=”此种情况太没意思了，在此修改舍去这种情况！*/
		if(flag==false||(flag==true&&(num_operator==1))) {
			str += String.valueOf(number);
			while(num_operator!=0) {
				operator = ran.nextInt(4); //加减乘除随机选
				number = ran.nextInt(100)+1;//数据取值范围在1~100	
				str += String.valueOf(c[operator]);
				str += String.valueOf(number);
				num_operator--;
			}
		}
		//加括号的情况：主要就是括号加的位置要求规范，不能乱加
		else {
			int front = ran.nextInt(num_operator)+1; //前括号加的位置
			int back = ran.nextInt(num_operator+1-front)+front+1;//后括号加的位置必须在前括号的后面，且两者之间要有一个计算式
			int front2 = ran.nextInt(back-front)+front;		
			int back2 = ran.nextInt(back-front2)+front2+1;//后括号加的位置必须在前括号的后面，且两者之间要有一个计算式
			//防止出现前括号在最前面，后括号在最后面这样的情况，不规范，没啥意思！！！
			if(front==1&&back==num_operator+1) {
				front = ran.nextInt(num_operator)+1;
				back = ran.nextInt(num_operator+1-front)+front+1;
			}
			if(front2==1&&back2==num_operator+1) {
				front2 = ran.nextInt(back-front)+front;
				back2 = ran.nextInt(back-front2)+front2+1;
			}
			//防止出现同一个表达式被套两个前括号和两个后括号的情况，还有“(26*(90)+12)*83=”类似这种情况也是不符合规范的！！！
			if(((front==front2)&&(back==back2))||(front2==back)) {
				back2=0;
				front2=0;
			}
			for(int i=1;i<=num_operator+1;i++) {
				if(front==i) {
					str += "(";
				}
				if(front2==i) {
					str += "(";
				}
				number = ran.nextInt(100)+1;//数据取值范围在1~100;
				str += String.valueOf(number);
				if(back==i) {
					str += ")";
				}
				if(back2==i) {
					str += ")";;
				}
				if(i==num_operator+1) break;
				operator = ran.nextInt(4); //加减乘除随机选
				str += String.valueOf(c[operator]);
			}
		}
		str += "= ";
		return str;
	}
	
	public static String junior_producing(int n) {
		// TODO Auto-generated method stub
		String str = null;
		str =String.valueOf(n) +"、";
		Random ran = new Random();
		char []c = {'+','-','*','/'};
		int operator = 0;//加减乘除运算随机选
		int number = ran.nextInt(20)+1;
		int num_operator = ran.nextInt(4)+1; //操作符（加减乘除）的个数决定了式子长度,0~4个操作符，决定1~5个操作数
		int num2_operator = num_operator;
		Boolean b1 = ran.nextBoolean(); //判断是否要对操作数平方
		Boolean b2 = ran.nextBoolean();//判断是否要对操作数开方
		int sum =0;
		if(b1==true&&b2==false) {
			str +=String.valueOf(number) +"²";
			Var.junior_str=String.valueOf((double)Math.round(number*number*100)/100);
		}
		else if(b1==false&&b2==true) {
			str +="√"+String.valueOf(number) ;
			double b = (double) Math.round(Math.sqrt(number)*100)/100;
			Var.junior_str=String.valueOf(b);
		}
		else {
			str +=String.valueOf(number);
			Var.junior_str=String.valueOf((double)Math.round(number*100)/100);
			sum++;
		}
		while(num_operator!=0) {
			operator = ran.nextInt(4); //加减乘除随机选
			b1 = ran.nextBoolean(); //判断是否要对操作数平方
			b2 = ran.nextBoolean();//判断是否要对操作数开方
			number = ran.nextInt(20)+1;//数据取值范围在1~100	
			str += String.valueOf(c[operator]);
			Var.junior_str+=String.valueOf(c[operator]);
			if(b1==true&&b2==false) {
				str +=String.valueOf(number) +"²";
				Var.junior_str+=String.valueOf((double)Math.round(number*number*100)/100);
			}
			else if(b1==false&&b2==true) {
				str +="√"+String.valueOf(number) ;
				double b = (double) Math.round(Math.sqrt(number)*100)/100;
				Var.junior_str+=String.valueOf((double)b);
			}
			else{
				sum++;
				if(sum==num2_operator+1) {
					str +=String.valueOf(number) +"²";
					Var.junior_str+=String.valueOf((double)Math.round(number*number*100)/100);
				}
				else{
					str +=String.valueOf(number);
					Var.junior_str+=String.valueOf((double)Math.round(number*100)/100);
				}
			}
			num_operator--;
		}
		str += "= ";
		Var.junior_str+="= ";
		return str;
	}
	
	/*高中题目要求：题目中至少有一个sin,cos或tan的运算符，每道题目的操作数在1-5个之间，操作数取值范围为1-100。*/
	public static String senior_producing(int n) {
		// TODO Auto-generated method stub
		String str = null;
		str =String.valueOf(n) +"、";
		Random ran = new Random();
		char []c = {'+','-','*','/'};
		int operator = 0;//加减乘除运算随机选
		int number = ran.nextInt(100)+1;
		int num_operator = ran.nextInt(4)+1; //操作符（加减乘除）的个数决定了式子长度,0~4个操作符，决定1~5个操作数
		int num2_operator = num_operator;
		Boolean b_sin = ran.nextBoolean(); //判断是否要对操作数进行正弦运算
		Boolean b_cos = ran.nextBoolean(); //判断是否要对操作数进行余弦运算
		Boolean b_tan = ran.nextBoolean(); //判断是否要对操作数进行正切运算
		int sum =0;
		Boolean flag1 = ran.nextBoolean();
		if(b_sin==true&&b_cos==false&&b_tan==false) {
			if(flag1==true) {
				str +="(sin"+String.valueOf(number)+")²" ;
				double b = (double) Math.round(Math.sin(number*Math.PI/180)*Math.sin(number*Math.PI/180)*100)/100;
				Var.senior_str = String.valueOf(b);
			}
			else {
				str +="sin"+String.valueOf(number) ;
				double b = (double) Math.round(Math.sin(number*Math.PI/180)*100)/100;
				Var.senior_str = String.valueOf(b);
			}	
		}
		else if(b_sin==false&&b_cos==true&&b_tan==false) {
			if(flag1 == true) {
				str +="(cos"+String.valueOf(number)+")²" ;
				double b = (double) Math.round(Math.cos(number*Math.PI/180)*Math.cos(number*Math.PI/180)*100)/100;
				Var.senior_str = String.valueOf(b);
			}
			else {
				str +="cos"+String.valueOf(number) ;
				double b = (double) Math.round(Math.cos(number*Math.PI/180)*100)/100;
				Var.senior_str = String.valueOf(b);
			}
		}
		else if(b_sin==false&&b_cos==false&&b_tan==true) {
			if(flag1 == true) {
				str +="(tan"+String.valueOf(number)+")²" ;
				double b = (double) Math.round(Math.tan(number*Math.PI/180)*Math.tan(number*Math.PI/180)*100)/100;
				Var.senior_str = String.valueOf(b);
			}
			else {
				str +="tan"+String.valueOf(number) ;
				double b = (double) Math.round(Math.tan(number*Math.PI/180)*100)/100;
				Var.senior_str = String.valueOf(b);
			}
		}
		else {
			str +=String.valueOf(number);
			Var.senior_str =String.valueOf((double)number);
			sum++;
		}
		while(num_operator!=0) {
			Boolean flag2 = ran.nextBoolean();
			operator = ran.nextInt(3); //加减乘除随机选
			b_sin = ran.nextBoolean(); //判断是否要对操作数进行正弦运算
			b_cos = ran.nextBoolean(); //判断是否要对操作数进行余弦运算
		    b_tan = ran.nextBoolean(); //判断是否要对操作数进行正切运算
			number = ran.nextInt(100)+1;//数据取值范围在1~100	
			str += String.valueOf(c[operator]);
			Var.senior_str += String.valueOf(c[operator]);
			if(b_sin==true&&b_cos==false&&b_tan==false) {
				if(flag2==true) {
					str +="(√sin"+String.valueOf(number)+")" ;
					double b = (double) Math.round(Math.sqrt(Math.sin(number*Math.PI/180))*100)/100;
					Var.senior_str += String.valueOf(b);
				}
				else {
					str +="sin"+String.valueOf(number) ;
					double b = (double) Math.round(Math.sin(number*Math.PI/180)*100)/100;
					Var.senior_str += String.valueOf(b);
				}
			}
			else if(b_sin==false&&b_cos==true&&b_tan==false) {
				if(flag2==true) {
					str +="(√cos"+String.valueOf(number) +")";
					double b = (double) Math.round(Math.sqrt(Math.cos(number*Math.PI/180))*100)/100;
					Var.senior_str += String.valueOf(b);
				}
				else {
					str +="cos"+String.valueOf(number);
					double b = (double) Math.round(Math.cos(number*Math.PI/180)*100)/100;
					Var.senior_str += String.valueOf(b);
				}
			}
			else if(b_sin==false&&b_cos==false&&b_tan==true) {
				if(flag2==true) {
					str +="(√tan"+String.valueOf(number) +")";
					double b = (double) Math.round(Math.sqrt(Math.tan(number*Math.PI/180))*100)/100;
					Var.senior_str += String.valueOf(b);
				}
				else {
					str +="tan"+String.valueOf(number) ;
					double b = (double) Math.round(Math.tan(number*Math.PI/180)*100)/100;
					Var.senior_str += String.valueOf(b);
				}
			}
			else {
				sum++;
				if(sum==num2_operator+1) {
					str +="tan"+String.valueOf(number) ;
					double b = (double) Math.round(Math.tan(number*Math.PI/180)*100)/100;
					Var.senior_str += String.valueOf(b);
				}
				else {
					str +=String.valueOf(number);
					Var.senior_str += String.valueOf(number);
				}
			}
			num_operator--;
		}
		str += "= ";
		Var.senior_str +="= ";
		//System.out.println(Var.senior_str);
		return str;
	}
	
	
}

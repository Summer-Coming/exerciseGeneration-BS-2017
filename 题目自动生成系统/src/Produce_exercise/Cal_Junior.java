package Produce_exercise;

import java.util.Stack;
import java.lang.Math;
import java.util.Stack;
public class Cal_Junior {
	 /** 数字栈：用于存储表达式中的各个数字 */
    private Stack<Double> numberStack = null;
    /** 符号栈：用于存储运算符和括号 */
    private Stack<Character> symbolStack = null;

    /**
     * 解析并计算四则运算表达式(含括号)，返回计算结果
     * 
     * @param numStr
     *            算术表达式(含括号)
     */
    public double cal_junior(String numStr) {
    	System.out.println("算式可初步计算为（便于判断）："+numStr);
        // 初始化栈
        numberStack = new Stack<Double>();
        symbolStack = new Stack<Character>();
        // 用于缓存数字，因为数字可能是多位的
        StringBuffer temp = new StringBuffer();
        // 从表达式的第一个字符开始处理
        for (int i = 0; i < numStr.length(); i++) {
            char ch = numStr.charAt(i); // 获取一个字符
            if (isNumber(ch)||ch=='.') { // 若当前字符是数字
                temp.append(ch); // 加入到数字缓存中
            } else { // 非数字的情况
                String tempStr = temp.toString(); // 将数字缓存转为字符串
                if (!tempStr.isEmpty()) {
                    double num = Double.parseDouble(tempStr); // 将数字字符串转为长整型数
                    numberStack.push(num); // 将数字压栈
                    temp = new StringBuffer(); // 重置数字缓存
                }
                // 判断运算符的优先级，若当前优先级低于栈顶的优先级，则先把计算前面计算出来
            	double a = 0;
            	double b = 0;
                while (!comparePri(ch) && !symbolStack.empty()) {
                	if(!numberStack.empty()) {
                		b = numberStack.pop(); // 出栈，取出数字，后进先出
                	}
                	if(!numberStack.empty()) {
                		a = numberStack.pop(); // 出栈，取出数字，后进先出
                	}
                    // 取出运算符进行相应运算，并把结果压栈进行下一次运算
                    if(!symbolStack.empty())
                    {
                    	switch ((char) symbolStack.pop()) {
                        case '+':
                            numberStack.push(a + b);
                            break;
                        case '-':
                            numberStack.push(a - b);
                            break;
                        case '*':
                            numberStack.push(a * b);
                            break;
                        case '/':
                            numberStack.push(a / b);
                            break;
                        default:
                            break;
                        }
                    }
                } // while循环结束
                if (ch != '=') {
                    symbolStack.push(new Character(ch)); // 符号入栈
                    if (ch == ')') { // 去括号
                        symbolStack.pop();
                        symbolStack.pop();
                    }
                }
            }
        } // for循环结束

        return numberStack.pop(); // 返回计算结果
    }
    private boolean isNumber(char num) {
        if (num >= '0' && num <= '9')
            return true;
        return false;
    }

    /**
     * 比较优先级：如果当前运算符比栈顶元素运算符优先级高则返回true，否则返回false
     */
    private boolean comparePri(char symbol) {
        if (symbolStack.empty()) { // 空栈返回ture
            return true;
        }

        // 符号优先级说明（从高到低）:
        // 第1级: (
        // 第2级: * /
        // 第3级: + -
        // 第4级: )

        char top = (char) symbolStack.peek(); // 查看堆栈顶部的对象，注意不是出栈
        if (top == '(') {
            return true;
        }
        // 比较优先级
        switch (symbol) { 
        case '(': // 优先级最高
            return true;
        case '*': {
            if (top == '+' || top == '-') // 优先级比+和-高
                return true;
            else
                return false;
        }
        case '/': {
            if (top == '+' || top == '-') // 优先级比+和-高
                return true;
            else
                return false;
        }
        case '+':
            return false;
        case '-':
            return false;
        case ')': // 优先级最低
            return false;
        case '=': // 结束符
            return false;
        default:
            break;
        }
        return true;
    }
}

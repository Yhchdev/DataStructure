package com.yhch.stack;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class PolandNotation {
    public static void main(String[] args) {


        String expression = "1+((2+3)*4)-5";
        List<String> str = expList(expression);
        List<String> suffix = parseSufficexp(str);
        System.out.println(suffix);

        //逆波兰表达式
        //(3+4)*5 -6 => 3 4 + 5 * 6 -
        String exp = "3 4 + 5 * 6 -";

        List<String> numlist = getStringList(exp);
        //System.out.println(numlist);
        int res = calculate(suffix);
        //System.out.printf("逆波兰表达式：3 4 + 5 * 6 - 的值为：%d \n",res);
        System.out.printf("逆波兰表达式的值为：%d \n",res);
    }

    // 中缀表达式 => arrylist
    public static List<String>  expList(String s){
        ArrayList<String> ls = new ArrayList<>();
        int i = 0; // 指针
        StringBuilder builder = new StringBuilder();//对多位数进行拼接
        char ch;
        do {
            // 0[48]  9[57]
            if((ch = s.charAt(i))< 48 ||(ch = s.charAt(i))>57){// 符号直接加入
                ls.add(""+ch);
                i++;
            }else {
                builder.setLength(0);
                //如果是数字 要向后探查 查看是否是多位数
                while (i<s.length() && (ch = s.charAt(i))>= 48 &&(ch = s.charAt(i))<=57 ){
                    builder.append(""+ch);
                    i++;
                }
                ls.add(builder.toString());
            }

        }while (i<s.length());
        return ls;
    }

    // 逆波兰表达式 => arraylist
    public static List<String> getStringList(String exp){
         String [] list= exp.split(" ");
         List<String> numlist = new ArrayList<String>();
         for(String item:list){
             numlist.add(item);
         }
         return numlist;
    }

    // 逆波兰表达式计算
    public static int calculate(List<String> list){
        Stack<String> numstack = new Stack<String>();
        // 数字入栈
        for(String item:list) {
            if (item.matches("\\d+")){ // 匹配多位数
                numstack.push(item);
            }else {//
                int num1 = Integer.parseInt(numstack.pop());
                int num2 = Integer.parseInt(numstack.pop());
                int res = 0;
                if(item.equals("+")){
                    res = num1 + num2;
                }else if(item.equals("-")){
                    res = num2 - num1;
                }else if(item.equals("*")){
                    res = num2 * num1;
                }else if(item.equals("/")){
                    res = num2 / num1;
                }else {
                    throw new RuntimeException("不合法的运算符");
                }
                // 不要忘了 计算结果继续入栈
                numstack.push(""+res);
            }
        }

        return Integer.parseInt(numstack.pop());
    }

    //arrylist => 逆波兰表达式
    // [1, +, (, (, 2, +, 3, ), *, 4, ), -, 5]
    public static List<String> parseSufficexp(List<String> ls){
        // 符号栈
        Stack<String> operstack = new Stack<>();
        // 中间结果 存储列表
        ArrayList<String> processres = new ArrayList<>();
        for(String item:ls){
            if(item.matches("\\d+")){ // 如果是数字直接放入中间结果 s2
                processres.add(item);
            }else if(item.equals("(")){ //左括号直接入栈 s1
                operstack.push(item);
            }else if(item.equals(")")){ // 右括号 依次弹出栈中符号，直到消去左括号 s2.add(s1.pop) 消除左括号
                while (!operstack.peek().equals("(")){
                   processres.add(operstack.pop());
                }
                // 消除（
                operstack.pop();
            }else { // 运算符  判断优先级
                //item 优先级 <= 栈顶  弹出栈顶元素 加入中间结果
                while (operstack.size()!=0 && Operation.getValue(item)<=Operation.getValue(operstack.peek())){
                    processres.add(operstack.pop());
                }
                //item 还需要压入栈中
                operstack.push(item);
            }
        }

        while (operstack.size()!=0){
            processres.add(operstack.pop());
        }
        return processres;
    }


}

// 返回 括号的优先级
class Operation{
    private static int ADD = 1;
    private static int SUB = 1;
    private static int MUL = 2;
    private static int DIV = 2;

    public static int getValue(String oper){
        int res = 0;
        switch (oper){
            case "+":
                res = ADD;
                break;
            case "-":
                res = SUB;
                break;
            case "*":
                res = MUL;
                break;
            case "/":
                res = DIV;
                break;
            default:
                System.out.println("符号不存在");
                break;
        }
        return res;
    }

}

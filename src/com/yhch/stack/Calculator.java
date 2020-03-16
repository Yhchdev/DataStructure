package com.yhch.stack;

// 中缀表达式
public class Calculator {

    public static void main(String[] args) {
        String exp = "100*3+2*2*3-10"; //41
        int num1 = 0;
        int num2 = 0;
        char ch = ' ';
        int oper = 0;
        int res = 0;
        // 辅助指针
        int index = 0;
        // 数字栈
        ArrayStack2 numstack = new ArrayStack2(10);
        // 符号栈
        ArrayStack2 operstack = new ArrayStack2(10);
        // 拼接多位数
        StringBuilder keepNum = new StringBuilder();

        while (true){
            ch = exp.substring(index,index+1).charAt(0);
            // 是运算符
            if(operstack.isOper(ch)){
                if(!operstack.isEmpty()){ // 运算符栈不为空
                    // 当前符号优先级 < 栈顶优先级
                    if(operstack.priority(ch)<=operstack.priority(operstack.peek())){
                        num1 = numstack.pop();
                        num2 = numstack.pop();
                        oper = operstack.pop();
                        res = numstack.cal(num1,num2,oper);
                        numstack.push(res);
                        operstack.push(ch);
                    }else {
                        operstack.push(ch);
                    }
                }else {
                    operstack.push(ch);
                }
            }else {
                //numstack.push(ch-48); // "1+3" '1' 字符1(49)  and 1
                keepNum.append(ch);
                //针对多位数的情况
                // 如果已经是最后一位了 那么直接入数栈
                if(index == exp.length()-1){
                    numstack.push(Integer.parseInt(keepNum.toString()));
                }else {
                    // 向后探查一位 如果是符号  则前面拼接的入数栈
                    if(operstack.isOper(exp.substring(index+1,index+2).charAt(0))){
                        numstack.push(Integer.parseInt(keepNum.toString()));
                        // 清空之前拼接的数字
                        keepNum.setLength(0);
                    }

                }
            }
            index++;
            if(index>=exp.length()){
                break;
            }
        }



        while (true){
            // 符号栈为空 那么计算也就结束了
            if(operstack.isEmpty()){
                break;
            }
            num1 = numstack.pop();
            num2 = numstack.pop();
            oper = operstack.pop();
            res = numstack.cal(num1,num2,oper);
            numstack.push(res);
        }
        System.out.printf("表达式：%s = %d",exp,res);
    }
}



// 用数组实现一个栈
class ArrayStack2{
    private int maxsize;
    private int[] stack;
    // 栈顶指针
    private int top = -1;


    //构造器
    public ArrayStack2(int maxsize){
        this.maxsize = maxsize;
        stack = new int[this.maxsize];
    }

    public boolean isEmpty(){
        return top == -1;
    }

    public boolean isFull(){
        return top == maxsize-1;
    }

    public void push(int value){
        if(isFull()){
            System.out.println("栈满");
            return;
        }
        top++;
        stack[top] = value;
    }

    public int peek(){
        return stack[top];
    }

    public int pop(){
        if(isEmpty()){
            throw new RuntimeException("栈空");
        }
        int value = stack[top];
        top--;
        return value;
    }

    //遍历栈

    public void list(){
        if(isEmpty()){
            System.out.println("栈空");
        }
        // 反向遍历 从大到下
        for(int i= top;i>=0;i--){
            int value = stack[i];
            System.out.printf("stack[%d] = %d \n",i,value);
        }
    }

    // 返回符号的优先级，数字越大优先级越高
    public int priority(int oper){
        // char的本质 比较的时候也是一个数字
        if(oper == '*' || oper == '/'){
            return 1;
        }else if(oper =='+'|| oper =='-'){
            return 0;
        }else {
            return -1;
        }
    }

    // 判断是否是符号
    public boolean isOper(char val){
        return val=='+' || val=='-' || val=='*' || val=='/';
    }

    // 计算 java里 int 和char是可以混用的，本质上都是数字
    public int cal(int num1,int num2,int oper){
        int res = 0;
        switch (oper){
            case '+':
                res = num1 + num2;
                break;
            case '-':
                res = num2 -  num1;
                break;
            case '*':
                res = num1 * num2;
                break;
            case '/':
                res = num2 / num1;
                break;
            default:
                break;
        }
        return res;
    }

}


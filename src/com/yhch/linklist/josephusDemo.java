package com.yhch.linklist;

// 约瑟夫问题（丢手绢）
public class josephusDemo {

    public static void main(String[] args) {
        CircleSingleLinkedList circleSingleLinkedList = new CircleSingleLinkedList();
        circleSingleLinkedList.addBoy(5);
        //circleSingleLinkedList.show();
        circleSingleLinkedList.countBoy(1,2,5);


    }
}

// 循环单链表类
class CircleSingleLinkedList{
    private Boy first = null;

    public void addBoy(int nums){
        if (nums < 1){
            System.out.println("nums 的值不合法");
            return;
        }
        // 指向当前 boy
        Boy curBoy = null;
        for(int i = 1;i<=nums;i++){
            Boy boy = new Boy(i);
            // 第一个小孩
            if(i==1){ //
                first = boy;
                first.setNext(first); // 构成一个环
                curBoy = first;
            }else {
                curBoy.setNext(boy);
                boy.setNext(first);
                curBoy = boy;
            }
        }
    }


    public void show(){
        if(first == null){
            System.out.println("没有小孩");
            return;
        }
        Boy curBoy = first;
        while (true){
            System.out.printf("小孩的编号 %d \n",curBoy.getNo());
            if(curBoy.getNext() == first){
                break;
            }
            curBoy = curBoy.getNext();
        }
    }

    /**
     *
     * @param startNo 从第几个开始数
     * @param countNum 数到几出圈
     * @param nums 一共有几个
     */
    public void countBoy(int startNo,int countNum,int nums){
        if(first == null||startNo <1 || startNo>nums){
            System.out.println("输入的参数，不合法");
        }
        // 1 . 定义辅助变量 移动到 倒数第一个
        Boy helper = first;
        while (true){
            if(helper.getNext() == first){
                break;
            }
            helper = helper.getNext();
        }
        // 2. 报数前，先让移动startNo - 1次
        for(int i = 1;i <= startNo-1;i++){
            first = first.getNext();
            helper = helper.getNext();
        }
        // 3. 报数countnums次 这里是一个循环退出的操作
        int i = 0;   // while 中 套 for
        while (true){
            i++;
            if(first == helper){
                break;
            }
            // 报数次数
            for(int j=1;j<=countNum-1;j++){
                first = first.getNext();
                helper = helper.getNext();
            }
            System.out.printf("第%d次循环,出圈者编号为:%d \n",i,first.getNo());
            first = first.getNext();
            helper.setNext(first);

        }
        System.out.printf("圈中最后剩余者编号为:%d \n",first.getNo());

    }

}


class Boy{
    // 编号
    private int no;
    // 下一节点
    private Boy next;

    public Boy(int no) {
        this.no = no;
    }


    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public Boy getNext() {
        return next;
    }

    public void setNext(Boy next) {
        this.next = next;
    }
}



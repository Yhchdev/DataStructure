package com.yhch.linklist;

public class DoublelinkedlistDemo {

    public static void main(String[] args) {

        System.out.println("双向链表");

        // 双向链表的添加
        HeroNode2 hero1 = new HeroNode2(1,"宋江","及时雨");
        HeroNode2 hero2 = new HeroNode2(2,"卢俊义","玉麒麟");
        HeroNode2 hero3 = new HeroNode2(3,"吴用","智多星");
        HeroNode2 hero4 = new HeroNode2(4,"林冲","豹子头");
        Doublelinkedlist doublelinkedlist = new Doublelinkedlist();
//        doublelinkedlist.add(hero1);
//        doublelinkedlist.add(hero2);
//        doublelinkedlist.add(hero3);
//        doublelinkedlist.add(hero4);

        doublelinkedlist.addByOrder(hero1);
        doublelinkedlist.addByOrder(hero4);
        doublelinkedlist.addByOrder(hero2);
        doublelinkedlist.addByOrder(hero3);
        doublelinkedlist.list();


        /*
        // 双向链表的遍历
        doublelinkedlist.list();

        // 修改

        HeroNode2 heroNode2 = new HeroNode2(4,"公孙胜","入云龙");
        doublelinkedlist.update(heroNode2);

        System.out.println("双向链表的修改");
        doublelinkedlist.list();


        System.out.println("双向链表的删除");
        doublelinkedlist.del(3);
        doublelinkedlist.list();
        *
         */
    }
}



class Doublelinkedlist {
    // 头结点
    HeroNode2 head = new HeroNode2(0, "", "");

    public HeroNode2 getHead() {
        return head;
    }

    // 遍历
    public void list(){
        // 判断链表是否为空
        if (head.next == null){
            System.out.println("链表为空");
            return;
        }
        HeroNode2 temp = head.next;
        while (true){
            if (temp == null){
                break;
            }
            System.out.println(temp);
            // 指针后移
            temp = temp.next;
        }
        return;
    }

    // 结点添加思路 单链表 不考虑添加顺序
    // 1.先找到最后一个结点
    // 2.然后将最后一个结点的next 指向新添加的结点
    public void add(HeroNode2 heroNode){
        HeroNode2 temp = head;
        while (true){
            if (temp.next == null){
                break;
            }
            temp = temp.next;
        }
        //temp.next = heroNode;
        temp.next = heroNode;
        // pre指向
        heroNode.pre = temp;
    }


    // 按顺序添加 链表的指定位置添加
    public void addByOrder(HeroNode2 heroNode){

        HeroNode2 temp = head;
        Boolean flag = false;
        while (true){
            // 1.空链表
            if(temp.next == null){
                break;
            }
            // 找到了添加位置   temp.no(2) temp.next.no(7)
            if(temp.next.no > heroNode.no){
                break;
            }else if(temp.next.no == heroNode.no){ //插入了编号相同的
                flag = true;
                break;
            }
            // 继续遍历
            temp = temp.next;
        }
        if(flag){
            System.out.printf("添加的编号已经存在 %d\n",heroNode.no);
            return;
        }
        // 1.尾部
        // 1.1 后连接
        heroNode.next = temp.next;
        // 1.2 前连接
        if(temp.next !=null) {
            temp.next.pre = heroNode ;
        }
        // 2.头部
        // 2.1 后连接
        temp.next = heroNode;
        // 2.2 前连接
        heroNode.pre = temp ;
    }

    // 修改结点
    public void update(HeroNode2 newHeroNode){
        HeroNode2 temp = head;
        Boolean flag = false;
        if(temp.next == null){
            System.out.println("链表为空");
            return;
        }
        while (true){
            if(temp == null){ // 遍历结束
                break;
            }
            if (temp.no == newHeroNode.no){ //找到了要修改的结点
                flag =true;
                break;
            }
            temp = temp.next;
        }
        if(!flag){
            System.out.printf("要修改的结点编号 %d不存在：\n",newHeroNode.no);
        }else {
            temp.name = newHeroNode.name;
            temp.nickname = newHeroNode.nickname;
        }
    }

    // 删除节点：
    // 思路分析：1.直接找到待删除节点；
    // 2.
    public void del(int no){
        HeroNode2 temp = head.next;
        Boolean flag = false;
        while (true){
            if(temp == null){
                //System.out.println("链表为空");
                break;
            }
            if(temp.no == no){
                flag =true;
                break;
            }
            // 后移
            temp = temp.next;
        }
        if(flag) {
            //temp.next = temp.next.next;
             temp.pre.next = temp.next;
             // 这里有问题 如果是最后一个结点
            if(temp.next !=null){
                temp.next.pre = temp.pre;
            }


        }else {
            System.out.printf("待删除的编号不存在: %d \n",no);
        }
    }



}

// 结点类
class HeroNode2{
    public int no;
    public String name;
    public String nickname;
    // 后一节点
    public HeroNode2 next;
    // 前一节点
    public HeroNode2 pre;

    // 构造函数
    public HeroNode2(int no,String name, String nickname){
        this.no = no;
        this.name = name;
        this.nickname = nickname;
    }
    // 为了显示方便 重写tosting
    @Override
    public String toString() {
        return "HeroNode{" +
                "no=" + no +
                ", name='" + name + '\'' +
                ", nickname='" + nickname + '\'' +
                '}';
    }
}







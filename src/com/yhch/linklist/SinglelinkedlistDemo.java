package com.yhch.linklist;

/**
 * 1.单链表  data域 next域
 * 2. 指针后移
 */

public class SinglelinkedlistDemo {
    public static void main(String[] args) {

        HeroNode hero1 = new HeroNode(1,"宋江","及时雨");
        HeroNode hero2 = new HeroNode(2,"卢俊义","玉麒麟");
        HeroNode hero3 = new HeroNode(3,"吴用","智多星");
        HeroNode hero4 = new HeroNode(4,"林冲","豹子头");
        Singlelinkedlist singlelinkedlist = new Singlelinkedlist();

//        singlelinkedlist.add(hero1);
//        singlelinkedlist.add(hero2);
//        singlelinkedlist.add(hero3);
//        singlelinkedlist.add(hero4);

        singlelinkedlist.addByOrder(hero1);
        singlelinkedlist.addByOrder(hero2);
        singlelinkedlist.addByOrder(hero4);
        singlelinkedlist.addByOrder(hero3);
       // singlelinkedlist.addByOrder(hero3);



//        singlelinkedlist.list();
//
//        System.out.println("修改后");
//        singlelinkedlist.update(new HeroNode(3,"无用","智多星III"));
//        singlelinkedlist.update(new HeroNode(88,"无用","智多星III"));


        singlelinkedlist.list();
        System.out.println("删除后~~");
        singlelinkedlist.del(1);
        singlelinkedlist.del(88);
        singlelinkedlist.list();
    }
}


class Singlelinkedlist{
    // 头结点
    HeroNode head = new HeroNode(0,"","");


    // 结点添加思路 单链表 不考虑添加顺序
    // 1.先找到最后一个结点
    // 2.然后将最后一个结点的next 指向新添加的结点
    public void add(HeroNode heroNode){
        HeroNode temp = head;
        while (true){
            if (temp.next == null){
                break;
            }
            temp = temp.next;
        }
        temp.next = heroNode;
    }

    // 遍历
    public void list(){
        // 判断链表是否为空
        if (head.next == null){
            System.out.println("链表为空");
            return;
        }

      HeroNode temp = head.next;
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

    // 按顺序添加 链表的指定位置添加
    public void addByOrder(HeroNode heroNode){

        HeroNode temp = head;
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
        heroNode.next = temp.next;
        // 2.头部
        temp.next = heroNode;
    }

    // 修改结点
    public void update(HeroNode newHeroNode){
        HeroNode temp = head;
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
    // 思路分析：1.找到待删除节点的前一节点；
    // 2.temp.next = temp.next.next
    public void del(int no){
        HeroNode temp = head;
        Boolean flag = false;
        while (true){
            if(temp.next == null){
                //System.out.println("链表为空");
                break;
            }
            if(temp.next.no == no){
                flag =true;
                break;
            }
            // 后移
            temp = temp.next;
        }
        if(flag) {
            temp.next = temp.next.next;
        }else {
            System.out.printf("待删除的编号不存在: %d \n",no);
        }
    }

}


class HeroNode{
    public int no;
    public String name;
    public String nickname;
    public HeroNode next;

    // 构造函数
    public HeroNode(int no,String name, String nickname){
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

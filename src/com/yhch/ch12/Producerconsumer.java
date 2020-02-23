package com.yhch.ch12;
import java.util.ArrayList;
import java.util.List;

//枪
class Gun{
    //弹夹中的子弹
    List<Integer> bullet = new ArrayList<>();
    // 生产者 添加子弹
    public synchronized void addBullet(int i){
        //子弹已经满了
        if(bullet.size() == 5){
            try {
                // 添加子弹的线程可以进入等待队列
                this.wait();
            }catch (InterruptedException e){
                System.out.println(e);
            }
        }
        bullet.add(i);
        System.out.println("添加了一颗子弹");
        // 唤醒发射子弹的线程
        this.notify();
    }

    //消费者  射出子弹
    public synchronized void shootBullet(int i ){

        // 没有子弹了
        if(bullet.size() == 0){
            try {
                // 发射子弹的线程 可以进入等待队列
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        bullet.remove(i-1);
        System.out.println("射出了第"+i+"棵子弹");
        // 唤醒当前等待队列中的 生产者线程
        this.notify();

    }
}

// 压入子弹的多线程
class AddBullet extends Thread{
    Gun agun;
    // 构造函数
    public AddBullet(Gun gun){
        this.agun = gun;
    }

    @Override
    public void run(){
        for(int i = 0;i<13;i++){
            agun.addBullet(i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

// 射出子弹的多线程

class ShootBullet extends Thread{
    Gun agun;

    public ShootBullet(Gun gun){
        this.agun = gun;
    }

    @Override
    public void run(){
        for(int i= 0;i<12;i++){
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("aGun.bullet.size:"+agun.bullet.size());
            agun.shootBullet(agun.bullet.size());
        }
    }
}


// 生产者       --   消费者 模型
// 子弹压入弹夹       子弹射出弹夹
public class Producerconsumer {
    public static void main(String[] args) {
        Gun agun = new Gun();
        AddBullet add = new AddBullet(agun);
        ShootBullet shoot = new ShootBullet(agun);

        // 启动线程
        add.start();
        shoot.start();
    }
}

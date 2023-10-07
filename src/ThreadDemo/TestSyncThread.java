package ThreadDemo;

import javax.management.MalformedObjectNameException;

class Sale{
    public String name;
    public Sale(String name) {
        this.name = name;
    }
    synchronized public static void money() {
        //效果同syn(Sale.class),但是定义的是静态方法，因此只能修改线程名来作为名字
            try {
                System.out.println(Thread.currentThread().getName() + " 被领导表扬");
                Thread.sleep(500);
                System.out.println(Thread.currentThread().getName() + " 拿钱");
                Thread.sleep(500);
                System.out.println(Thread.currentThread().getName() + " 对公司表示感谢");
                Thread.sleep(500);
                System.out.println(Thread.currentThread().getName() + " 开开心心的拿钱走人");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
class SaleMoney extends Thread{
    private Sale p;
    public SaleMoney(Sale p){
        this.p=p;
        this.setName(p.name);
    }
    @Override
    public void run(){
        this.p.money();
    }
}
class Programmer{
    private String name;
    public Programmer(String name){
        this.name=name;
    }

    synchronized public void computer() //书写方法和synchronize(this)同
    {
        try{
            System.out.println(this.name+" 接通电源");
            Thread.sleep(500);
            System.out.println(this.name+" 按开机按键");
            Thread.sleep(500);
            System.out.println(this.name+" 系统启动中");
            Thread.sleep(500);
            System.out.println(this.name+" 系统启动成功");
        }catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public void coding(){
        synchronized (this){
        try{
            System.out.println(this.name+" 双击IDEA");
            Thread.sleep(500);
            System.out.println(this.name+" 等待IDEA启动");
            Thread.sleep(500);
            System.out.println(this.name+" IDEA完毕");
            Thread.sleep(500);
            System.out.println(this.name+" 开开心心写代码");
        }catch (InterruptedException e) {
            e.printStackTrace();
        }
        }
    }
    public void wc(){
        synchronized ("")//只是代表锁对象的一个标志名称，所有对象经过此函数都会并行改串行
                //和this锁的限定方式不同，this锁一般用作对象中多个函数并行改串行
        {
            try{
            System.out.println(this.name+" 打开卫生间门");
            Thread.sleep(500);
            System.out.println(this.name+" 排泄");
            Thread.sleep(500);
            System.out.println(this.name+" 冲水");
            Thread.sleep(500);
            System.out.println(this.name+" 如厕结束");
        }catch (Exception e){
            e.printStackTrace();
        }}
    }
    public void money() {
        synchronized (Programmer.class)//针对整个类，针对多个对象的串行同步
        {
            try {
                System.out.println(this.name + " 被领导表扬");
                Thread.sleep(500);
                System.out.println(this.name + " 拿钱");
                Thread.sleep(500);
                System.out.println(this.name + " 对公司表示感谢");
                Thread.sleep(500);
                System.out.println(this.name + " 开开心心的拿钱走人");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
    }
class Manager{
    private String name;
    public Manager(String name){
        this.name=name;
    }
    public String getName(){
        return this.name;
    }
    public void cheers(String eName){
        try {
                System.out.println(this.name + " 来到"+eName+" 面前");
                Thread.sleep(500);
                System.out.println(eName + " 拿起酒杯");
                Thread.sleep(500);
                System.out.println(this.name +"和 "+eName+" 干杯");
            } catch (Exception e) {
                e.printStackTrace();
            }
    }
}
class CheersThread extends Thread{
    private Manager manager;
    private String name;
    public CheersThread(String name,Manager manager){
        this.name=name;
        this.manager=manager;
    }
    @Override
    public void run() {
        synchronized (this.manager)
        //事实上一个经理对多个员工，如果直接this表示不能对多线程一个经理多员工做串行，需要对manager上锁
        {
            this.manager.cheers(this.name);
        }
    }
}
class Working1 extends Thread{
    private Programmer p;
    public Working1(Programmer p){
        this.p=p;
    }
    @Override
    public void run() {
        this.p.computer();
    }
}
class Working2 extends Thread{
    private Programmer p;
    public Working2(Programmer p){
        this.p=p;
    }
    @Override
    public void run() {
        this.p.coding();
    }
}
class Working3 extends Thread{
    private Programmer p;
    public Working3(Programmer p){
        this.p=p;
    }
    @Override
    public void run() {
        this.p.wc();
    }
}
class GiveMoney extends Thread{
    private Programmer p;
    public GiveMoney(Programmer p){this.p=p;}
    public void run(){
        this.p.money();
    }
}
public class TestSyncThread {
    public static void main(String[] args) {
//        Programmer p=new Programmer("张三");
//        Programmer p2=new Programmer("李四");
        //对程序员对象加线程锁，他的上锁方法一次只有一个能用
//        new Working1(p).start();
//        new Working2(p).start();
//        new Working3(p).start();
//        new Working3(p2).start();
//        new GiveMoney(p).start();
//        new GiveMoney(p2).start();
//        Sale sale=new Sale("wangba");
//        Sale sale1=new Sale("zhangli");
//        Thread thread2=new SaleMoney(sale);
//        Thread thread3=new SaleMoney(sale1);
//        thread2.start();
//        thread3.start();
        Manager manager=new Manager("张三丰");
        new CheersThread("张三",manager).start();
        new CheersThread("李四",manager).start();
    }
}

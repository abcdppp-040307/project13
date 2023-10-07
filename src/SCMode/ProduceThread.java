package SCMode;

import java.util.Scanner;

class ManTou{
    private int id;
    public ManTou(int id){
        this.id=id;
    }
    public int getId() {
        return id;
    }
}
class SyncStack{
    private ManTou[] mt=new ManTou[10];
    private int index;
    public synchronized void push(ManTou manTou){
        while(this.index==this.mt.length){
            try {
                this.wait();//是object的一个方法，在syn中调用，让当前线程由运行转为阻塞状态,其它需要该对象锁的线程可以继续运行
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        //唤醒取馒头
        this.notify();
        this.mt[this.index++]=manTou;
    }
    public synchronized ManTou pop(){
        while(this.index==0){
            try {
                this.wait();//是object的一个方法，在syn中调用，让当前线程由运行转为阻塞状态,其它需要该对象锁的线程可以继续运行,还需要唤醒
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        this.notify();
        return this.mt[--this.index];
    }
}
class ShengChan extends Thread{
    private SyncStack ss;
    public ShengChan(SyncStack ss){
        this.ss=ss;
    }
    @Override
    public void run() {
        for(int i=0;i<10;i++){
            System.out.println("生产馒头:"+i);
            ManTou manTou=new ManTou(i);
            this.ss.push(manTou);
        }
    }
}
class XiaoFei extends Thread{
    private SyncStack ss;
    public XiaoFei(SyncStack ss){
        this.ss=ss;
    }

    @Override
    public void run() {
        for(int i=0;i<10;i++){
            ManTou manTou=this.ss.pop();
            System.out.println("消费馒头:"+i);
        }
    }
}
public class ProduceThread {
    public static void main(String[] args) {
        SyncStack ss=new SyncStack();
        new ShengChan(ss).start();
        new XiaoFei(ss).start();
    }
}

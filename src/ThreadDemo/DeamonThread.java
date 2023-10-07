package ThreadDemo;
class Daemon implements Runnable{

    @Override
    public void run() {
        for(int i=0;i<20;i++){
            System.out.println(Thread.currentThread().getName()+" "+i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
class UsersThread implements Runnable{
    @Override
    public void run() {
        Thread t3=new Thread(new Daemon(),"Deamon-u");
        t3.setDaemon(true);
        t3.start();
        for(int i=0;i<5;i++){
            System.out.println(Thread.currentThread().getName()+" "+i);
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
public class DeamonThread {
    public static void main(String[] args) {
        Thread t=new Thread(new Daemon(),"Daemon-m");
        t.setDaemon(true);//设置守护线程，守护主线程
        Thread t2=new Thread(new UsersThread(),"User");
        t.start();
        t2.start();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("主线程结束");
        //在实际执行中，主线程结束并不会使得Daemon-m守护线程立即结束
        //因为在JVM中，需要所有非守护线程结束后才会认为主线程结束，
        //如果需要检测主线程结束并输出，需要定义显式标志
    }
}

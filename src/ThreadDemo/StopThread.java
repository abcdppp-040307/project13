package ThreadDemo;

import java.io.IOException;

public class StopThread implements Runnable{
    private boolean flag=true;
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName()+"线程开始");
        int i=0;
        while(flag){
            System.out.println(Thread.currentThread().getName()+" "+i++);
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        System.out.println(Thread.currentThread().getName()+"线程结束");
    }
    public void stop(){
        this.flag=false;
    }

    public static void main(String[] args) throws IOException {
        System.out.println("主线程开始");
        StopThread st=new StopThread();
        Thread t1=new Thread(st);
        t1.start();
        System.in.read();
        st.stop();//用原来的stop或者destory函数会直接结束，不输出线程结束
        System.out.println("主线程结束");
    }
}

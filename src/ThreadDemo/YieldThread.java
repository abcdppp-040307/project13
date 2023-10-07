package ThreadDemo;

public class YieldThread implements Runnable{
    @Override
    public void run() {
        for(int i=0;i<30;i++){
            if("Thread-0".equals(Thread.currentThread().getName())){
                if(i==0)
                    Thread.yield();//也有可能让出执行状态失败
            }
            System.out.println(Thread.currentThread().getName()+" "+i);
        }
        System.out.println(Thread.currentThread().getName()+"结束");
    }

    public static void main(String[] args) {
        Thread t1=new Thread(new YieldThread());
        Thread t2=new Thread(new YieldThread());
        t1.start();
        t2.start();
    }
}

package ThreadDemo;

public class PriorityThread{
    public static void main(String[] args) {
        Priority p1=new Priority();
        Priority p2=new Priority();
        Thread t1=new Thread(p1,"线程1");
        Thread t2=new Thread(p2,"线程2");
        t1.setPriority(Thread.MAX_PRIORITY);
        t2.setPriority(Thread.MIN_PRIORITY);
        t1.start();
        t2.start();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        p1.stop();
        p2.stop();//事实上优先级设定不一定有作用
    }
}


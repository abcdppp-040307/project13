package ThreadDemo;
class A implements Runnable{

    @Override
    public void run() {
        for(int i=0;i<10;i++) {
            System.out.println(Thread.currentThread().getName() + " " + i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        } }
}
class B implements Runnable{

    @Override
    public void run() {
        for(int i=0;i<20;i++) {
            System.out.println(Thread.currentThread().getName() + " " + i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        } }
}
public class JoinThread {
    public static void main(String[] args) {
        Thread t=new Thread(new A());
        Thread t1=new Thread(new B());
        t.start();
        t1.start();
        for(int i=0;i<10;i++){
            System.out.println(Thread.currentThread().getName()+" "+i);
            if(i==2){
                try {
                    t.join();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}

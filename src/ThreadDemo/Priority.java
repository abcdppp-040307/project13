package ThreadDemo;

public class Priority implements Runnable {
    private int num = 0;
    private boolean flag = true;

    @Override
    public void run() {
        while (this.flag) {
            System.out.println(Thread.currentThread().getName() + " " + num++);
        }
    }
    public void stop(){
        this.flag=false;
    }
}

package ThreadDemo;

public class TestThread extends Thread{
    public TestThread(){
        System.out.println(this.getName());
    }
    @Override
    public void run() {
        System.out.println(this.getName()+"线程开始");
        for(int i=0;i<20;i++){
            System.out.println(this.getName()+" "+i);
        }
        System.out.println(this.getName()+"线程结束");
    }
    public static void main(String[] args){
        System.out.println("主线程开始");
        TestThread t1=new TestThread();
        //t1.run();//等于在主线程调用，不正确
        t1.start();//启动t1线程
        TestThread t2=new TestThread();
        t2.start();//启动t2线程
        System.out.println("主线程结束");
    }
}

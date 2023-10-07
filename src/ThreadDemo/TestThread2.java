package ThreadDemo;

public class TestThread2 implements Runnable{
    public TestThread2(){
        System.out.println(Thread.currentThread().getName());//输出main
    }
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName()+"线程开始");//getName是Thread的方法
        for(int i=0;i<20;i++)
            System.out.println(Thread.currentThread().getName()+" "+i);
        System.out.println(Thread.currentThread().getName()+"线程结束");
    }

    public static void main(String[] args) {
        System.out.println("主线程开始");
        TestThread2 testThread2=new TestThread2();//这行代码实例化时，运行在主线程中
        Thread t1=new Thread(testThread2);//对运行任务指定即可推进线程
        t1.start();
        Thread t2=new Thread(new TestThread2());
        t2.start();
        System.out.println("主线程结束");
    }
}

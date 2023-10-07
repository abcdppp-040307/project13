package ThreadDemo;

class GetName1 extends Thread{
    @Override
    public void run() {
        System.out.println(this.getName()+"t");
    }
}
class GetName2 implements Runnable{

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName()+"r");
    }
}
public class GetNameThread {
    public static void main(String[] args) {
        GetName1 getName1=new GetName1();
        getName1.start();//方式一直接对类本身start
        Thread t1=new Thread(new GetName2());
        t1.start();//方式二实现接口，需要包装
    }
}

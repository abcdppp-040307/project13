package ThreadDemo;
class SetName1 extends Thread{
    public SetName1(String name){
        super(name);
    }
    public SetName1(){

    }
    @Override
    public void run() {
        System.out.println(this.getName()+" Plan1");
    }
}
class SetName2 implements Runnable{

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName()+" Plan2");
    }
}
public class SetNameThread{
    public static void main(String[] args) {
        SetName1 setName1=new SetName1("SetName1");
        setName1.start();
        SetName1 setName11=new SetName1();
        setName11.setName("SetName11");
        setName11.start();
        Thread setName2=new Thread(new SetName2());
        setName2.setName("setName2");
        setName2.start();
    }
}

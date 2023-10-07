package ThreadDemo;

import javax.security.auth.login.CredentialNotFoundException;

class Lipstick{

}
class Mirror{

}
class Makeup extends Thread{
    private int flag;
    private String girlName;
    static Lipstick lipstick=new Lipstick();
    static Mirror mirror=new Mirror();
    //避免死锁的方法是避免syn嵌套
    public void setFlag(int flag) {
        this.flag = flag;
    }
    public void setGirlName(String girlName) {
        this.girlName = girlName;
    }
    @Override
    public void run() {
        this.doMakeup();
    }
    public void doMakeup(){
        if(flag==0){
            synchronized (lipstick){
                System.out.println(this.girlName+" 拿着口红");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }}
                synchronized (mirror){
                    System.out.println(this.girlName+" 拿着镜子");
                }
        }else{
            synchronized (mirror){
                System.out.println(this.girlName+" 拿着镜子");
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }}
                synchronized (lipstick){
                    System.out.println(this.girlName+" 拿着口红");
                }
        }
    }

}
public class DeadLockThread {
    public static void main(String[] args) {
        Makeup makeup=new Makeup();
        makeup.setFlag(0);
        makeup.setGirlName("大丫");
        Makeup makeup1=new Makeup();
        makeup1.setFlag(1);
        makeup1.setGirlName("小丫");
        makeup.start();
        makeup1.start();
    }
}

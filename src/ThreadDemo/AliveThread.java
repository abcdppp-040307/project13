package ThreadDemo;
class Alive implements Runnable{

    @Override
    public void run() {
        System.out.println(Thread.currentThread().isAlive()+" run打印中");
    }
}
public class AliveThread {
    public static void main(String[] args) {
        Thread thread=new Thread(new Alive());
        System.out.println(thread.isAlive()+" 开始前");//并未启动线程未存活态
        thread.start();
        System.out.println(thread.isAlive()+" 开始后");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println(thread.isAlive()+" 开始后休眠一秒");
    }
}

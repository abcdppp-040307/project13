package ThreadDemo;
class Account{
    private String accountNo;
    private double balance;

    public Account() {
    }

    public Account(String accountNo, double balance) {
        this.accountNo = accountNo;
        this.balance = balance;
    }

    public String getAccountNo() {
        return accountNo;
    }

    public void setAccountNo(String accountNo) {
        this.accountNo = accountNo;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
}
class DrawThread extends Thread {
    private Account account;
    private double drawMoney;

    public DrawThread(String name, Account account, double drawMoney) {
        super(name);//访问父类的属性并设置名称，即设置线程名称
        this.account = account;
        this.drawMoney = drawMoney;
    }

    @Override
    public void run() {
        synchronized (this.account) {
            if (this.account.getBalance() >= this.drawMoney) {
                System.out.println(this.getName() + "取钱成功！吐出：" + this.drawMoney);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                this.account.setBalance(this.account.getBalance() - this.drawMoney);
                System.out.println("余额为：" + this.account.getBalance());
            } else {
                System.out.println(this.getName() + "取钱失败，余额不足");
            }
        }
    }
}
public class DrawMoneyThread {
    public static void main(String[] args) {
        Account account=new Account("1234",1000);
        new DrawThread("laogong",account,800).start();
        new DrawThread("laopo",account,800).start();
    }
}

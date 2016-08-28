package lockandsnchronized;

/**
 * Created by alpha on 16-8-11.
 * 线程同步
 * 线程通信
 */
public class DrawThread extends Thread {
    private Account account;
    private double drawAmount;

    public DrawThread(String name, Account account, double drawAmount) {
        super(name);
        this.account = account;
        this.drawAmount = drawAmount;
    }

    /*@Override
    public void run() {
        synchronized (account) {
            if (account.getBalance() >= drawAmount) {
                System.out.println(getName()+"取钱成功！吐钞："+drawAmount);
                try {
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                account.setBalance(account.getBalance()- drawAmount);
                System.out.println("\t余额："+account.getBalance());
            }else {
                System.out.println(getName()+"取钱失败，余额不足");
            }
        }
    }*/

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            account.draw(drawAmount);
        }
    }
}

package basic;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by alpha on 16-8-11.
 */
public class Account {
    private String accountNo;
    private double balance;
    private boolean flag = false;

    /**
     * 使用Lock和Condition进行同步和加锁
     */

    private final Lock lock = new ReentrantLock();
    private final Condition condition = lock.newCondition();


    public Account(){}

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


    @Override
    public int hashCode() {
        return accountNo.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && obj.getClass() == Account.class) {
            Account target = (Account) obj;
            return target.getAccountNo().equals(accountNo);
        }
        return false;
    }


    //使用synchronized进行同步和加锁
    /*public synchronized void draw(double drawAmount) {
        try {
            if (!flag) {
                wait();
            } else {
                System.out.println(Thread.currentThread().getName()+"取钱："+drawAmount);
                flag = false;
                notifyAll();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public synchronized void deposit(double depositAmount) {
        try {
            if (flag) {
                wait();
            } else {
                System.out.println(Thread.currentThread().getName() + "存款：" + depositAmount);
                balance += depositAmount;
                System.out.println("账户余额："+balance);
                flag = true;
                notifyAll();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }*/


    //使用Lock和Condition进行同步和加锁

    public void draw(double drawAmount) {
        lock.lock();
        try {
            if (!flag) {
                condition.await();
            } else {
                System.out.println(Thread.currentThread().getName()+"取钱："+drawAmount);
                flag = false;
                condition.signalAll();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        finally {
            lock.unlock();
        }
    }

    public void deposit(double depositAmount) {
        lock.lock();
        try {
            if (flag) {
                condition.await();
            } else {
                System.out.println(Thread.currentThread().getName() + "存款：" + depositAmount);
                balance += depositAmount;
                System.out.println("账户余额："+balance);
                flag = true;
                condition.signalAll();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        finally {
            lock.unlock();
        }
    }

}

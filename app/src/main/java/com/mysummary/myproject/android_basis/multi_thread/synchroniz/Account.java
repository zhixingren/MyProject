package com.mysummary.myproject.android_basis.multi_thread.synchroniz;

/**
 * Created by xingzhi on 2018/7/13.
 */

public class Account {

    private String accountNo;
    private double balance ;

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
//---------2---------同步方法
    public synchronized void draw(double drawAmount){


        if (this.getBalance() >= drawAmount) {

            System.out.println("取钱成功！" + drawAmount);


                try {

                    Thread.sleep(1);

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                this.setBalance(this.getBalance() - drawAmount);
                System.out.println("余额为" + this.getBalance());

            } else {
                System.out.println("余额不足！");
            }
    }
//---------2---------

    @Override
    public int hashCode() {
        return accountNo.hashCode();
    }

    @Override
    public boolean equals(Object obj) {

        if (obj != null&&Account.class==obj.getClass()) {
            Account target = (Account)obj;

            return target.getAccountNo().equals(accountNo);
        }

        return false;
    }
}

package ThreadExamples;

class Person1 extends Thread{
    private BankAccount bankAccount;

    Person1(BankAccount bankAccount){
        this.bankAccount = bankAccount;
    }
    @Override
    public void run() {
        bankAccount.deposite(300);
        bankAccount.withdraw(50);
    }
}

class Person2 extends Thread{
    private BankAccount bankAccount;
    Person2(BankAccount bankAccount){
        this.bankAccount = bankAccount;
    }
    @Override
    public void run() {
        bankAccount.deposite(203);
        bankAccount.withdraw(100);
    }
}

class BankAccount {
    private int balance;
    private String accountNumber;

    BankAccount(int balance,String accountNumber){
        this.accountNumber =accountNumber;
        this.balance = balance;
    }

    void deposite(int amount){
        synchronized (this) {
            balance += amount;
            System.out.println("deposite "+balance);
        }
    }

    void withdraw(int amount){
        synchronized (this) {
            balance -= amount;
            System.out.println("withdraw "+balance);
        }
    }

    int getBalance(){
       return balance;
    }

}
public class Concurrency {
    public static void main(String args[]){
        BankAccount bankAccount = new BankAccount(1000,"1234567889");
        Person1 person1 = new Person1(bankAccount);
        Person2 person2 = new Person2(bankAccount);
        person1.start();
        person2.start();

        System.out.println(bankAccount.getBalance());
    }

}

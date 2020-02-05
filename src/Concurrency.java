class Thread1 extends Thread{

    @Override
    public void run() {
        for(int i=1;i<=5;i++){
            //printNumber(i);
        }
    }
}
class Thread2 extends Thread{

    @Override
    public void run() {
        for(int i=5;i<=10;i++){
            //printNumber(i);
        }
    }
}

public class Concurrency {
    public static void main(String []args){
        Thread1 t1 = new Thread1();
        Thread2 t2 = new Thread2();
        t1.start();
        t2.start();
    }
}

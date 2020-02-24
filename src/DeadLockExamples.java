class ThreadOne implements Runnable{
    @Override
    public void run() {
        synchronized (String.class){
            System.out.println(Thread.currentThread().getName() + " - Got lock on String.class");
            synchronized (Integer.class){
                System.out.println(Thread.currentThread().getName() + " - Got lock on Integer.class");
            }
        }
    }
}

class ThreadTwo implements Runnable{

    @Override
    public void run() {
        synchronized (Integer.class){
            System.out.println(Thread.currentThread().getName() + " - Got lock on Integer.class");
            synchronized (String.class){
                System.out.println(Thread.currentThread().getName() + " - Got lock on String.class");
            }
        }
    }
}
public class DeadLockExamples {

    public static void main(String args[]){
        new Thread(new ThreadOne(),"ThreadOne").start();
        new Thread(new ThreadTwo(),"ThreadTwo").start();
    }
}

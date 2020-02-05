package ThreadExamples;

class Thread11 implements Runnable{


    /* * This method request two locks, first Integer and then String */

    @Override
    public void run() {
        synchronized (Integer.class){
            System.out.println("Aquired lock on Integer.class object");
            synchronized (String.class){
                System.out.println("Aquired lock on String.class object");
            }
        }

    }
}

class Thread12 implements Runnable{

    /* * This method also requests same two lock but in exactly * Opposite order i.e. first String and then Integer.
    * * This creates potential deadlock, if one thread holds String lock * and other holds Integer lock and they wait for each other,
    *  forever. */

    @Override
    public void run() {
        synchronized (String.class){
            System.out.println("Aquired lock on Integer.class object");
            synchronized (Integer.class){
                System.out.println("Aquired lock on String.class object");
            }
        }
    }
}
public class DeadLockFixed {
    public static void main(String args[]) {
        new Thread(new Thread11(), "thread-1").start();
        new Thread(new Thread12(), "thread-2").start();
    }
}

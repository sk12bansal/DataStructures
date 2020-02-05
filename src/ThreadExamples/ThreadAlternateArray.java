package ThreadExamples;

import java.util.Arrays;
import java.util.List;

class ThreadAlternateArray {
    static class PrintAlternate {
        List<Integer> list = Arrays.asList(1,2,3,4,5,6,7,8,9,10);
        int i=0;
        public void printodd() throws InterruptedException {

            while(i < list.size()){
                synchronized (this){
                    System.out.println(Thread.currentThread().getName() + " " +list.get(i));
                    i++;
                    notify();
                    wait();
                    Thread.sleep(1000);

                }
            }
        }

        public void printeven() throws InterruptedException {

            while(i < list.size()){
                synchronized (this){
                    System.out.println(Thread.currentThread().getName() + " " +list.get(i));
                    i++;
                    notify();
                    wait();
                    Thread.sleep(1000);

                }
            }
        }
    }

    public static void main(String args[]) throws InterruptedException {

        final PrintAlternate printAlternate = new PrintAlternate();

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    printAlternate.printodd();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    printAlternate.printeven();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        t1.start();
        t2.start();

        t1.join();
        t2.join();

    }
}

package ThreadExamples;

class OddThread extends Thread {
    private int limit;
    private SharedPrinter printer;

    public OddThread(int limit, SharedPrinter printer) {
        this.limit = limit;
        this.printer = printer;
    }

    public void run() {
        int oddNumber = 1;

        while (oddNumber <= limit) {
            printer.printOdd(oddNumber);

            oddNumber = oddNumber + 2;
        }
    }
}

class EvenThread extends Thread {
    private int limit;
    private SharedPrinter printer;

    public EvenThread(int limit, SharedPrinter printer) {
        this.limit = limit;
        this.printer = printer;
    }

    public void run() {
        int evenNumber = 2;

        while (evenNumber <= limit) {
            printer.printEven(evenNumber);
            evenNumber = evenNumber + 2;
        }
    }
}

class SharedPrinter {
    boolean isOddPrinted = false;

    synchronized void printOdd(int number) {
        //System.out.println("odd-thread"+isOddPrinted);
        while (isOddPrinted) {

            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(Thread.currentThread().getName() + " : " + number);

        isOddPrinted = true;

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        notify();
    }


    synchronized void printEven(int number) {
        //System.out.println("even-thread"+isOddPrinted);
        while (!isOddPrinted) {

           // System.out.println("wait thread2"+!isOddPrinted);
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(Thread.currentThread().getName() + " : " + number);

        isOddPrinted = false;

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        notify();
    }

}

public class PrintOddEven {
    public static void main(String args[]) {
        SharedPrinter printer = new SharedPrinter();
        OddThread thread1 = new OddThread(10, printer);
        thread1.setName("Odd-Thread");
        EvenThread thread2 = new EvenThread(10, printer);
        thread2.setName("Even-Thread");
        thread1.start();
        thread2.start();
    }
}

package ThreadExamples;


class T1 extends Thread {
    private Printer printer;
    T1(Printer printer){
        this.printer = printer;
    }
    public void run(){
        for(int i=1;i<=10;i++){
            printer.printFirstSeg(i);
        }
    }
}

class T2 extends Thread {
    private Printer printer;
    T2(Printer printer){
        this.printer = printer;
    }
    public void run(){
        for(int i=11;i<=20;i++){
            printer.printSecondSeg(i);
        }
    }
}

class T3 extends Thread {
    private Printer printer;
    T3(Printer printer){
        this.printer = printer;
    }
    public void run(){
        for(int i=21;i<=30;i++){
            printer.printThirdSeg(i);
        }
    }
}

class T4 extends Thread {
    private Printer printer;
    T4(Printer printer){
        this.printer = printer;
    }
    public void run(){
        for(int i=31;i<=40;i++){
            printer.printFourthSeg(i);
        }
    }
}

class Printer {
    private boolean isOddPrinted = false;
    private boolean isEvenPrinted = false;

    synchronized void printFirstSeg(int number){
        while(isOddPrinted){

            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("1st:"+number);
        isOddPrinted = true;
        notifyAll();
    }

    synchronized void printSecondSeg(int number){
        while(isEvenPrinted){

            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("2nd:"+number);
        isEvenPrinted = true;
        notifyAll();
    }


    synchronized void printThirdSeg(int number){
        while(!isOddPrinted){

            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("3rd:"+number);
        isOddPrinted = false;
        notifyAll();
    }

    synchronized void printFourthSeg(int number){
        while(!isEvenPrinted){

            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("4th:"+number);
        isEvenPrinted = false;
        notifyAll();
    }

}

public class ThreadProgram {
    public static void main(String args[]){
        Printer printer = new Printer();
        T1 t1 = new T1(printer);
        T2 t2 = new T2(printer);
        T3 t3 = new T3(printer);
        T4 t4 = new T4(printer);
        //System.out.println("suraj"+java.time.LocalTime.now());
        t1.start();
        t2.start();
        t3.start();
        t4.start();


    }
}

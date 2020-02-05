package ThreadExamples;

class Simple1 implements Runnable {
    private String str;

    Simple1(String str){
        this.str = str;
    }

    public void run(){
        System.out.println("String length "+str.length());
    }
}

class Simple2 implements Runnable {

    private String str;
    Simple2(String str){
        this.str = str;
    }

    public void run(){
        System.out.println("String uppercase  "+str.toUpperCase());
    }
}

class MultiTasking {
    public static void main(String args[]){
        Simple1 s1 = new Simple1("suraj");
        Simple2 s2 = new Simple2("suRaj");
        Thread t1 = new Thread(s1);
        Thread t2 = new Thread(s2);

        t1.start();
        t2.start();
    }
}

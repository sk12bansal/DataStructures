package ThreadExamples;

class Thread1 extends Thread{
    public void run(){
        for(int i=1;i<=5;i++){
            try{
                Thread.sleep(500);
            }catch (Exception e){

            }
            System.out.println(Thread.currentThread().getName()+" "+i);
        }
    }
}
class Thread2 extends Thread{
    public void run(){
        for(int i=1;i<=5;i++){
            try{
                Thread.sleep(500);
            }catch (Exception e){

            }
            System.out.println(Thread.currentThread().getName()+" "+i);
        }
    }
}
public class MultiTasking1 {
    public  static void main(String args[]){
        Thread1 t1 = new Thread1();
        Thread2 t2 = new Thread2();
        //t1.setPriority(Thread.MAX_PRIORITY);
        t1.start();
        t2.start();
    }
}

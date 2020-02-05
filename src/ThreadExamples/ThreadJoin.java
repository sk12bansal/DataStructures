package ThreadExamples;

class ThreadJoin extends Thread {

    public void run(){
        for(int i=1;i<=5;i++){
            try {
                Thread.sleep(500);
            } catch (InterruptedException e){
                e.printStackTrace();

            }
            System.out.println(i);
        }
    }

    public static void main(String args[]){
        ThreadJoin t1 = new ThreadJoin();
        ThreadJoin t2 = new ThreadJoin();
        ThreadJoin t3 = new ThreadJoin();
        t1.start();

        try {
            t1.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Name of t1:"+t1.getName());
        System.out.println("id of t1: "+t1.getId());
        t2.start();
        t3.start();
    }

}

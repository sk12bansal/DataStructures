package dp;

public class PowerSet {
    public static void main(String args[]){
        for(int counter =0;counter<8;counter++){
            for(int j =0;j<3;j++){
                System.out.print((counter & 1<<j));
            }
            System.out.println();
        }
    }
}

package impQuestions;

public class FindTwoMissingNumbers {
    public static void main(String []args){
        int [] arr = {1, 3, 5, 6};
        int n =arr.length +2;
        int XOR = arr[0];
        for(int i=1;i<n-2;i++)
            XOR = XOR^arr[i];
        System.out.println(XOR);
        for(int i=1;i<=n;i++)
            XOR = XOR^i;
       // System.out.println(XOR);
        System.out.println(XOR & ~(XOR-1));

    }
}

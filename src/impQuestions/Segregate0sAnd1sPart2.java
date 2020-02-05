package impQuestions;

import java.util.Scanner;

public class Segregate0sAnd1sPart2 {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t > 0) {
            int n= sc.nextInt();
            int [] arr = new  int [n];
            for(int  i=0;i<n;i++){
                arr[i] = sc.nextInt();
            }
            int start  = 0;
            int end = n-1;

            while(start<end){
                if(arr[start] == 1 && arr[end]==0){
                    int temp = arr[start];
                    arr[start] = arr[end];
                    arr[end] = temp;
                    start++;
                    end--;
                }else if(arr[start] ==0){
                    start++;
                }else if(arr[end]==1){
                    end--;
                }
            }
            for(int i=0;i<n;i++){
                System.out.print(arr[i] + " ");
            }
            System.out.println();
            t-=1;
        }
    }
}

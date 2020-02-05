package impQuestions;

import java.util.Scanner;

public class SmallestAndSecondSmallest {
    public static void main(String []args){
        Scanner sc =new Scanner(System.in);
        int t= sc.nextInt();
        while (t>0){
            int n= sc.nextInt();
            int [] arr = new int[n];
            for(int i=0;i<n;i++){
                arr[i] = sc.nextInt();
            }
            int min = Integer.MAX_VALUE;
            int smin = Integer.MAX_VALUE;
            for(int i=0;i<n;i++){
                if(arr[i]<min){
                    smin = min;
                    min = arr[i];
                } else if(arr[i]<smin && arr[i]!=min){
                    smin = arr[i];
                }
            }
            if(smin == Integer.MAX_VALUE){
                System.out.println("-1");
            }else {
                System.out.println(min + " " + smin);
            }
            t-=1;
        }
    }
}

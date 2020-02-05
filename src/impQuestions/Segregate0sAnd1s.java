package impQuestions;

import java.util.Scanner;

public class Segregate0sAnd1s {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t>0){
            int n= sc.nextInt();
            int [] arr = new  int [n];
            int [] hash = new int[2];
            for(int  i=0;i<n;i++){
                arr[i] = sc.nextInt();
                hash[arr[i]]++;
            }
            /*for(int i=0;i<n;i++){
                hash[arr[i]]++;
            }*/
            int i=0;
            while(i<2){
                while(hash[i]>0){
                    System.out.print(i + " ");
                    hash[i]--;
                }
                i++;
            }
            t-=1;
        }
    }
}
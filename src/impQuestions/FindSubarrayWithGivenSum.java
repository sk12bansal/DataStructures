package impQuestions;

import java.util.Scanner;

public class FindSubarrayWithGivenSum {

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t>0){
            int n=sc.nextInt();
            int sum = sc.nextInt();
            int [] arr= new int[n];
            for(int i=0;i<n;i++){
                arr[i] = sc.nextInt();
            }
            int start =0;
            int end =-1;
            int curr_sum =0;
            for(int i=0;i<=n;i++){
                 while(curr_sum>sum && start<i-1){
                     curr_sum = curr_sum -arr[start];
                     start++;
                 }
                 if(curr_sum == sum){
                     end =i-1;
                     System.out.println(start+1 + " " + (end+1));
                     break;
                 }
                 if(i<n)
                 curr_sum = curr_sum +arr[i];
            }
            if(end==-1){
                System.out.println("-1");
            }
            t-=1;
        }
    }
}

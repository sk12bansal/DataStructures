package impQuestions;

import java.util.Scanner;

public class CountOfSumOfConsecutives {
    public static void main(String []args){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t>0){
            int N = sc.nextInt();
            int ans =0;
            for(int n=2;(n*(n+1)/2)<=N;n++){
                int tmp=(N-(n*(n+1)/2))%n;
                if(tmp==0){
                    ans++;
                }
            }
            System.out.println(ans+1);
            t-=1;
        }
    }
}

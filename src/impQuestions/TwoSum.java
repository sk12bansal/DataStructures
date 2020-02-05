package impQuestions;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class TwoSum {
    public static void main (String[] args) {
        //code
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t>0){
            int n= sc.nextInt();
            int k = sc.nextInt();
            int [] arr = new int[n];
            for(int i=0;i<n;i++){
                arr[i]= sc.nextInt();
            }
            int c=0;
            Map<Integer,Integer> hash = new HashMap<>();
            for(int i=0;i<n;i++){
                if(hash.containsKey(k-arr[i])){
                    c++;
                }else{
                    hash.put(arr[i],i);
                }
            }
            System.out.println(c);
            t-=1;
        }
    }
}

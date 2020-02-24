package impQuestions;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

public class EqualToProduct {
    public static void main(String []args){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t>0){
            int n = sc.nextInt();
            int p = sc.nextInt();
            int []arr = new int[n];
            for(int i=0;i<n;i++){
                arr[i] = sc.nextInt();
            }
            Arrays.sort(arr);
            int left = 0;
            int right = arr.length-1;
            boolean flag = false;
            while(left<right){
                int product = arr[left] *arr[right];
                if(product==p){
                    flag=true;
                    System.out.println("Yes");
                    break;
                }else if(product>p){
                    right--;
                }else{
                    left++;
                }
            }
            if(!flag){
                System.out.println("No");
            }
            t-=1;
        }
    }
}

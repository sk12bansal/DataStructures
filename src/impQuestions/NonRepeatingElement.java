package impQuestions;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class NonRepeatingElement {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t > 0) {
            int n = sc.nextInt();
            int [] arr = new int[n];
            for(int i=0;i<n;i++){
                arr[i]= sc.nextInt();
            }
            boolean flag = false;
            Map<Integer,Integer> m = new HashMap<>();
            for(int i=0;i<n;i++){
                if(m.containsKey(arr[i])){
                    m.put(arr[i],m.get(arr[i])+1);
                }else{
                    m.put(arr[i],1);
                }
            }
            for(int i=0;i<n;i++){
                if(m.containsKey(arr[i]) && m.get(arr[i])==1){
                    flag = true;
                    System.out.println(arr[i]);
                    break;
                }
            }
            if(!flag)
                System.out.println("0");
            t-=1;
        }
    }
}

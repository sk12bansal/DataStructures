package impQuestions;

import java.util.Scanner;

public class NumbersContaining12And3 {

    private static boolean validStr(String str) {
        for(int i=0;i<str.length();i++){
            int c = str.charAt(i)-'0';
            if(c==0 || c>=4){
                return false;
            }
        }
        return  true;
    }

    public static void main(String [] args){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t>0){
            int n = sc.nextInt();
            int [] numbers = new int[n];
            for(int i=0;i<n;i++){
                numbers[i] = sc.nextInt();
            }
            boolean flag = false;
            for(int i=0;i<n;i++){
                String str = Integer.toString(numbers[i]);
                if(validStr(str)){
                    flag =true;
                    System.out.println(numbers[i]);
                }
            }
            if(!flag){
                System.out.println("-1");
            }
            t-=1;
        }
    }
}

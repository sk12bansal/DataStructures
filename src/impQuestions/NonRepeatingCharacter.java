package impQuestions;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

public class NonRepeatingCharacter {
    public static void main (String[] args) {
        //code
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t>0){
            int n = sc.nextInt();
            sc.nextLine();
            String str = sc.nextLine();
            int []hash= new int[26];
            boolean flag =false;
            for(int i=0;i<str.length();i++){
                hash[str.charAt(i)-'a']++;
            }
            for(int i=0;i<str.length();i++){
                if(hash[str.charAt(i)-'a']==1){
                    flag = true;
                    System.out.println(str.charAt(i));
                    break;
                }
            }
            if(!flag)
                System.out.println("-1");
            t-=1;
        }
    }
}

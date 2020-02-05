package impQuestions;

import java.util.Scanner;

public class MergeTwoStrings {
    public static void main(String []args){
        Scanner sc = new Scanner(System.in);
        int t=sc.nextInt();
        sc.nextLine();
        while(t>0){
            String s1 = sc.nextLine();
            String s2 = sc.nextLine();
            StringBuilder res = new StringBuilder();
            int i=0;
            int j=0;
            while(i<s1.length() && j<s2.length()){
                res.append(s1.charAt(i++)).append(s2.charAt(j++));
            }
            while(i<s1.length()){
                res.append(s1.charAt(i++));
            }
            while(j<s2.length()){
                res.append(s2.charAt(j++));
            }
            System.out.println(res);
            t-=1;
        }
    }
}

package impQuestions;

import java.util.Scanner;

public class RepeatedCharacter {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine();
        while(t>0){
            String str = sc.nextLine();
            int []hash= new int[26];
            boolean flag =false;
            for(int i=0;i<str.length();i++){
                hash[str.charAt(i)-'a']++;
            }
            for(int i=0;i<str.length();i++){
                if(hash[str.charAt(i)-'a']>=2){
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

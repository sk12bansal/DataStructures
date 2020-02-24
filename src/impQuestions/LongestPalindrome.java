package impQuestions;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class LongestPalindrome {
    public static int longestPalindrome(String s) {
        if(s.isEmpty()){
            return 0;
        }
        Set<Character> hs = new HashSet<>();
        int count =0;
        for(char c : s.toCharArray()){
            if(hs.contains(c)){
                hs.remove(c);
                count++;
            }else{
                hs.add(c);
            }
        }
        return !hs.isEmpty() ? count *2+1: count*2;

    }
    public static void main(String []args){
        String s = "abccccdd";
        System.out.println(longestPalindrome(s));
    }
}

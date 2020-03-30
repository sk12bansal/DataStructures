package impQuestions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindAllAnagramsInAString {
    public static List<Integer> findAnagrams(String s, String p) {
        int []hash = new int[26];
        for(int i=0;i<p.length();i++){
            hash[p.charAt(i)-'a']++;
        }
        List<Integer> res= new ArrayList<>();
        for(int i=0;i<s.length();i = i+p.length()){
            if((s.length()-i)>p.length()){
                // System.out.println((s.length()-i) + " " + p.length() );
                String tmp = s.substring(i,i+p.length());
                // System.out.println(tmp);
                int [] patHash = new int[26];
                for(int j=0;j<tmp.length();j++){
                    patHash[tmp.charAt(j)-'a']++;
                }
                if(Arrays.toString(patHash).equals(Arrays.toString(hash))){
                    res.add(i);
                }
            }
        }
        return res;
    }
    public static void main(String []args){
        System.out.println(findAnagrams("cbaebabacd","abc"));
    }
}

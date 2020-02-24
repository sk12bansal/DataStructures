package impQuestions;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithoutRepeatingCharacters {
    public static int lengthOfLongestSubstring(String s) {
        if(s.isEmpty()){
            return 0;
        }
        int max=0;
        Map<Character,Integer> mp = new HashMap<>();
        for(int i=0,j=0;i<s.length();i++){
            if(mp.containsKey(s.charAt(i))){
                j=Math.max(j,mp.get(s.charAt(i))+1);
            }
            mp.put(s.charAt(i),i);
            max= Math.max(max,i-j+1);
        }
        return max;
    }
    public static void main(String []args){
        System.out.println(lengthOfLongestSubstring("abcdabcd"));
    }
}

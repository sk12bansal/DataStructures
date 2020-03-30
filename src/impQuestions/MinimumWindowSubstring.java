package impQuestions;

import java.util.HashMap;
import java.util.Map;

public class MinimumWindowSubstring {
    public static String minWindow(String s, String t) {
        String res="";
        Map<Character,Integer> map = new HashMap<>();
        for(char c:t.toCharArray()){
            map.put(c,map.getOrDefault(c,0)+1);
        }
        int begin =0;
        int end =0;
        int len = Integer.MAX_VALUE;
        int counter = map.size();
        while(end<s.length()){
            char tempc = s.charAt(end);
            if(map.containsKey(tempc)){
                map.put(tempc,map.get(tempc)-1);
                if(map.get(tempc)==0){
                    counter--;
                }
            }
            end++;
            while(counter==0){
                tempc = s.charAt(begin);
                if(map.containsKey(tempc)){
                    map.put(tempc,map.get(tempc)+1);
                    if(map.get(tempc)>0){
                        counter++;
                    }
                }
                if((end-begin)<len){
                    len = end-begin;
                    res = s.substring(begin,begin+len);
                }
                begin++;
            }
        }
        return res;
    }
    public static void main(String []args){
        System.out.println(minWindow("ADOBECODEBANC","ABC"));
    }
}

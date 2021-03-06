package impQuestions;

import java.util.*;

public class FindAllAnagramsInAStringII {
    public static List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new LinkedList<>();
        if(p.length() > s.length()){
            return result;
        }
        Map<Character,Integer> map = new HashMap<>();
        for(char c: p.toCharArray()){
            map.put(c,map.getOrDefault(c,0)+1);
        }
        System.out.println(map.size());

        int begin = 0, end = 0;
        int head = 0;
        int len = Integer.MAX_VALUE;
        int counter = map.size();

        while(end < s.length()){
            char c = s.charAt(end);
            if( map.containsKey(c) ){
                map.put(c, map.get(c)-1);
                if(map.get(c) == 0) counter--;
            }
            end++;

            while(counter == 0){
                char tempc = s.charAt(begin);
                if(map.containsKey(tempc)){
                    map.put(tempc, map.get(tempc) + 1);
                    if(map.get(tempc) > 0){
                        counter++;
                    }
                }
                if(end-begin == p.length()){
                    result.add(begin);
                }
                begin++;
            }

        }

        return result;
    }
    public static void main(String []args){
        System.out.println(findAnagrams("cbaebabacd","abc"));
    }
}

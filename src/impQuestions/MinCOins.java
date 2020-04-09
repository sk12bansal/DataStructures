package impQuestions;

import java.util.HashMap;
import java.util.Map;

public class MinCOins {
    public static  void main(String []args){
        String s = "dabbcabcd";

        Map<Character,Integer> map = new HashMap<>();
        int end=0;
        int begin =0;
        int ans =0;
        int counter = 0;
        while(end<s.length()){
            char tempc = s.charAt(end);
            map.put(tempc,map.getOrDefault(tempc,0)+1);
            if(map.get(tempc)>1){
                counter++;
            }
            end++;
            while(counter>0){
                tempc = s.charAt(begin);
                if(map.get(tempc)>1){
                    counter--;
                }
                map.put(tempc,map.get(tempc)-1);
                begin++;
            }
            ans = Math.max(ans,end-begin);
        }
        System.out.println(ans);

        /*String res= "";
        Map<Character,Integer> mp = new HashMap<>();

        for(char c : str.toCharArray()){
            mp.put(c,mp.getOrDefault(c,0)+1);
        }

        int begin =0;
        int end =0;
        int len = Integer.MAX_VALUE;
        int counter = mp.size();
       // System.out.println(counter)
        char isPrevChar;
        while(end<str.length()){
            char tempc = str.charAt(end);
            isPrevChar = tempc;
            if(mp.containsKey(tempc)){
                mp.put(tempc,mp.get(tempc)-1);
                if(mp.get(tempc)==0){
                    counter--;
                }
            }
            end++;
            while(counter==0){
                tempc = str.charAt(begin);
                if(mp.containsKey(tempc)){
                    mp.put(tempc,mp.get(tempc)+1);
                    if(mp.get(tempc)>0){
                        counter++;
                    }
                }
                if((end-begin)<len){
                    len = end-begin;
                    res = str.substring(begin,begin+len);
                }
                begin++;
            }
            //System.out.println(res);*/
       // }
    }
}

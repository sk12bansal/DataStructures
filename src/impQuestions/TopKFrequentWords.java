package impQuestions;

import java.util.*;

public class TopKFrequentWords {
    public static void main(String []args){
       String [] words = {"i", "love", "leetcode", "i", "love", "coding"};
       int k=1;
        Map<String,Integer> mp = new HashMap<>();
        int max=0;
        for(String w :words){
            mp.put(w,mp.getOrDefault(w,0)+1);
            max = Math.max(max,mp.get(w));
        }
        List<String> [] bucket = new List[max+1];
        for(String key :mp.keySet()){
            int count = mp.get(key);
            if(bucket[count]==null){
                bucket[count] = new ArrayList<>();
            }
            bucket[count].add(key);
        }
        List<String> res = new ArrayList<>();
        for(int pos=max;pos>=0 && res.size()<k;pos--){
            if(bucket[pos]!=null){
                Collections.sort(bucket[pos]);
                res.addAll(bucket[pos]);
            }
        }
        for(String w:res.subList(0,k)){
            System.out.println(w);
        }
    }
}

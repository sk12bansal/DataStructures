package impQuestions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SortCharactersByFrequency {
    public static void main(String []args){
        String str = "tree";
        Map<Character,Integer> hash = new HashMap<>();
        for(char c:str.toCharArray()){
            hash.put(c,hash.getOrDefault(c,0)+1);
        }
        List<Character> [] bucket = new List[str.length()+1];
        for(char c:hash.keySet()){
            int count = hash.get(c);
            if(bucket[count]==null){
                bucket[count] = new ArrayList<>();
            }
            bucket[count].add(c);
        }
        StringBuilder sb =new StringBuilder();
        for(int pos=bucket.length-1;pos>=0;pos--){
            if(bucket[pos]!=null){
                for(char c:bucket[pos]){
                    for(int i=0;i<hash.get(c);i++){
                        sb.append(c);
                    }
                }
            }
        }
        System.out.println(sb);
    }
}

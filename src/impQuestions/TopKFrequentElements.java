package impQuestions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TopKFrequentElements {
    public static void main(String []args){
        int [] nums = {1,1,1,2,2,3};
        int k=2;
        Map<Integer,Integer> mp = new HashMap<>();
        for(int i:nums){
            mp.put(i,mp.getOrDefault(i,0)+1);
        }
        List<Integer> [] bucket = new List[nums.length+1];
        for(int ele:mp.keySet()){
            int count = mp.get(ele);
            if(bucket[count]==null){
                bucket[count] = new ArrayList<>();
            }
            bucket[count].add(ele);
        }
        List<Integer> res= new ArrayList<>();
        int count=0;
        for(int pos =bucket.length-1;pos>=0;pos--){
            if(bucket[pos]!=null){
                for(int ele:bucket[pos]){
                    count++;
                    if(count<=k) {
                        res.add(ele);
                    }else{
                        break;
                    }
                }
            }
        }
        for(int ele:res){
            System.out.println(ele + " ");
        }
    }
}

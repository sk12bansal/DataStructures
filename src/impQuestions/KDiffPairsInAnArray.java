package impQuestions;

import java.util.HashMap;
import java.util.Map;

public class KDiffPairsInAnArray {
    public static int findPairs(int[] nums, int k) {
        if(nums==null || nums.length==0){
            return 0;
        }
        int c=0;
        Map<Integer,Integer> mp = new HashMap<>();
        for(int i=0;i<nums.length;i++)
            mp.put(nums[i],mp.getOrDefault(nums[i],0)+1);
        for(Map.Entry<Integer,Integer> entry :mp.entrySet()){
            if(k==0){
                if(entry.getValue()>=2){
                    c++;
                }
            }else{
                if(mp.containsKey(entry.getKey()+k)){
                    c++;
                }
            }
        }
        return c;
    }
    public static void main(String []args){
        int []nums = {3, 1, 4, 1, 5};
        int k=0;
        System.out.println(findPairs(nums,k));
    }
}

package impQuestions;

import java.util.HashMap;
import java.util.Map;

public class DegreeOfAnArray {
    public static int findShortestSubArray(int[] nums) {
        Map<Integer,Integer> freqMap = new HashMap<>();
        Map<Integer,Integer> indexMap = new HashMap<>();
        int res=0,degree=0;
        for(int i=0;i<nums.length;i++){
            indexMap.putIfAbsent(nums[i],i);
            freqMap.put(nums[i],freqMap.getOrDefault(nums[i],0)+1);
            if(freqMap.get(nums[i])>degree){
                degree = freqMap.get(nums[i]);
                res = i-indexMap.get(nums[i])+1;
            }else if(freqMap.get(nums[i])==degree){
                res = Math.min(res,i-indexMap.get(nums[i])+1);
            }
        }
        return res;
    }
    public static void main(String []args){
        System.out.println(findShortestSubArray(new int[]{1, 2, 2, 3, 1}));
        System.out.println(findShortestSubArray(new int[]{1,2,2,3,1,4,2}));
    }
}

package impQuestions;

import java.util.HashMap;
import java.util.Map;

public class SubarraySumEqualsK {
    public static int subarraySum(int[] nums, int k) {
        if(nums.length ==0){
            return 0;
        }
        int curr_sum =0;
        int res=0;
        Map<Integer,Integer> mp = new HashMap<>();
        mp.put(0,1);
        for (int num : nums) {
            curr_sum = curr_sum + num;
            if (mp.containsKey(curr_sum - k)) {
                res += mp.get(curr_sum - k);
            }
            mp.put(curr_sum, mp.getOrDefault(curr_sum, 0) + 1);

        }
        return res;
    }
    public static void main(String [] args){
        int[]nums = {1,1,1};
        int k =2;
        System.out.println(subarraySum(nums,k));
    }
}

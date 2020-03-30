package impQuestions;

import java.util.HashMap;
import java.util.Map;

public class LongestConsecutiveSequence {
    public static void main(String []args){
        int []nums = {100,4,200,1,3,2};

        int res=0;
        Map<Integer,Integer> mp = new HashMap<>();
        for(int n : nums){
            if(!mp.containsKey(n)){
                int left = mp.getOrDefault(n - 1, 0);
                int right = mp.getOrDefault(n + 1, 0);
                int sum = left+right+1;
                mp.put(n,sum);
                res = Math.max(res,sum);
                mp.put(n-left,sum);
                mp.put(n+right,sum);
            }else{
                continue;
            }
        }
        System.out.println(mp);
    }
}

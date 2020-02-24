package impQuestions;

import java.util.PriorityQueue;
import java.util.Queue;

public class MinimumCostToConnectSticks {
    public static void main(String []args){
        int[] nums = {8,4,6,12};
        Queue<Integer> minheap = new PriorityQueue<>();
        for(int i=0;i<nums.length;i++){
            minheap.add(nums[i]);
        }
        int res=0;
        while(minheap.size()>1){
            int min = minheap.poll();
            int smin = minheap.poll();
            res +=(min+smin);
            minheap.add(min+smin);
        }
        System.out.println(res);
    }
}

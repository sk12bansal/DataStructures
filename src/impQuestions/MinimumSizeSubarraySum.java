package impQuestions;

public class MinimumSizeSubarraySum {
    public static int minSubArrayLen(int s, int[] nums) {
        if(nums.length==0){
            return 0;
        }
        int start =0;int j=0;
        int min = Integer.MAX_VALUE;
        int sum=0;
        int i=0;
        int n = nums.length;
        while(j<n){
            sum+=nums[j++];

            while(sum>=s){
                min = Math.min(min,j-i);
                sum-=nums[i++];
            }
        }
        return min==Integer.MAX_VALUE?0:min;
    }
    public static void main(String []args){
        int []nums = {2,3,1,2,4,3};
        int sum = 7;
        System.out.println(minSubArrayLen(sum,nums));
    }
}

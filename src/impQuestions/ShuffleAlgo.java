package impQuestions;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class ShuffleAlgo {
    private static void swap(int []nums , int first,int second){
        int temp = nums[first];
        nums[first] = nums[second];
        nums[second] = temp;
    }
    private static void shuffle(int[] nums) {
        int len=nums.length;
        Random ran = new Random(0);
        for(int i=1;i<len;i++){
            int ranInt = ThreadLocalRandom.current().nextInt(i,len);
            ran.nextInt(2);
            swap(nums,i-1,ranInt);
        }
    }

    public static void main(String []args){
        int [] nums = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20};
        shuffle(nums);
        for(int i=0;i<nums.length;i++)
        System.out.print(nums[i] + " ");
    }
}

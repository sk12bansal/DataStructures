package impQuestions;

import java.util.Arrays;

public class RotateArray {
    static void reverse(int[]nums ,int start,int end){
        while(start<end){
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }
    public static void main(String []args){
        int []nums= {1,2,3,4,5};
        int k=3;
        reverse(nums,0,nums.length-1);
        reverse(nums,0,k-1);
        reverse(nums,k,nums.length-1);
        Arrays.stream(nums).forEach(System.out::println);
    }
}

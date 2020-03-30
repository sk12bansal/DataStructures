package impQuestions;

import java.util.Random;

public class KthLargestElement {
    public static int findKthLargest(int[] nums, int low,int high) {
        /*int n=nums.length;
        int left=0;
        int right=n-1;
        Random rand = new Random(0);
        while (left<=right){
            int choosenPivotIndex = rand.nextInt(right-left+1)+left;
            int finalIndexOfChoosenPivot = partition(nums, left, right, choosenPivotIndex);
            if(finalIndexOfChoosenPivot == n-k){
                return nums[finalIndexOfChoosenPivot];
            }else if(finalIndexOfChoosenPivot>n-k){
                right = finalIndexOfChoosenPivot-1;
            }else{
                left = finalIndexOfChoosenPivot+1;
            }
        }*/
        if(low<=high){
            int pi = partition(nums,low,high-1,high);
            findKthLargest(nums,low,pi-1);
            findKthLargest(nums,pi+1,high);
        }
        return -1;
    }

    private static int partition(int[] nums, int left, int right, int choosenPivotIndex) {
        int pivotValue = nums[choosenPivotIndex];
        swap(nums,choosenPivotIndex,right);
        int lessItemIndex = left;
        for(int i=left;i<right;i++){
            if(nums[left]<pivotValue){
                swap(nums,i,lessItemIndex);
                lessItemIndex++;
            }
        }
        swap(nums, right, lessItemIndex);
        return lessItemIndex;
    }

    public static void swap(int []nums,int pivot,int right){
        int temp = nums[pivot];
        nums[pivot] = nums[right];
        nums[right] = temp;
    }

    public static void main(String []args){
        int []nums = {3,2,1,5,6,4};
        int k=2;
        //System.out.println(findKthLargest(nums,k)+1);
        findKthLargest(nums,0,nums.length-1);
        for(int i:nums){
            System.out.print(i + " ");
        }
    }
}

package impQuestions;


public class QuickSort {
    public static void main(String [] args){
        //int []nums = {5,7,3,4,2};
        int []nums = {5,4,3,2,1};
        quickSort(nums,0,nums.length-1);
        for(int ele:nums){
            System.out.print(ele + " ");
        }
    }

    private static void quickSort(int[] nums, int low, int high) {
        if(low<high){
            int pi = partition(nums,low,high);
            quickSort(nums,low,pi-1);
            quickSort(nums,pi+1,high);
        }
    }

    private static int partition(int[] nums, int low, int high) {
        int pivot = nums[high];
        int lessItemIndex = low-1;
        for(int i=low;i<high;i++){
            if(nums[i]<pivot){
                lessItemIndex++;
                swap(nums,i,lessItemIndex);
            }
        }
        swap(nums,high,lessItemIndex+1);
        return lessItemIndex+1;
    }
    public static void swap(int []nums,int pivot,int right){
        int temp = nums[pivot];
        nums[pivot] = nums[right];
        nums[right] = temp;
    }


}

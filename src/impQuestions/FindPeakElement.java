package impQuestions;

public class FindPeakElement {
    public static void main(String []args){
        //int []nums = {1,2,3,1};
        int []nums = {1,2,1,3,5,6,4};
        System.out.println(peakElementHelper(nums,0,nums.length-1));
    }

    private static int peakElementHelper(int[] nums, int start, int end) {
        if(start==end){
            return start;
        }else if(start+1==end){
            return nums[start]>nums[end]?start:end;
        }else{
            int mid = (start+end)/2;
            if(nums[mid]>nums[mid-1] && nums[mid]>nums[mid+1]){
                return mid;
            }else if(nums[mid-1]>nums[mid] && nums[mid]>nums[mid+1]){
                return peakElementHelper(nums,start,mid-1);
            }else{
                return peakElementHelper(nums,mid+1,end);
            }
        }
    }
}

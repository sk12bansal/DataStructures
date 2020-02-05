package impQuestions;

public class FindMinimumInRotatedSortedArray {
    public static void main(String args[]){
        int [] nums = {4,5,6,7,0,1,2};

        int start = 0;
        int end = nums.length-1;
        while(end > start){
            int mid = (start+end)/2;
            if(nums[mid]>nums[end]){
                start = mid+1;
            }else{
                end = mid;
            }
        }
        System.out.println(nums[start]);
    }
}

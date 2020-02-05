package impQuestions;

public class SearchInRotatedSortedArray {
    static int binarySearch(int [] nums ,int start,int end,int target){
        if(end>=start){
            int mid = (start+end)/2;
            if(nums[mid]==target){
                return mid;
            }else if(nums[start]<=nums[mid]){
                if(target>=nums[start] && target<nums[mid]){
                    return binarySearch(nums,start,mid-1,target);
                }else{
                    return binarySearch(nums,mid+1,end,target);
                }
            }else{
                if(target>nums[mid] && target<=nums[end]){
                    return binarySearch(nums,mid+1,end,target);
                }else{
                    return binarySearch(nums,0,mid-1,target);
                }
            }
        }
        return -1;
    }
    public static void main(String []args){
        int [] nums = {4,5,6,7,0,1,2};
        int target =0;
        System.out.println(binarySearch(nums,0,nums.length-1,target));
    }
}

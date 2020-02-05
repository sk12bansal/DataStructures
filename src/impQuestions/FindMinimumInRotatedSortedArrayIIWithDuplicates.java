package impQuestions;

public class FindMinimumInRotatedSortedArrayIIWithDuplicates {
    public static void main(String args[]) {
        int[] nums = {2,2,2,0,1};
        int start = 0;
        int end = nums.length - 1;
        while (start < end) {
            int mid = (start + end) / 2;
            if (nums[mid] > nums[end]) {
                start = mid + 1;
            } else if (nums[mid] < nums[end]) {
                end = mid;
            } else {
                end--;
            }
        }
        System.out.println(nums[start]);
    }
}

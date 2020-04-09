package impQuestions;

public class MergeSort {
    static void mergeSort(int[] nums, int[] res, int start, int end){
        if(start>=end){
            return;
        }
        int mid = (start+end)/2;
        mergeSort(nums,res,start,mid);
        mergeSort(nums,res,mid+1,end);
        mergeParts(nums,res,start,mid,mid+1,end);
    }

    static void mergeParts(int[] nums, int[] res, int left1, int right1, int left2, int right2){
        if(left1 == right2){
            return;
        }
        int l=0;
        int r=left2;
        int index=0;
        while(l<=right1 && r<=right2){
            if(nums[l]<= nums[r]){
                res[index++] = nums[l];
                l++;
            }else{
                res[index++] = nums[r];
                r++;
            }
        }
        while(l<=right1){
            res[index++] = nums[l];
            l++;
        }
        while(r<=right2){
            res[index++] = nums[r];
            r++;
        }
    }
    public static void main(String []args){
        int []nums = {5,2,3,1};
        int [] res = new int[nums.length];
        mergeSort(nums,res,0,nums.length-1);
        for(int n:res)
        System.out.println(n);
    }
}

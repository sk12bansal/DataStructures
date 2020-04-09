package impQuestions.microsoft;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Comparator;

public class SortIntegersByTheNumberOf1Bits {
    public static void main(String []args){
        int [] nums = {0,1,2,3,4,5,6,7,8};
        int []copy = new int[nums.length];
        for(int i=0;i<copy.length;i++){
            copy[i] = Integer.bitCount(nums[i])*100001 + nums[i];
        }
        Arrays.sort(copy);
        for(int i=0;i<nums.length;i++){
            copy[i] = copy[i]%100001;
        }
        for(int n:copy){
            System.out.println(n);
        }
    }
}

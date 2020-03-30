package impQuestions;

import java.util.ArrayList;
import java.util.List;

public class Permutations {
    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        backTrack(list,new ArrayList<>(),nums);
        return list;
    }

    private static void backTrack(List<List<Integer>> list, List<Integer> tmplist, int[] nums) {
        if(nums.length == tmplist.size()){
            list.add(new ArrayList<>(tmplist));
        }else {
            for (int i=0;i<nums.length;i++) {
                if(tmplist.contains(nums[i])) continue;
                tmplist.add(nums[i]);
                backTrack(list, tmplist, nums);
                tmplist.remove(tmplist.size() - 1);
            }
        }
    }

    public static void main(String []args){
        int []nums = {1,2,3};
        System.out.println(permute(nums));
    }
}

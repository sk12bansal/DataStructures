package impQuestions;

import java.util.ArrayList;
import java.util.List;

public class PermutationsIIDuplicates {
    public static List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        backTrack(list,new ArrayList<>(),nums, new boolean[nums.length]);
        return list;
    }

    private static void backTrack(List<List<Integer>> list, ArrayList<Integer> tmplist, int[] nums, boolean[] used) {
        if(tmplist.size() == nums.length){
            list.add(new ArrayList<>(tmplist));
        }else {
            for (int i = 0; i < nums.length; i++) {
                if (used[i] || i > 0 && nums[i - 1] == nums[i] && !used[i - 1])
                    continue;
                used[i] = true;
                tmplist.add(nums[i]);
                backTrack(list, tmplist, nums, used);
                used[i] = false;
                tmplist.remove(tmplist.size() - 1);
            }
        }
    }

    public static void main(String [] args){
        int [] nums = {1,1,2};
        System.out.println(permuteUnique(nums));
    }
}

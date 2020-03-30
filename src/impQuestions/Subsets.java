package impQuestions;

import javax.swing.tree.TreeNode;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Subsets {
    private static List<List<Integer>> subSets(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        backTrack(list,nums,new ArrayList<>(),0);
        return list;
    }

    private static void backTrack(List<List<Integer>> list, int[] nums, ArrayList<Integer> tmplist, int start) {
        list.add(new ArrayList<>(tmplist));
        System.out.println(tmplist);
        for(int i=start;i<nums.length;i++){
            if(tmplist.contains(nums[i])) continue;
            tmplist.add(nums[i]);
            backTrack(list,nums,tmplist,i+1);
            tmplist.remove(tmplist.size()-1);
        }
    }

    public static void main(String []args){
        int []nums = {1,2,3};
        System.out.println(subSets(nums));
    }

}

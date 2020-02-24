package impQuestions;

import java.util.LinkedList;

public class AddToArrayFormOfInteger {
    public static void main(String []args){
        int [] nums = {1,2,0,0};
        int k=34;

        LinkedList<Integer> ans = new LinkedList<>();
        for(int i=nums.length-1;k>0 || i>=0 ; i--,k/=10){
            if(i>=0){
                k+=nums[i];
            }
            ans.offerFirst(k%10);
        }
        System.out.println(ans);
    }
}

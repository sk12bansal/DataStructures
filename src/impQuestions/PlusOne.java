package impQuestions;

import java.util.Arrays;
import java.util.LinkedList;

public class PlusOne {
    public static void main(String []args){
        int [] digits = {9,9,9};

        LinkedList<Integer> ans = new LinkedList<>();
        int carry =1;
        for(int i=digits.length-1;i>=0;i--){
            carry +=digits[i];
            ans.offerFirst(carry%10);
            carry = carry/10;
        }
        if(carry==1){
            ans.offerFirst(carry);
        }
        int [] res = new int[ans.size()];
        for(int i=0;i<ans.size();i++){
            res[i] = ans.get(i);
        }
        System.out.println(res[0]);
    }
}

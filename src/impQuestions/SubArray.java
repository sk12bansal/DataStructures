package impQuestions;

import java.util.Arrays;

public class SubArray {
    public static void main(String []args){
        String []str= {"A","B","C","D","E","F"};
        String []copyStr = Arrays.copyOfRange(str,1,3);
        for(String s:copyStr)
        System.out.println(s);
    }
}

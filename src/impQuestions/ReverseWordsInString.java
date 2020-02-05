package impQuestions;

import java.util.Arrays;
import java.util.Collections;

public class ReverseWordsInString {
    public static void main(String args[]){
        String word = "the.sky.is.blue";

        /*String[] words = word.trim().split(" +");
        Collections.reverse(Arrays.asList(words));
        System.out.println(String.join(" ", words));*/

        String[] words = word.trim().split(".+");
        Collections.reverse(Arrays.asList(words));
        System.out.println(String.join(".", words));
    }
}

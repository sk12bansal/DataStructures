package impQuestions;

import java.util.Scanner;
import java.util.Stack;

public class ValidParentheses {
    public static void main(String []args){
        //String str = "()[]{}";
        String str = "(}[]{}";
        System.out.println(isValidParenthes(str));
    }

    private static boolean isValidParenthes(String str) {
        if(str.length()==1){
            return false;
        }
        Stack<Character> s = new Stack<>();
        for(int i=0;i<str.length();i++){
            if(str.charAt(i)== '(' || str.charAt(i)== '[' || str.charAt(i)== '{'){
                s.push(str.charAt(i));
            }
            if(s.isEmpty()){
                return false;
            }
            switch (str.charAt(i)){
                case ')':
                    if(s.peek() == '{' || s.peek() == '['){
                        return false;
                    }
                    s.pop();
                    break;
                case '}':
                    if(s.peek() == '(' || s.peek() == '['){
                        return false;
                    }
                    s.pop();
                    break;
                case ']':
                    if(s.peek() == '(' || s.peek() == '{'){
                        return false;
                    }
                    s.pop();
                    break;
            }
        }
        return s.isEmpty();
    }
}

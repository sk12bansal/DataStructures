package impQuestions;

import java.util.Stack;

public class DecodeString {
    public static String decodeString(String s) {
        Stack<Integer> inStack = new Stack<>();
        Stack<StringBuilder> strStack = new Stack<>();
        StringBuilder cur = new StringBuilder();
        int count=0;
        for(char ch: s.toCharArray()){
            if(Character.isDigit(ch)){
                count = count*10 + ch-'0';
            }else if(ch=='['){
                inStack.push(count);
                strStack.push(cur);
                cur = new StringBuilder();
                count=0;
            }else if(ch==']'){
                StringBuilder tmp= cur;
                cur = strStack.pop();
                int c = inStack.pop();
                while(c>0){
                    cur.append(tmp);
                    c--;
                }
            }else{
                cur.append(ch);
            }
        }
        return cur.toString();
    }
    public static void main(String []args){
        System.out.println(decodeString("3[a]2[bc]"));
        System.out.println(decodeString("3[a2[c]]"));
        System.out.println(4>>2);
        System.out.println(4<<2);
    }
}

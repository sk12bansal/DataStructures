package impQuestions;

public class CustomParseInt {
    public static int myAtoi(String str) {
        if(str.isEmpty()){
            return 0;
        }
        int i=0,base=0,sign=1;
        while(i<str.length() && str.charAt(i) == ' '){
            i++;
        }
        if(i<str.length() && (str.charAt(i) == '+' || str.charAt(i)=='-')){
            sign = str.charAt(i++)=='+' ? 1:-1;
        }
        while(i<str.length() && str.charAt(i) >='0' && str.charAt(i)<='9'){
            base = base *10 + (str.charAt(i)-'0');
            if(base > Integer.MAX_VALUE / 10 || (base == Integer.MAX_VALUE / 10 && str.charAt(i) - '0' > 7)){
                return sign==1?Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
            i++;
        }
        return base*sign;
    }
    public static void main(String []args){
        System.out.println(myAtoi(" "));
    }
}

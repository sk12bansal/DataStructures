package impQuestions;

public class ValidPalindrome {

    public static void main(String []args){
        String s = "A man, a plan, a canal: Panama";
        //String s = "Jrr     543534534 09807007 J";
        //String s = "0P";
        s= s.replaceAll( " ","");
        //System.out.println());
        System.out.println(validPalin(s));

    }

    private static boolean validPalin(String s) {
        if(s.isEmpty()){
            return true;
        }
        int left=0;
        int right = s.length()-1;
        while(left<right){
            char lc= s.charAt(left);
            char rc= s.charAt(right);
            if(!Character.isLetterOrDigit(lc)){
                left++;
                continue;
            }
            if(!Character.isLetterOrDigit(rc)){
                right--;
                continue;
            }
            if(Character.toLowerCase(lc) == Character.toLowerCase(rc)){
                left++;
                right--;
            }else{
                return false;
            }

        }
        return true;
    }
}

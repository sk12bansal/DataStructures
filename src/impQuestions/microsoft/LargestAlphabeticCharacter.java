package impQuestions.microsoft;

public class LargestAlphabeticCharacter {
    public static void main(String []args){
        System.out.println(largestAlphabet("admeDCAB"));
    }

    private static String largestAlphabet(String str) {
        boolean []upper = new boolean[26];
        boolean []lower = new boolean[26];
        for(char c:str.toCharArray()){
            if(Character.isLowerCase(c)){
                lower[c-'a']=true;
            }else{
               upper[c-'A'] =true;
            }
        }

        Integer.bitCount(6);
        for(int i=25;i>=0;i--){
            if(lower[i] && upper[i]){
                return (char)(i+'A') +"";
            }
        }
        return "NO";
    }
}

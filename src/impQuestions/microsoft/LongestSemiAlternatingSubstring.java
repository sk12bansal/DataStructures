package impQuestions.microsoft;


// MicroSoft  Longest Semi-Alternating Substring
// MicroSoft  Longest Substring Without 2 Contiguous Occurrences of Letter
public class LongestSemiAlternatingSubstring {
    public static void main(String []args){
       // String str= "baaabbaababbb";
        String str= "baaabbabbb";
        String res="";
        int l=0,r=0,a=0,b=0;
        char[]arr= str.toCharArray();
        int max = Integer.MIN_VALUE;
        while(r<arr.length){
            char c= arr[r];
            if(c=='a'){
                b=0;
                a++;
            }else if(c=='b'){
                a=0;
                b++;
            }
            if(a<3 && b<3){
                if(r-l+1>max){
                    max = r-l+1;
                    res= str.substring(l,r+1);
                }
            }else{
                l=r-1;
                if(a==3){
                    a=2;
                }
                if(b==3){
                    b=2;
                }
            }
            r++;
        }
        System.out.println(res);
    }
}

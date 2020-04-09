package impQuestions.microsoft;

/*
*  https://leetcode.com/problems/minimum-flips-to-make-a-or-b-equal-to-c/
* */
public class MinimumFlipsToMakeaORbEqualtoc {
    public static int minFlips(int a, int b, int c) {
        int ans =0;
        int ab = a|b;
        int equal = ab^c;
        for(int i=0;i<=31;i++){
            int ithBit = 1<<i;
            if((equal&ithBit)>0){
                ans += (a&ithBit) == (b&ithBit) && (c&ithBit)==0?2:1;
            }
        }
        return ans;
    }
    public static void main(String []args){

        System.out.println(minFlips(2,6,5));
        System.out.println(minFlips(4,2,7));
    }
}

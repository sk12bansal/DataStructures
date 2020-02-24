package dp;

public class LongestPalindromicSubString {
    public static String longestPalindrome(String s) {
        if(s.isEmpty()){
            return s;
        }
        Boolean [][] dp = new Boolean[s.length()][s.length()];
        int max_len =1;
        int beginIndex=0;
        int n = s.length();
        for(int i=0;i<n;i++){
            dp[i][i] = true;
        }
        for(int i=0;i<n-1;i++){
            if(s.charAt(i)==s.charAt(i+1)){
                dp[i][i+1] = true;
                beginIndex =i;
                max_len =2;
            }
        }
        for(int curr_len=3;curr_len<=n;curr_len++){

            for(int i=0;i<n-curr_len+1;i++){
                int j= curr_len+i-1;
                if(s.charAt(i) == s.charAt(j) && dp[i+1][j-1]){
                    dp[i][j] = true;
                    beginIndex = i;
                    max_len = curr_len;
                }
            }

        }
        return s.substring(beginIndex,beginIndex+max_len);
    }
    public static void main(String []args){
        System.out.println(longestPalindrome("babad"));
        System.out.println(longestPalindrome("a"));
        System.out.println(longestPalindrome("bb"));
        //System.out.println(longestPalindrome("abcda"));
    }
}

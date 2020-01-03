package dp;

public class PalindromicString {

    public static void main(String[] args) {
        String str = "BANANA";
        int n = str.length();

        int startIndex = 0;
        int max_len = 1;
        boolean[][] dp = new boolean[n][n];

        for (int i = 0; i < n; i++) {
            dp[i][i] = true;
        }
        for(int i=0;i<n-1;i++){
            if(str.charAt(i) == str.charAt(i+1)){
                dp[i][i+1] = true;
                startIndex = i;
                max_len = 2;
            }
        }

        for(int k = 3;k<=n;k++){
            for(int i=0;i<n-k+1;i++){

                int j = i+k-1;

                if(str.charAt(i) == str.charAt(j) && dp[i+1][j-1]){
                    dp[i][j] = true;
                    max_len = k;
                    startIndex = i;
                }else{
                    dp[i][j]= false;
                }
            }
        }
        System.out.println(str.substring(startIndex, max_len+1));
    }

}

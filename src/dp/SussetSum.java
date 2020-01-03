package dp;

public class SussetSum {
    public static void main(String args[]){
        int [] input = {1,3,9,2};
        int sum =5;
        int n = input.length;

        boolean [][] dp = new boolean[n+1][sum+1];
        for(int i=1;i<=sum;i++){
            dp[0][i] = false;
        }

        for(int i=0;i<=n;i++){
            dp[i][1] = true;
        }

        for(int i=1;i<=n;i++){
            for(int j=1;j<=sum;j++){
                dp[i][j] = dp[i-1][j];

                if(dp[i][j] == false && j>= input[i-1]){
                    dp[i][j] = dp[i][j] || dp[i-1][j- input[i-1]];
                }
            }
        }
        System.out.println(dp[n][sum]);
    }
}

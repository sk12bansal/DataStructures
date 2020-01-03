package dp;

public class TotalWaysMatrix {
    public static void main(String []args){

        int n =5;
        int [][]dp = new int[n][n];
        for(int i=0;i<n;i++){
            dp[0][i] = 1;
            dp[i][0] = 1;
        }

        for(int i=1;i<n;i++){
            for(int j=1;j<n;j++){
                dp[i][j] = dp[i-1][j] + dp[i][j-1];
            }
        }
        System.out.println(dp[n-1][n-1]);
     }
}

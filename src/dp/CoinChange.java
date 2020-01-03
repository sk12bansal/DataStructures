package dp;

public class CoinChange {

    public static void main(String args[]){
        int [] coins = {1,2,5};
        int n = coins.length;
        int amount = 5;
        int [][]dp = new int[n+1][amount+1];
        dp[0][0] =1;
        for(int i=1;i<=amount;i++){
            dp[0][i] = 0;
        }

        for(int i=1;i<=n;i++){
            for(int j=0;j<=amount;j++){

                if(i>j){
                    dp[i][j]= dp[i-1][j];
                }

                if(j-coins[i-1]>=0){
                    dp[i][j] = dp[i-1][j] + dp[i][j-coins[i-1]];
                }else{
                    dp[i][j]= dp[i-1][j];
                }
            }
        }
        System.out.println(dp[n][amount]);
    }
}

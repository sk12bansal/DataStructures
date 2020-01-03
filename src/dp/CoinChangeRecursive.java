package dp;

public class CoinChangeRecursive {
    public static void main(String args[]){
        int [] coins = {1,2,5};
        int n = coins.length;
        int amount = 5;
        System.out.println(totalWays(coins,n,amount));
    }

    private static int totalWays(int[] coins, int n, int amount) {
        if(amount == 0){
            return 1;
        }
        if(amount <0){
            return 0;
        }
        if(n<=0 && amount>=1){
            return 0;
        }
        return  totalWays(coins,n-1,amount)+totalWays(coins,n,amount-coins[n-1]);
    }
}

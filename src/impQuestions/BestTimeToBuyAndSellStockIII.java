package impQuestions;

public class BestTimeToBuyAndSellStockIII {
    public static int maxProfit(int[] prices) {
        int oneBuy = Integer.MAX_VALUE;
        int oneBuyOneSell = 0;
        int twoBuy = Integer.MAX_VALUE;
        int twoBuyTwoSell = 0;
        for(int i = 0; i < prices.length; i++){
            oneBuy = Math.min(oneBuy, prices[i]);//we set prices to negative, so the calculation of profit will be convenient
            System.out.println("oneBuy = " + oneBuy);
            oneBuyOneSell = Math.max(oneBuyOneSell, prices[i] - oneBuy);
            System.out.println("oneBuyOneSell = " + oneBuyOneSell);
            twoBuy = Math.min(twoBuy, prices[i]- oneBuyOneSell);//we can buy the second only after first is sold
            System.out.println("twoBuy = " + twoBuy);
            twoBuyTwoSell = Math.max(twoBuyTwoSell, prices[i]-twoBuy);
            System.out.println("twoBuyTwoSell = " + twoBuyTwoSell);
            System.out.println();
        }

        return Math.max(oneBuyOneSell, twoBuyTwoSell);
    }
    public static void main(String []args){
        int []prices = {3,3,5,0,0,3,1,4};
        System.out.println(maxProfit(prices));
    }
}

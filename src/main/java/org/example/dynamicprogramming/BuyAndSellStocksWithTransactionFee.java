package org.example.dynamicprogramming;
import java.util.Arrays;
public class BuyAndSellStocksWithTransactionFee {
    static int Fee;
    static int[] Prices;
    static int[][] dp;
    public static int bestStrat(int idx, int canBuy) {
        // base case
        if(idx == Prices.length) return 0;

        //fetching data from dp table
        if(dp[idx][canBuy] != -1) return dp[idx][canBuy];
        // recursive cases

        if(canBuy == 1) {
            return dp[idx][canBuy] = Math.max(bestStrat(idx+1,1), -Prices[idx] + bestStrat(idx+1, 0));
        }
        else {
            return dp[idx][canBuy] = Math.max(bestStrat(idx+1, 0), Prices[idx] + bestStrat(idx+1, 1) - Fee);
        }
    }

    public static int bestStratTab() {
        int n = Prices.length;
        int[][] dp = new int[n+1][2];

        for(int idx=n-1; idx >= 0; idx--) {
            dp[idx][0] = Math.max(dp[idx+1][0], Prices[idx] + dp[idx+1][1] - Fee);
            dp[idx][1] = Math.max(dp[idx+1][1], -Prices[idx] + dp[idx+1][0]);
        }

        return dp[0][1];
    }
    public static int maxProfit(int[] prices, int fee) {
        // this question is similar to buy and sell stocks 2 but after completing a transaction we must
        // pay a fee
        dp = new int[prices.length][2];
        Prices = prices;
        Fee = fee;
        for(int[] d: dp) Arrays.fill(d, -1);

        return bestStrat(0, 1);
    }
    public static void main(String[] args) {
        int[] prices = {1,3,2,8,4,9};
        int fee = 2;

        System.out.println(maxProfit(prices, fee));
    }
}

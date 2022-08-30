package org.example.dynamicprogramming;
import java.util.Arrays;
public class BuyAndSellStocks3 {
    static int[][][] dp;
    public static int bestStrategy(int idx, int canBuy, int k, int[] prices) {
        // base cases
        if(k == 0 || idx ==  prices.length) return 0;

        if(dp[idx][canBuy][k-1] != -1) return dp[idx][canBuy][k-1];

        // recursive cases
        if(canBuy == 1){
            int buy = -prices[idx] + bestStrategy(idx+1, 0, k, prices);
            int notbuy = bestStrategy(idx+1, 1, k, prices);

            return dp[idx][canBuy][k-1] = Math.max(buy, notbuy);
        }
        else{
            int sell = prices[idx] + bestStrategy(idx+1, 1, k-1, prices);
            int notsell = bestStrategy(idx+1, 0, k, prices);

            return dp[idx][canBuy][k-1] = Math.max(sell, notsell);
        }
    }
    public int maxProfit(int[] prices) {
        // this problem is a bounded problem with at max 2 transactions

        // a transaction is defined as the process of buying and selling a stock

        // lets build the recursive solution first
        dp = new int[prices.length][2][2];
        for(int[][] d: dp){
            for(int[] x: d){
                Arrays.fill(x,-1);
            }
        }
        return bestStrategy(0, 1, 2, prices);
    }

    static int bestStratTab(int[] prices) {
        int n = prices.length;
        int buyStates = 2;
        int limit = 2;
        int[][][] dp = new int[n+1][buyStates][limit+1];


        for(int i=n-1; i>=0 ; i--) {
            for(int buy=0; buy<2; buy++) {
                for(int l=1; l<=limit; l++) {
                    if(buy == 0){
                        dp[i][buy][l] = Math.max(-prices[i] + dp[i+1][1][l], dp[i+1][0][l]);

                    } // means we can buy
                    else{
                        dp[i][buy][l] = Math.max(prices[i] + dp[i+1][0][l-1], dp[i+1][1][l]);
                    } // means we can sell
                }
            }
        }

        return dp[0][0][2];
    }

    public static void main(String[] args) {
//        int[] prices = {3,3,5,0,0,3,1,4};
        int[] prices = {1,2,3,4,5};

        BuyAndSellStocks3 obj = new BuyAndSellStocks3();

        System.out.println(obj.maxProfit(prices));
    }
}

package org.example.dynamicprogramming;

import java.util.Arrays;

public class BuyAndSellStocksWithCooldown {
    static int[][] dp;
    public static int bestStrat(int idx, int canBuy, int[] prices) {
        // base cases
        if(idx >= prices.length)
            return 0;

        // fetching from dp table
        if(dp[idx][canBuy] != -1) return dp[idx][canBuy];
        // recursive cases

        if(canBuy == 1) {
            return dp[idx][canBuy] = Math.max(bestStrat(idx+1, 1, prices), -prices[idx] + bestStrat(idx+1, 0, prices));
        }
        else{
            return dp[idx][canBuy] = Math.max(bestStrat(idx+1, 0, prices), prices[idx] + bestStrat(idx+ 2, 1, prices));
        }
    }

    static int bestStratTab(int[] prices){
        int n = prices.length;
        int[][] dp = new int[n+2][2];

        for(int idx=n-1; idx >= 0; idx--) {
            for(int canBuy = 0; canBuy <2; canBuy++){
                if(canBuy == 1) {
                    dp[idx][canBuy] = Math.max(dp[idx+1][1] , -prices[idx] + dp[idx+1][0]);
                }
                else{

                    dp[idx][canBuy] = Math.max(dp[idx+1][0] , prices[idx] + dp[idx+2][1]);
                }
            }
        }

        return dp[0][1];

    }
    public static int maxProfit(int[] prices) {
        dp = new int[prices.length][2];
        for(int[] d: dp) Arrays.fill(d, -1);
        return bestStrat(0, 1, prices);
    }
    public static void main(String[] args) {

        int[] prices = {1,2,3,0,2};
        System.out.println(maxProfit(prices));
    }
}

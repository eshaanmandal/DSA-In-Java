package org.example.dynamicprogramming;

import java.util.Arrays;
import java.util.stream.IntStream;

public class BuyAndSellStocks2 {
    static int[][] dp;
    public static int maxProfitUtil(int idx, int canBuy, int[] prices) {
        // base cases
        if(idx == prices.length-1) {
            if(canBuy == 1) return 0;
            else return prices[idx];
        }
        if(dp[idx][canBuy] != -1) return dp[idx][canBuy];
        // decision making
        if(canBuy == 1) // means you are eligible to buy
            return dp[idx][canBuy] = Math.max(-prices[idx] + maxProfitUtil(idx+1, 0, prices), maxProfitUtil(idx+1, 1, prices));
        else
            return dp[idx][canBuy] = Math.max(prices[idx] + maxProfitUtil(idx+1, 1, prices), maxProfitUtil(idx+1, 0, prices));
    }
    public static int maxProfit(int[] prices) {
        return maxProfitUtil(0, 1, prices);
    }
    public static void main(String[] args) {
        int[] prices = {5, 1, 7, 10, 2, 3};
        dp = new int[prices.length][2];
        for(int[] d: dp) Arrays.fill(d, -1);
        System.out.println(maxProfit(prices));
    }
}

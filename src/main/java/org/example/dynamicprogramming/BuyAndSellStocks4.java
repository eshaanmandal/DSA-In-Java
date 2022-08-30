package org.example.dynamicprogramming;

import java.util.Arrays;

public class BuyAndSellStocks4 {
    static int[][][] dp;
    public static int bestStrat(int idx, int canBuy, int k, int[] prices) {
        // base cases
        if(idx == prices.length || k == 0) return 0;
        // recursion cases

        if(dp[idx][canBuy][k] != -1) return dp[idx][canBuy][k];

        if(canBuy == 1) {
            return dp[idx][canBuy][k] = Math.max(bestStrat(idx+1, 1, k, prices), -prices[idx] + bestStrat(idx+1, 0, k, prices));
        }
        else{
            return dp[idx][canBuy][k] = Math.max(bestStrat(idx+1, 0, k, prices), prices[idx] + bestStrat(idx+1, 1, k-1, prices));
        }
    }
    public static int maxProfit(int k, int[] prices) {
        // extension of the previous problem , in the previous problem k == 2
        dp = new int[prices.length][2][k+1];

        for(int[][] d: dp){
            for(int[] x: d){
                Arrays.fill(x, -1);
            }
        }
        return bestStrat(0, 1, k, prices);
    }
    public static void main(String[] args) {

        // in this question you can prepare at max k times.
        int k = 2;
        int[] prices = {2,4,1};
        System.out.println(maxProfit(k, prices));


    }
}

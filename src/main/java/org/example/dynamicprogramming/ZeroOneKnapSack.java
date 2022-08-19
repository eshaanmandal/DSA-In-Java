package org.example.dynamicprogramming;
import java.util.Arrays;
public class ZeroOneKnapSack {
    static int[][] dp;
    static int bestLoot(int idx, int W, int[] weight, int[] value){
        if(idx == 0) {
            if(weight[idx] <= W) {
                return value[0];
            }
            return 0;
        }
        if(dp[idx][W] != -1) return dp[idx][W];

        int notpick = bestLoot(idx-1, W, weight, value);
        int pick = 0;
        if(weight[idx] <= W) pick  = value[idx] + bestLoot(idx-1, W-weight[idx], weight, value);

        return dp[idx][W] = Math.max(notpick, pick);
    }
    static int knapsack(int[] weight, int[] value, int n, int maxWeight) {
        dp = new int[n][maxWeight+1];
        for(int[] d: dp) Arrays.fill(d,-1);

        return bestLoot(n-1, maxWeight, weight, value);
    }
    public static void main(String[] args) {
        int[] weight = {1, 3, 5, 6};
        int[] value = {10, 50, 5, 9};
        int maxWeight = 10;
        System.out.println(knapsack(weight,value, weight.length, maxWeight));
    }

}

package org.example.dynamicprogramming;

import java.util.Arrays;
public class FrogJumpWithKJumps {
    static int[] dp;
    static int pathwithkJumps(int n, int k, int[] cost){
        if(dp[n] != -1){
            return dp[n];
        }
        if(n == 0){
            return dp[0] = 0;
        }
        if(n == 1){
            return dp[1] = Math.abs(cost[0]  - cost[1]);
        }

        int minJump = (int)Integer.MAX_VALUE;

        for(int i=1; i<=k; i++){
            if(n-i >= 0) {
                int Jump = pathwithkJumps(n - i, k, cost) + Math.abs(cost[n] - cost[n - i]);
                minJump = Math.min(minJump, Jump);
            }

        }
        return dp[n] = minJump;
    }

    static int pathwithKJumpsTabulation(int n, int k, int[] cost){
        dp[0] = 0;
        int minJump = (int)Integer.MAX_VALUE;

        for(int i=1; i<n; i++){
            for(int j=1; j<=k; j++){
                if(i-j >= 0) {
                    int jump = dp[i - j] + Math.abs(cost[i] - cost[i - j]);
                    minJump = Math.min(minJump, jump);
                }
                else{
                    break;
                }
            }
            dp[i] = minJump;
        }

        return dp[n-1];

    }
    public static void main(String[] args){
        int[] cost = {10000, 100, 1, 1, 122, 122};
        dp = new int[cost.length];
        Arrays.fill(dp,-1);
        System.out.println("DP with memoization "+pathwithkJumps(cost.length-1, 5, cost));
        Arrays.fill(dp,-1);
        System.out.println("DP with tabulation " + pathwithKJumpsTabulation(cost.length, 5, cost));
    }
}

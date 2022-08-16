package org.example.dynamicprogramming;

import java.util.Arrays;
public class FrogJump {

    static int[] dp;
    static int minCost(int n, int[] stairs_cost){
        if(n==0)
            return 0;
        if(dp[n] != -1)
            return dp[n];

        int left = minCost(n-1, stairs_cost) + Math.abs(stairs_cost[n] - stairs_cost[n-1]);
        int right = (int)Integer.MAX_VALUE;
        if(n > 1)
            right = minCost(n-2, stairs_cost) + Math.abs(stairs_cost[n] - stairs_cost[n-2]);
        return dp[n] = Math.min(left, right);
    }

    static int memoized(int[] cost, int n){
        dp[0] = 0;
        for(int i=1; i<n; i++){
            int fs = dp[i-1] + Math.abs(cost[i-1] - cost[i]);
            int ss = (int)Integer.MAX_VALUE;
            if(i>1){
                ss = dp[i-2] + Math.abs(cost[i-2] - cost[i]);
            }
            dp[i] = Math.min(fs, ss);
        }

        return dp[n-1];
    }
    static int memoizedSpaceOptimized(int[] cost, int n){
        int prev1 = 0;
        int prev2 = 0;
        int curr = 0;
        for(int i=1; i<n; i++){
            int fs = prev1 + Math.abs(cost[i] - cost[i-1]);
            int ss = (int)Integer.MAX_VALUE;

            if(i > 1){
                ss = prev2 + Math.abs(cost[i] - cost[i-2]);
            }

            curr = Math.min(fs, ss);
            prev2 = prev1;
            prev1 = curr;
        }

        return curr;
    }
    static void initializeArr(int[] cost){
        Arrays.fill(dp,-1);
        dp[1] = Math.abs(cost[0] - cost[1]);
    }
    public static void main(String[] args){
        int[] cost = {30, 10, 60, 10, 60, 50};
        int n = cost.length;
        dp = new int[n];
        initializeArr(cost);

        System.out.println(minCost(n-1, cost));
        initializeArr(cost);

        System.out.println(memoized(cost, n));
        System.out.println(memoizedSpaceOptimized(cost,n));
    }
}

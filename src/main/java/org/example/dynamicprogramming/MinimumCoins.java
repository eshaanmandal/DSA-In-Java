package org.example.dynamicprogramming;

import java.util.Arrays;
public class MinimumCoins {
    static int[][] dp;
    public static int minCount(int n, int x, int[] num) {
        if(x == 0){
            return 0;
        }
        if(n == 0) {
            if(x % num[n] == 0) return x /num[n];
            return (int)Integer.MAX_VALUE-1;
        }
        if(dp[n][x] != -1) {
            return dp[n][x];
        }

        int notpick = minCount(n-1, x,num);
        int pick = (int)Integer.MAX_VALUE-1;

        if(num[n] <= x){
            pick = 1 + minCount(n, x-num[n],num);
        }

        return dp[n][x] = Math.min(notpick, pick);
    }
    public static int minimumElements(int num[], int x) {
        dp = new int[num.length][x+1];
        for(int[] d: dp) {
            Arrays.fill(d,-1);
        }
        int ans = (int)minCount(num.length-1, x, num);
        if( ans == (int)Integer.MAX_VALUE-1)
            return -1;
        return ans;

    }

    public static void main(String[] args) {
        int[] num = {4, 16, 19, 3, 20, 9, 13, 15, 2, 11};
        int x = 8;
        System.out.println(minimumElements(num, x));
    }

}

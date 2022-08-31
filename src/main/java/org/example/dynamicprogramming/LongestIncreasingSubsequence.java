package org.example.dynamicprogramming;

import java.util.Arrays;

public class LongestIncreasingSubsequence {
    static int[] NUMS;
    static int[][] dp;
    static int n;
    public static int LIS(int idx, int prev_idx) {
        // base cases
        if(idx == NUMS.length) return 0;
        // fetching from dp table
        if(dp[idx][prev_idx+1] != -1) return dp[idx][prev_idx+1];
        // recursive cases
        int not_take = LIS(idx+1, prev_idx);
        int take = 0;
        if((prev_idx == -1) || (NUMS[idx] > NUMS[prev_idx])) take = 1 + LIS(idx+1, idx);
        return dp[idx][prev_idx+1] = Math.max(take, not_take);
    }
    public static int lengthOfLIS(int[] nums) {
        NUMS = nums;
        n = nums.length;
        dp = new int[n][n];
        for(int[] d: dp) Arrays.fill(d,-1);
        return LIS(0, -1);
    }
    public static void main(String[] args) {
        int[][] test_cases = {
                {10,9,2,5,3,7,101,18},
                {0,1,0,3,2,3},
                {7,7,7,7,7,7,7}
        };

        for(int[] nums: test_cases){
            System.out.println(lengthOfLIS(nums));
        }
    }
}

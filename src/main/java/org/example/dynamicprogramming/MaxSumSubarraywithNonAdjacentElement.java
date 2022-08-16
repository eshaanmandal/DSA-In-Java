package org.example.dynamicprogramming;

import java.util.Arrays;

public class MaxSumSubarraywithNonAdjacentElement {
    static int[] dp;
    public static int maxSumNonAdjacent(int[] arr, int idx) {
        if(idx < 0)
            return 0;
        if(idx == 0)
            return arr[idx];

        return Math.max(arr[idx] + maxSumNonAdjacent(arr, idx-2), maxSumNonAdjacent(arr, idx-1));
    }
    public static int maxSumNonAdjacentMemo(int[] arr, int idx) {
        if(idx < 0)
            return 0;
        if(idx == 0){
            return dp[idx] = arr[idx];
        }
        if(idx == 1)
            return dp[idx] = Math.max(arr[0], arr[1]);

        int pick, nonpick;
        if(dp[idx-2] != -1)
            pick = arr[idx] + dp[idx-2];
        else
            pick = arr[idx] + maxSumNonAdjacentMemo(arr, idx-2);

        if(dp[idx-1] != -1)
            nonpick = dp[idx-1];
        else
            nonpick = maxSumNonAdjacentMemo(arr, idx-1);

        return dp[idx] = Math.max(pick, nonpick);
    }

    public static int maxSumNonAdjacentTab(int[] arr, int idx){
        dp[0] = arr[0];
        dp[1] = arr[1];

        for(int i=2; i<idx; i++){
            dp[i] = Math.max(arr[i] + dp[i-2], dp[i-1]);
        }

        return dp[idx-1];
    }

    public static int maxSumNonAdjacentSO(int[] arr, int idx){
        int prev2 = arr[0];
        int prev1 = arr[1];
        int curr = 0;
        for(int i=2; i<idx; i++){
            curr = Math.max(arr[i] + prev2, prev1);

            prev2 = prev1;
            prev1 = curr;

        }

        return curr;
    }

    public static void main(String[] args) {
        int[] arr = {1,2,3,1};
        dp = new int[arr.length];
        Arrays.fill(dp, -1);
        System.out.println(maxSumNonAdjacent(arr, arr.length-1));

        maxSumNonAdjacentMemo(arr, arr.length-1);
        System.out.println(dp[arr.length-1]);

        Arrays.fill(dp, -1);
        System.out.println(maxSumNonAdjacentTab(arr, arr.length));
        System.out.println(maxSumNonAdjacentSO(arr, arr.length));
    }
}

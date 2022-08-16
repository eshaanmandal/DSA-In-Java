package org.example.dynamicprogramming;


import java.util.Arrays;

public class SubSetSum {
    static int[][] dp;
    static boolean recursion(int n, int k, int[] arr){
        if(k == 0){
            return true;
        }
        if(n == 0){
            return arr[0] == k;
        }
        if(dp[n][k] != -1){
            return dp[n][k] == 0 ? false:true;
        }

        boolean nottaken = recursion(n-1, k, arr);
        boolean taken = false;
        if(arr[n] <= k){
            taken = recursion(n-1, k-arr[n], arr);
        }
        dp[n][k] = nottaken || taken ? 1:0;
        return nottaken || taken;
    }

    public static boolean subsetSumTabulation(int n, int k, int[] arr){
        boolean[][] dp = new boolean[n][k+1];

        for(int i=0; i<n; i++) dp[i][0] = true;
        dp[0][arr[0]] = true;
        for(int i=1; i<n; i++){
            for(int target = 1; target < k+1; target++){
                boolean nottake = dp[i-1][target];
                boolean take = false;
                if(arr[i] <= target){
                    take = dp[i-1][target - arr[i]];
                }
                dp[i][target] = take || nottake;
            }
        }
        System.out.println(Arrays.deepToString(dp));
        return dp[n-1][k];
    }

    public static boolean subsetSumToK(int n, int k, int arr[]){
        dp = new int[n][k+1];
        for(int[] d: dp){
            Arrays.fill(d,-1);
        }
        return recursion(n-1, k, arr);
    }
    public static void main(String[] args){
        int[] arr = {1,2,3,4,5,6,99};
        int n = arr.length;
        int k = 10;
        System.out.println(subsetSumToK(n, k, arr));

        System.out.println(subsetSumTabulation(n, k, arr));
    }
}

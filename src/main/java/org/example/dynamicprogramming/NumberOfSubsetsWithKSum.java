package org.example.dynamicprogramming;

public class NumberOfSubsetsWithKSum {
    static int[][] dp;
    public static int populateDPTable(int n, int tar, int[] num){
        for(int i=0; i<n; i++) dp[i][0] = 1;
        if(num[0] <= tar) dp[0][num[0]] = 1;

        for(int i=1; i<n; i++){
            for(int k=0; k<tar+1; k++){
                int nottake = dp[i-1][k];
                int take = 0;
                if(num[i] <= k) take = dp[i-1][k - num[i]];

                dp[i][k] = nottake + take;
            }
        }
        return dp[n-1][tar];
    }

    public static int findsubsetsMem(int n, int tar, int[] num){
        if(tar == 0)
            return 1;
        if(n == 0){
            dp[0][tar] = (num[0] == tar)?1:0;
        }
        if(dp[n][tar] != -1){
            return dp[n][tar];
        }

        int nottake = findsubsetsMem(n-1, tar, num);
        int take = 0;
        if(num[n] <= tar)take = findsubsetsMem(n-1, tar - num[n], num);
        return dp[n][tar] = nottake + take;
    }
    public static int findWays(int num[], int tar) {
        int n = num.length;
        dp = new int[n][tar+1];
        return populateDPTable(n, tar, num);

    }
    public static void main(String[] args) {
        int[] num = {0, 0, 1};
        int tar = 1;

        System.out.println(findWays(num, tar));

    }
}

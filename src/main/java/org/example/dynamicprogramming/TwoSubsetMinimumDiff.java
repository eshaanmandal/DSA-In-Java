package org.example.dynamicprogramming;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class TwoSubsetMinimumDiff {
    static boolean[][] dp;
    public static void findSubsetSum(int n, int k, int[] arr) {
        for(int i=0; i<n; i++) dp[i][0] = true;
        dp[0][arr[0]] = true;

        for(int i=1; i<n; i++){
            for(int target=1; target<k+1; target++){
                boolean nottake = dp[i-1][target];
                boolean take = false;

                if(arr[i] <= target) take = dp[i-1][target - arr[i]];

                dp[i][target] = nottake || take;
            }
        }
    }
    public static int minSubsetDiff(int n, int[] arr) {
        int k = IntStream.of(arr).sum();
        dp = new boolean[n][k+1];
        findSubsetSum(n, k, arr);
        List<Integer> s1 = new ArrayList<>();
        List<Integer> s2 = new ArrayList<>();

        for(int j = 0; j < k+1; j++){
            if(dp[n-1][j]) {
                s1.add(j);
                s2.add(k - j);
            }
        }

        int min_diff = Integer.MAX_VALUE;
        for(int j=0; j<s1.size(); j++){
            min_diff = Math.min(min_diff, Math.abs(s1.get(j) - s2.get(j)));
        }
        return min_diff;
    }
    public static void main(String[] args){
        int[] arr = {8, 6, 5};
        int n = arr.length;
        System.out.println(minSubsetDiff(n, arr));
    }
}

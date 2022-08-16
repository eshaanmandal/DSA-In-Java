package org.example.dynamicprogramming;

import java.util.Arrays;
public class GridTraveller {
    static long[][] dp;
    long totalPaths(int r, int c){
        // base case
        if(r == 0 || c == 0){
            return 0;
        }
        if(r == 1 && c == 1){
            return 1;
        }

        if(dp[r][c] != -1){
            return dp[r][c];
        }

        return dp[r][c] = totalPaths(r,c-1) + totalPaths(r-1,c);


    }
    static void initializeDP(int r, int c){
        dp = new long[r+1][c+1];
        for(long[] d:dp){
            Arrays.fill(d, -1);
        }
    }
    public static void main(String[] args){
        GridTraveller obj = new GridTraveller();

        int r = 18;
        int c = 18;

        initializeDP(r,c);

        System.out.println(obj.totalPaths(r,c));
    }
}

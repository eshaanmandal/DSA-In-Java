package org.example.dynamicprogramming;
import java.util.Arrays;
public class DistinctSubsequence {
    static int[][] dp;
    static int prime =(int)(Math.pow(10,9)+7);
    public int distinctSubs(int n, int m, String s, String t) {
        if(n < 0 && m >= 0)return 0;
        if(m < 0)return 1;

        if(dp[n][m] != -1){
            return dp[n][m];
        }

        if(s.charAt(n) == t.charAt(m)) {
            return dp[n][m] = distinctSubs(n-1, m, s, t) + distinctSubs(n-1, m-1, s, t);
        }
        else {
            return dp[n][m] = distinctSubs(n-1, m, s, t);
        }
    }
    public int distinctSubsTab(int n, int m, String s, String t) {
        int[][] dp = new int[n+1][m+1];

        for(int i=0; i<n+1; i++) dp[i][0] = 1;

        for(int i=1; i<n+1; i++) {
            for(int j=1; j<m+1; j++) {
                // if the chars match
                if(s.charAt(i-1) == t.charAt(j-1)){
                    dp[i][j] = dp[i-1][j] + dp[i-1][j-1];
                }
                else{
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        return dp[n][m];
    }

    public int distinctSubsTabSO(int n, int m, String s1, String s2) {
        int[] prev=new int[m+1];
        prev[0] = 1;
        for(int i=1;i<n+1;i++){
            int[] curr = new int[m+1];
            curr[0] = 1;
            for(int j=1;j<m+1;j++){

                if(s1.charAt(i-1)==s2.charAt(j-1))
                    curr[j] = (prev[j-1] + prev[j])%prime;
                else
                    curr[j] = prev[j] % prime;
            }

            prev = curr;
        }


        return prev[m];
    }
    public int numDistinct(String s, String t) {
        int n = s.length();
        int m = t.length();
//        dp = new int[n][m];
//        for(int[] d: dp) Arrays.fill(d, -1);
        return distinctSubsTab(n-1, m-1, s, t);

    }
    public static void main(String[] args) {
        String s = "rabbbit", t = "rabbit";

        DistinctSubsequence obj = new DistinctSubsequence();

        System.out.println(obj.numDistinct(s, t));

    }
}

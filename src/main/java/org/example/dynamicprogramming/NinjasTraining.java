package org.example.dynamicprogramming;
import java.util.Arrays;
import java.util.stream.IntStream;

public class NinjasTraining {
    static int[][] dp;
    public static int findMaxPoints(int[][] task, int day, int prev_task){
        // base cases
        if(day == task.length-1){
            int max_points = 0;
            for(int i=0; i<task[0].length; i++){
                if(i != prev_task){
                    max_points = Math.max(max_points, task[day][i]);
                }
            }
            return dp[day][prev_task] = max_points;
        }
        // adding +1 to take care of -1 index
        if(dp[day][prev_task+1] != -1){
            return dp[day][prev_task];
        }
        int max_points = 0;
        for(int i=0; i<task[0].length; i++){
            if(i != prev_task){
                int points = findMaxPoints(task, day+1, i) + task[day][i];

                max_points = Math.max(points, max_points);
            }
        }
        // adding +1 yo take care of -1 index
        return dp[day][prev_task+1] = max_points;
    }

    public static int findMaxPointsTab(int[][] task, int day){
        for(int i=0; i<task[0].length; i++){
            int max = 0;
            for(int j=0; j<task[0].length; j++){
                if(i != j) {
                    max = Math.max(max, task[0][j]);
                }
            }
            dp[0][i] = max;
        }


        for(int d = 1; d<task.length; d++){
            for(int i=0; i<task[0].length; i++){
                int max=  0;
                for(int j=0; j<task[0].length; j++){
                    if(i != j){
                        max = Math.max(max, dp[d-1][j] + task[d][j]);
                    }
                }
                dp[d][i] = max;
            }
        }

        return IntStream.of(dp[task.length-1]).max().getAsInt();
    }
    public static void main(String[] args){

        int[][] task = {
                {80, 50, 1},
                {5, 100, 11}
        };
        dp = new int[task.length][task[0].length];

        for(int[] r: dp){
            Arrays.fill(r,-1);
        }

        int maxpoints = findMaxPoints(task,0,-1);

        System.out.println(maxpoints);

        System.out.println(findMaxPointsTab(task, 0));


    }
}

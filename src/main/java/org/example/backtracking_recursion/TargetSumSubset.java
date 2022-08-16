package org.example.backtracking_recursion;

public class TargetSumSubset {
    static void findSubset(int[] arr, int idx, String set, int curr_sum, int ts){
        // base case
        // 1. if the sum is found
        if(curr_sum == ts){
            for(String element: set.split(",")){
                System.out.print(element + " ");
            }
            System.out.println();
            return;
        }
        // 2. if index exceeds the array length
        if(idx >= arr.length)
            return;


        findSubset(arr, idx+1, set + arr[idx] + ",", curr_sum + arr[idx], ts);
        findSubset(arr, idx+1, set, curr_sum, ts);
    }
    public static void main(String[] args){
        int[] arr = {10, 20, 30};
        int ts = 30;
        int curr_sum = 0;

        findSubset(arr, 0, "", curr_sum, ts);

    }
}

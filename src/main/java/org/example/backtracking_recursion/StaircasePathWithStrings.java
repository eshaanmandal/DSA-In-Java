package org.example.backtracking_recursion;

public class StaircasePathWithStrings {
    static void printStairPaths(int n, String paths){
        // base case
        /*
            here we have two base cases
            1. positive base case
            2. negative base case
         */
        if(n == 0){
            System.out.println(paths);
            return;
        }
        else if(n < 0){
            return;
        }

        // for 1 jump
        printStairPaths(n-1, "1" + paths);

        // for 2 jumps
        printStairPaths(n-2, "2" + paths);

        // for 3 jumps
        printStairPaths(n-3, "3" + paths);
    }
    public static void main(String[] args){
        int n = 10;
        String paths = "";
        printStairPaths(n, paths);
    }
}

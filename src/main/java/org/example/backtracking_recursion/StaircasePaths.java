package org.example.backtracking_recursion;

import java.util.ArrayList;
import java.util.Scanner;

public class StaircasePaths {
    static ArrayList<String> findPaths(int n){
        // base cases
        if(n == 0){
            ArrayList<String> bpath = new ArrayList<>();
            bpath.add("");
            return bpath;
        }
        if(n < 0){
            return new ArrayList<String>();
        }
        // post order operations
        ArrayList<String> path1 = findPaths(n-1);
        ArrayList<String> path2 = findPaths(n-2);
        ArrayList<String> path3 = findPaths(n-3);

        ArrayList<String> paths = new ArrayList<>();

        for(String p1: path1){
            paths.add(1 + p1);
        }

        for(String p2: path2){
            paths.add(2 + p2);
        }

        for(String p3: path3){
            paths.add(3 + p3);
        }

        return paths;
    }
    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();

        ArrayList<String> paths = findPaths(n);

        System.out.println(paths);
    }
}

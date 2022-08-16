package org.example.backtracking_recursion;

public class MazePathsWithStrings {
    static void printMazePaths(int sr, int sc, int dr, int dc, String paths){
        if(sr == dr && sc == dc){
            System.out.println(paths);
            return;
        }

        if(sr < dr)
            printMazePaths(sr+1, sc, dr, dc, "v" + paths);
        if(sc < dc)
            printMazePaths(sr, sc+1, dr, dc, "h" + paths);


    }
    public static void main(String[] args){
        int sr = 1, sc = 1, dr = 3, dc = 3;
        String paths = "";

        printMazePaths(sr, sc, dr, dc, paths);
    }
}

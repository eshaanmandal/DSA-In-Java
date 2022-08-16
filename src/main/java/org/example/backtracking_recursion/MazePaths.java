package org.example.backtracking_recursion;
import java.util.ArrayList;
import java.util.Scanner;
public class MazePaths {
    private static ArrayList<String> getMazePaths(int sr, int sc, int dr, int dc){
        // base case
        if(sr == dr && sc == dc){
            ArrayList<String> bpath = new ArrayList<>();
            bpath.add("");
            return bpath;
        }
        ArrayList<String> hpaths = new ArrayList<>();
        ArrayList<String> vpaths = new ArrayList<>();
        if(sr < dr)
             hpaths = getMazePaths(sr+1, sc, dr, dc);
        if(sc < dc)
            vpaths = getMazePaths(sr, sc+1, dr, dc);
//        ArrayList<String> vpaths = getMazePaths(sr+1, sc, dr, dc);

        ArrayList<String> paths = new ArrayList<>();

        for(String hpath: hpaths){
            paths.add("h" + hpath);
        }

        for(String vpath: vpaths){
            paths.add("v" + vpath);
        }
//        System.out.println(paths);
        return paths;



    }
    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);
//        int sr = scn.nextInt();
//        int sc = scn.nextInt();
        int dr = scn.nextInt();
        int dc = scn.nextInt();

//        ArrayList<String> hpaths = getMazePaths(sr, sc+1, dr, dc);
//        ArrayList<String> vpaths = getMazePaths(sr+1, sc, sr, dc);

        ArrayList<String> paths = getMazePaths(1, 1, dr, dc);
        System.out.println(paths);


//        System.out.println(paths);

    }
}

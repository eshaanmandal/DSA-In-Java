package org.example.backtracking_recursion;

import java.util.ArrayList;

public class MazepathwithJump {
    static ArrayList<String> findPathWithJumps(int sr, int sc, int dr, int dc){
        // base case
        if(sr == dr && sc == dc){
            ArrayList<String> bpath = new ArrayList<>();
            bpath.add("");
            return bpath;
        }
        ArrayList<String> paths = new ArrayList<>();
        // vertical moves
        for(int i = 1; i <= dr - sr; i++){
            ArrayList<String> vpaths = findPathWithJumps(sr+i, sc, dr, dc);
            for(String vpath: vpaths){
                paths.add("v" + i + vpath);
            }
        }
        // horizontal paths
        for(int j = 1; j <= dc - sc; j++){
            ArrayList<String> hpaths = findPathWithJumps(sr, sc+j, dr, dc);
            for(String hpath: hpaths){
                paths.add("h" + j + hpath);
            }
        }

        // diagonal paths
        for(int i=1; i <= dr-sr && i <= dc-sc; i++){
            ArrayList<String> dpaths = findPathWithJumps(sr+i, sr+i, dr, dc);
            for(String dpath: dpaths){
                paths.add("d" + i + dpath);
            }
        }

        return paths;
    }
    public static void main(String[] args){
        int sr = 1, sc = 1, dr = 3, dc = 3;
        ArrayList<String> paths = findPathWithJumps(sr, sc, dr, dc);
        System.out.println(paths);
    }
}

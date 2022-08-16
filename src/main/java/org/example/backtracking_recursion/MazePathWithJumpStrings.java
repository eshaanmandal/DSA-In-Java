package org.example.backtracking_recursion;

public class MazePathWithJumpStrings {
    public static void printMazePathWithJumps(int sr, int sc, int dr, int dc, String paths){
        if(sr ==  dr && sc == dc){
            System.out.println(paths);
            return;
        }

        // moves in vertical direction
        for(int mov_s = 1; mov_s <= dr-sr; mov_s++){
            printMazePathWithJumps(sr+mov_s, sc, dr, dc, "v" + mov_s + paths);
        }

        // moves in horizontal direction
        for(int mov_s = 1; mov_s <= dc-sc; mov_s++){
            printMazePathWithJumps(sr, sc+mov_s, dr, dc, "h" + mov_s + paths);
        }

        // moves in diagonal
        for(int mov_s=1; mov_s <= dr - sr && mov_s <= dc-sc; mov_s++){
            printMazePathWithJumps(sr+mov_s, sc+mov_s, dr, dc, "d" + mov_s + paths);
        }
    }
    public static void main(String[] args){
        String paths = "";
        printMazePathWithJumps(1, 1, 3,4,paths);
    }
}

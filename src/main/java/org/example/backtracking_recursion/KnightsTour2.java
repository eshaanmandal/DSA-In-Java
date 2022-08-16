package org.example.backtracking_recursion;

import java.util.Scanner;

public class KnightsTour2 {
    static int[] mov_r = {-2,-1, 1, 2, -2, -1, 1, 2};
    static int[] mov_c = {1, 2, 2, 1, -1, -2, -2, -1};
    static void knightsTour(int[][] grid, boolean[][] visited, int r, int c, int total_possible_moves, int curr_move, String psf){
        // the base case 1 -  to check if the move is valid or not
        if(r < 0 || r >= grid.length || c < 0 || c >= grid[0].length || visited[r][c]){
            return;
        }
        // the base case 2 -  to check if the knigh has covered all the tiles if true them print its tour
        if(curr_move == total_possible_moves){
            System.out.println(psf);
            return;
        }

        visited[r][c] = true;
        for(int i=0; i<8; i++){
            int new_r = r + mov_r[i];
            int new_c = c + mov_c[i];

            knightsTour(grid, visited, new_r, new_c, total_possible_moves, curr_move+1, psf + "("+r+", "+c+"), ");
        }
        visited[r][c] = false;
    }
    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);
        int sr = scn.nextInt();
        int sc = scn.nextInt();
        int[][] grid = {
                {0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0}

        };
        boolean[][] visited = new boolean[grid.length][grid[0].length];

        int total_possible_moves = grid.length * grid[0].length;

        knightsTour(grid, visited, sr, sc, total_possible_moves, 1, "");
    }
}

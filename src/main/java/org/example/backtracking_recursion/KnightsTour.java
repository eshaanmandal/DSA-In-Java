package org.example.backtracking_recursion;
import java.util.Scanner;

public class KnightsTour {
    static int[] mov_r = {-2,-1, 1, 2, -2, -1, 1, 2};
    static int[] mov_c = {1, 2, 2, 1, -1, -2, -2, -1};

    static boolean isValid(int[][] grid, int r, int c, boolean[][] visited){
        return r >= 0 && r < grid.length && c >= 0 && c < grid[0].length && !visited[r][c];
    }
    public static void moveKnight(int[][] grid, boolean[][] visited, int r, int c, int final_tile, String psf, int cell_num){
        // base case
        if(cell_num == final_tile){
            System.out.println(psf);
            return;
        }

        visited[r][c] = true;

        for(int i=0; i<8; i++){
            int new_r = r + mov_r[i];
            int new_c = c + mov_c[i];
            if(isValid(grid, new_r, new_c, visited))
                moveKnight(grid, visited, new_r, new_c, final_tile, psf + "(" + new_r +","+ new_c + ")" +", ", cell_num+1);
        }

        visited[r][c] = false;
    }
    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);
        int sr = scn.nextInt();
        int sc = scn.nextInt();
        int[][] grid = {
                {0, 0, 0, 0},
                {0, 0, 0, 0},
                {0, 0, 0, 0},
                {0, 0, 0, 0},
                {0, 0, 0, 0}

        };
        boolean[][] visited = new boolean[grid.length][grid[0].length];

        int final_tile = grid.length * grid[0].length;
        String psf = "(" + sr+ ", " +sc +"), ";
        moveKnight(grid, visited,sr, sc, final_tile, psf, 1);
    }
}

package org.example.backtracking_recursion;

public class FloodFill {
    static void findPath(int[][] grid, int r, int c, boolean[][] visited, String psf){
        // base case first
        // this question is call stupid base case smart
        // means we are making stupid calls at everytime, but we have smart base cases to take care of it

        if(r < 0 || c < 0 || r == grid.length || c == grid[0].length || grid[r][c] == 1 || visited[r][c]==true)
            return;

        if(r == grid.length-1 && c == grid[0].length-1){
            System.out.println(psf);
            return;
        }

        visited[r][c] = true;
        findPath(grid, r-1, c, visited, psf+"T");
        findPath(grid, r, c-1, visited, psf+"L");
        findPath(grid, r+1, c, visited, psf+"D");
        findPath(grid, r, c+1,visited, psf+"R");
        visited[r][c] = false;

    }
    public static void main(String[] args){
        int[][] grid = {
                {0, 1, 0, 0, 0, 0, 0},
                {0, 1, 0, 1, 1, 1, 0},
                {0, 0, 0, 0, 0, 0, 0},
                {1, 0, 1, 1, 0, 1, 1},
                {1, 0, 1, 1, 0, 1, 1},
                {1, 0, 0, 0, 0, 0, 0},
        };

        boolean[][] visited = new boolean[grid.length][grid[0].length];

        findPath(grid, 0,0,visited, "");
    }
}

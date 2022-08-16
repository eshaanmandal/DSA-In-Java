package org.example.graph;


public class CountIsland {
    public static int[] mov_r = {-1, 1, 0, 0};
    public static int[] mov_c = {0, 0, -1, 1};

    // Checks whether a block lies within the grid and is a piece of land that is not visited
    public static boolean isUnvisitedLand(int[][] grid, int r, int c){
        return r >= 0 && r < grid.length && c >= 0 && c < grid[0].length && grid[r][c] == 1;
    }
    public static boolean explore(int[][] grid, int r, int c){

        // check if the island has been visited
        if(grid[r][c] == -1){
            return false;
        }
        // if not mark it as visited
        grid[r][c] = -1;
        // move in all four possible directions from the current land in order to search for other islands (DFS)
        for(int i=0; i<4; i++){
            int new_r = r + mov_r[i];
            int new_c = c + mov_c[i];
            // if it is an unvisited land with a valid index
            if(isUnvisitedLand(grid, new_r, new_c)){
                explore(grid, new_r, new_c);
            }
        }
        return true;
    }
    public static int countisland(int[][] grid){
        int n = grid.length;
        int m = grid[0].length;
        int count = 0;

        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(grid[i][j] == 1){
                    if(explore(grid, i, j)){
                        count++;
                    }
                }
            }
        }
        return count;
    }
    public static void main(String[] args){
       int[][] grid = {
               {1, 0, 0, 0, 1, 0, 0, 0},
               {0, 0, 0, 0, 0, 0, 0, 0},
               {0, 0, 0, 0, 0, 0, 0, 0},
               {0, 0, 0, 1, 1, 0, 0, 0},
               {0, 0, 0, 1, 1, 0, 0, 0},
               {0, 0, 0, 0, 0, 0, 0, 0},
               {0, 0, 0, 0, 0, 0, 0, 0},
               {0, 0, 0, 0, 1, 0, 0, 0}
       };

       System.out.println(countisland(grid));
    }

}

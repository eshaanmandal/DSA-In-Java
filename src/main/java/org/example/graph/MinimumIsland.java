package org.example.graph;

public class MinimumIsland {
    private static int[] mov_r = {0, 0, -1, 1};
    private static int[] mov_c = {-1, 1, 0, 0};

    private static boolean isValidUnvisitedIsland(int[][] grid, int r, int c){
        return r>=0 && r<grid.length && c>=0 && c<grid[0].length && grid[r][c] == 1;
    }
    private static int explore(int[][] grid, int r, int c){
        if(grid[r][c] == -1)
            return 0;
        grid[r][c] = -1;
        int size = 1;
        for(int i=0; i<4; i++){
            int new_r = r + mov_r[i];
            int new_c = c + mov_c[i];

            if(isValidUnvisitedIsland(grid, new_r, new_c)){
                size += explore(grid, new_r, new_c);
            }
        }

        return size;

    }
    private static int minimumIsland(int[][] grid){
        // lets iterate the grid first
        int n = grid.length;
        int m = grid[0].length;
        int minimum = Integer.MAX_VALUE;
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(grid[i][j] == 1){
                    int size = explore(grid, i, j);

                    minimum = Math.min(minimum, size);
                }
            }
        }
       return minimum;
    }
    public static void main(String[] args){
        int[][] grid = {
                {1, 0, 0, 0, 0, 0, 0, 0},
                {1, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 1, 1, 0, 0, 0},
                {0, 0, 0, 1, 1, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 1, 1, 0, 0, 0}
        };
        System.out.println("Minimum island size : " + minimumIsland(grid));
        // 1 represents land and 0 represents water

    }
}

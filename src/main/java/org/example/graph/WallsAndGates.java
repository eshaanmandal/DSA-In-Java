package org.example.graph;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class WallsAndGates {
    public void findDistance(int[][] grid){
        Queue<List<Integer>> queue = new LinkedList<>();

        int N = grid.length;
        int M = grid[0].length;

        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                if(grid[i][j] == 0){
                    queue.add(Arrays.asList(i,j,0));
                }
            }
        }

        while(!queue.isEmpty()){
            List<Integer> tmp = queue.poll();
            int r = tmp.get(0);
            int c = tmp.get(1);
            int d = tmp.get(2);



            if(d < grid[r][c])
                grid[r][c] = d;

            int[] mov_r = {0, 0, -1, 1};
            int[] mov_c = {-1, 1, 0, 0};

            for(int i=0; i<4; i++){
                int new_r = r + mov_r[i];
                int new_c = c + mov_c[i];

                if(new_r >= 0 && new_r < N && new_c >= 0 && new_c < M  && grid[new_r][new_c] == Integer.MAX_VALUE)
                    queue.add(Arrays.asList(new_r, new_c, d+1));

            }

        }
    }
    public static void main(String[] args){
        int inf = Integer.MAX_VALUE;
        int[][] grid = {
                {inf, -1, 0, inf},
                {inf, inf, inf, -1},
                {inf, -1, inf, -1},
                {0, -1, inf, inf}
        };
        WallsAndGates obj = new WallsAndGates();
        obj.findDistance(grid);

        for(int i=0; i<grid.length; i++){
            for(int j=0; j<grid[0].length; j++){
                System.out.print(grid[i][j] + " ");
            }
            System.out.println();
        }
    }
}

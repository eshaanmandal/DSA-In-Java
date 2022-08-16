package org.example.graph;

import java.util.ArrayList;

public class DirectedGraphLoopDetectDFS {
    public static boolean dfs(int node, int[] visited, int[] dfsvisited, ArrayList<ArrayList<Integer>> adj){
        visited[node] = 1;
        dfsvisited[node] = 1;

        for(int neigh: adj.get(node)){
            if(visited[neigh] == 0){
                if(dfs(neigh, visited, dfsvisited, adj))
                    return true;
            }
            else if(dfsvisited[neigh] == 1){
                return true;
            }
        }

        dfsvisited[node] = 0;
        return false;
    }
    public static void main(String[] args){
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        for(int i=0; i<5; i++){
            adj.add(new ArrayList<>());
        }

        adj.get(0).add(1);
        adj.get(0).add(2);

        adj.get(1).add(3);
        adj.get(1).add(4);

        adj.get(3).add(4);
        int[] visited = new int[5];
        int[] dfsvisited = new int[5];

        for(int i=0; i<5; i++){
            if(visited[i] == 0){
                System.out.println(dfs(i, visited, dfsvisited, adj));
            }
        }
    }
}

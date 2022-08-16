package org.example.graph;

import java.util.ArrayList;
import java.util.Stack;

public class TopologicalSortDFS {
    public static void dfs(int node, int[] visited, Stack<Integer> s, ArrayList<ArrayList<Integer>> adj){
        visited[node] = 1;

        for(int neighbour: adj.get(node)){
            if(visited[neighbour] == 0){
                dfs(neighbour, visited, s, adj);
            }
        }

        s.push(node);
    }
    public static void main(String[] args){
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        int n = 6;
        for(int i=0; i<n; i++){
            adj.add(new ArrayList<>());
        }
        int[] visited = new int[n];
        Stack<Integer> s = new Stack<>();

        adj.get(2).add(3);
        adj.get(3).add(1);
        adj.get(4).add(0);
        adj.get(4).add(1);
        adj.get(5).add(0);
        adj.get(5).add(2);

        for(int i=0; i<n; i++){
            if(visited[i] == 0){
                dfs(i, visited, s, adj);
            }
        }

        while(s.size() > 0){
            System.out.println(s.pop() + " ");
        }


    }
}

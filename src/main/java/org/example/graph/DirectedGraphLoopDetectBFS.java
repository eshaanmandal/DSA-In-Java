package org.example.graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class DirectedGraphLoopDetectBFS {
    public boolean bfsLoopDetect(int node, boolean[] visited, List<List<Integer>> adj, int[] in_node){
        visited[node] = true;
        Queue<Integer> q = new LinkedList<>();

        for(int i=0; i< visited.length; i++){
            if(in_node[i] == 0)
                q.add(i);
        }
        int count=0;
        while (!q.isEmpty()){
            int curr = q.poll();
            count++;
            System.out.println(count);
            for(int neigh: adj.get(curr)){
                if(!visited[neigh] && in_node[neigh] == 0){
                    q.add(neigh);
                    visited[neigh] = true;
                    in_node[neigh]--;
                }
            }
        }

        if(count != visited.length)
            return true;
        return false;


    }
    public static void main(String[] args){
        List<List<Integer>> adj = new ArrayList<>();
        int nodes = 5;
        int[] in_node = new int[nodes];

        boolean[] visited = new boolean[nodes];
        for(int i=0; i<nodes; i++){
            adj.add(new ArrayList<>());
        }

        adj.get(0).add(1);
        adj.get(1).add(2);
        adj.get(2).add(3);
        adj.get(2).add(4);
        adj.get(3).add(4);
//        adj.get(4).add(2);

        for(int i=0; i<adj.size(); i++){
            for(int j=0; j<adj.get(0).size(); j++){
                in_node[j]++;
            }
        }
        DirectedGraphLoopDetectBFS obj = new DirectedGraphLoopDetectBFS();
        for(int i=0; i<nodes; i++){
            if(visited[i]){
                if(obj.bfsLoopDetect(i, visited, adj, in_node)){
                    System.out.println("True");
                    break;
                }
            }
        }

    }
}

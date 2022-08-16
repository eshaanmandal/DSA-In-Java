package org.example.graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class TopologicalSortBFSKahnsAlgo {
    public static void main(){
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        int n = 6;
        for(int i=0; i<n; i++){
            adj.add(new ArrayList<>());
        }
        int[] ndegree = new int[n];
        Queue<Integer> q = new LinkedList<>();

        adj.get(2).add(3);
        adj.get(1).add(3);
        adj.get(4).add(0);
        adj.get(4).add(1);
        adj.get(5).add(0);
        adj.get(5).add(2);

        for(int node=0; node<n; node++){
            for(int neigh: adj.get(node)){
                ndegree[neigh]++;
            }
        }

        for(int x: ndegree){
            System.out.println(x);
        }
    }
}

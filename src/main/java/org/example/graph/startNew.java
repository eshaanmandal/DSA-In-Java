package org.example.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
class Pairs{
    int node;
    int value;

    Pairs(int n, int v){
        this.node = n;
        this.value = v;
    }
}
public class startNew {
    public static void main(String[] args) {
        int[][] edges = {
                {1, 2},
                {2, 3},
                {3, 4},
        };
        int[] V = {3, 1, 5, 7};
        Map<Integer, ArrayList<Pairs>> adj = new HashMap<>();
        int N = 4;
        for (int i = 1; i <= N; i++) {
            adj.put(i, new ArrayList<>());
        }

        for(int[] edge : edges){
            adj.get(edge[0]).add(new Pairs(edge[1], V[edge[1]-1]));
        }



    }
}

package org.example.graph;

import java.util.ArrayList;
import java.util.HashMap;

public class CreateGraph<K> {
    public HashMap<K, ArrayList<K>> generateAdjList(K[] nodes, int n){
        // returns an empty adjacency list which could be later populated by the user

        HashMap<K, ArrayList<K>> adj_list = new HashMap<>();

        for(int i=0; i<n; i++){
            adj_list.put(nodes[i], new ArrayList<>());
        }

        return adj_list;
    }
}

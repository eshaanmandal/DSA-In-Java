package org.example.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class LargestIslandFind {
    public static int explore(HashMap<Integer, ArrayList<Integer>> graph, int node, HashSet<Integer> visited){
        if(visited.contains(node))
            return 0;
        visited.add(node);
        int size = 1;
        for(Integer neighbour: graph.get(node)){
            size += explore(graph, neighbour, visited);
        }

        return size;
    }

    public static int findSize(HashMap<Integer, ArrayList<Integer>> graph){
        int longest = 0;
        HashSet<Integer> visited = new HashSet<>();
        for(int node: graph.keySet()){
            int size = explore(graph, node, visited);

            if(size > longest)
                longest = size;
        }

        return longest;
    }

    public static void main(String[] args){
        Integer[] nodes = {0, 1, 5, 8, 2, 3, 4};
        int n = nodes.length;
        CreateGraph<Integer> c = new CreateGraph<>();
        HashMap<Integer, ArrayList<Integer>> graph = c.generateAdjList(nodes, n);
        // populating the graph entries

        graph.get(0).add(8);
        graph.get(0).add(1);
        graph.get(0).add(5);

        graph.get(1).add(0);

        graph.get(5).add(0);
        graph.get(5).add(8);

        graph.get(8).add(0);
        graph.get(8).add(5);

        graph.get(2).add(3);
        graph.get(2).add(4);

        graph.get(4).add(3);
        graph.get(4).add(2);

        graph.get(3).add(2);
        graph.get(3).add(4);

        System.out.println("The largest island has size : " + findSize(graph));

    }
}

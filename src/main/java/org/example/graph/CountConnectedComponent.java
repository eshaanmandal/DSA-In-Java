package org.example.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class CountConnectedComponent {

    public static boolean explore(HashMap<Integer, ArrayList<Integer>> graph, int node, HashSet<Integer> visited){
        if(visited.contains(node)){
            return false;
        }
        visited.add(node);

        for(Integer neighbours: graph.get(node)){
            explore(graph, neighbours, visited);
        }

        return true;
    }
    public static int countComponents(HashMap<Integer, ArrayList<Integer>> graph){
        int count = 0;
        HashSet<Integer> visited = new HashSet<>();
        for(int node: graph.keySet()){
            if(explore(graph, node, visited) == true){
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args){
        CreateGraph<Integer> c = new CreateGraph<>();
        Integer[] nodes = {1, 2, 3, 4, 5, 6};
        int n = nodes.length;
        HashMap<Integer, ArrayList<Integer>> graph = c.generateAdjList(nodes, n);

        // populating the adjacency list of the graph
        graph.get(1).add(2);
        graph.get(2).add(1);
        graph.get(3).add(4);
        graph.get(4).add(3);
        graph.get(5).add(6);
        graph.get(6).add(5);

        // Graph has been created

       System.out.println(countComponents(graph));


    }
}

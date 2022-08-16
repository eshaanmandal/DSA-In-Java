package org.example.graph;

import java.util.*;
class Pair{
    Integer node;
    Integer parent;

    Pair(Integer node, Integer parent){
        this.node = node;
        this.parent = parent;
    }
}
public class LoopDetectBfs {
    public static boolean explore(HashMap<Integer, ArrayList<Integer>> graph, HashSet<Integer> visited, Integer node){
        visited.add(node);

        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(node, -1));

        while(!q.isEmpty()){
            Pair pair = q.remove();
            int curr = pair.node;
            int parent = pair.parent;

            for(int neighbour: graph.get(curr)){
                if(!visited.contains(neighbour)){
                    visited.add(neighbour);
                    q.add(new Pair(neighbour, curr));

                }
                else if(neighbour != parent){
                    return true;
                }
            }
        }
        return false;
    }
    public static boolean findloop(HashMap<Integer, ArrayList<Integer>> graph){
        HashSet<Integer> visited = new HashSet<>();

        for(Integer node: graph.keySet()){
            if(!visited.contains(node)){
                if(explore(graph, visited, node)){
                    return true;
                }
            }
        }
        return false;
    }
    public static void main(String[] args){
        CreateGraph<Integer> c = new CreateGraph<>();
        Integer[] nodes = {1, 2, 3, 5, 6, 11, 12};
        HashMap<Integer, ArrayList<Integer>> graph = c.generateAdjList(nodes, nodes.length);

        graph.get(1).add(2);

        graph.get(2).add(1);
        graph.get(2).add(3);

        graph.get(3).add(2);


//        graph.get(4).add(5);

        graph.get(5).add(6);
        graph.get(5).add(11);
//        graph.get(5).add(7);

        graph.get(6).add(5);
//        graph.get(6).add(8);

//        graph.get(7).add(5);
//        graph.get(7).add(8);

//        graph.get(8).add(6);
//        graph.get(8).add(7);
        graph.get(11).add(5);
        graph.get(11).add(12);

        graph.get(12).add(11);

        System.out.println(findloop(graph));
    }
}

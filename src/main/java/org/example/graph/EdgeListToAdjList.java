package org.example.graph;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
//import com.dsa.graph.DfsBfs.*;

public class EdgeListToAdjList{
    public static void main(String[] args){
        // Creating an edge list

        ArrayList<ArrayList<Character>> edge_list = new ArrayList<>();
        edge_list.add(new ArrayList<>());
        edge_list.add(new ArrayList<>());
        edge_list.add(new ArrayList<>());
        edge_list.add(new ArrayList<>());
        edge_list.add(new ArrayList<>());

        edge_list.get(0).add('i');
        edge_list.get(0).add('j');

        edge_list.get(1).add('k');
        edge_list.get(1).add('i');

        edge_list.get(2).add('m');
        edge_list.get(2).add('k');

        edge_list.get(3).add('k');
        edge_list.get(3).add('l');

        edge_list.get(4).add('o');
        edge_list.get(4).add('n');
        System.out.println("\nEdge List");
        for(ArrayList<Character> temp : edge_list){
            System.out.print("[");
            for(Character x: temp){
                System.out.print(x+",");
            }
            System.out.print("]");

            System.out.println();
        }


        Map<Character, ArrayList<Character>> adj_list = new HashMap<>();

        for(ArrayList<Character> edges : edge_list){
            Character a = edges.get(0);
            Character b = edges.get(1);

            if(!adj_list.containsKey(a)){
                adj_list.put(a, new ArrayList<>());
            }
            if(!adj_list.containsKey(b)){
                adj_list.put(b, new ArrayList<>());
            }

            adj_list.get(a).add(b);
            adj_list.get(b).add(a);
        }

        System.out.println("\nAdjacency List");
        for(Character key : adj_list.keySet()){
            System.out.print(key + "->");
            for(Character k : adj_list.get(key)){
                System.out.print(k +", ");
            }
            System.out.println();
        }

    }

}

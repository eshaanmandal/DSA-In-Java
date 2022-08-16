package org.example.graph;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

class Node{
    int value;
    int weight;

    Node(int _value, int _weight){
        this.value = _value;
        this.weight = _weight;
    }
    int getValue(){
        return this.weight;
    }
}
public class DijkstrasAlgo {
    public int[] shortestPath(int s, List<List<Node1>> adj, int n){
        PriorityQueue<Node1> pq  = new PriorityQueue<>((o1, o2) -> o1.weight - o2.weight);

        int[] dist = new int[n];
        for(int i=0; i<n; i++) dist[i] = Integer.MAX_VALUE;

        dist[s] = 0;

        pq.add(new Node1(s, 0));

        while(!pq.isEmpty()){
            Node1 node1 = pq.poll();

            for(Node1 it: adj.get(node1.value)){
                if(dist[node1.value] + it.weight < dist[it.value]){
                    dist[it.value] = dist[node1.value] + it.weight;
                    pq.add(new Node1(it.value, dist[it.value]));
                }
            }
        }

        return dist;
    }

    public static void main(String[] args){
        int n = 5;

        List<List<Node1>> adj = new ArrayList<>();

        for(int i=0; i<n; i++){
            adj.add(new ArrayList<>());
        }

        adj.get(0).add(new Node1(1,2));
        adj.get(1).add(new Node1(0,2));

        adj.get(1).add(new Node1(2,4));
        adj.get(2).add(new Node1(1,4));

        adj.get(0).add(new Node1(3,1));
        adj.get(3).add(new Node1(0,1));

        adj.get(3).add(new Node1(2,3));
        adj.get(2).add(new Node1(3,3));

        adj.get(1).add(new Node1(4,5));
        adj.get(4).add(new Node1(1,5));

        adj.get(2).add(new Node1(4,1));
        adj.get(4).add(new Node1(2,1));

        DijkstrasAlgo obj = new DijkstrasAlgo();

        int[] dist = obj.shortestPath(0, adj, n);

        for(int x : dist){
            if(x == Integer.MAX_VALUE)
                System.out.print("INF ");
            else
                System.out.print(x + " ");

        }
    }
}

package org.example.graph;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

class Node1{
    public int value;
    public int weight;

    Node1(int _v, int _w){
        this.value = _v;
        this.weight = _w;
    }
}
public class PrimsAlgo {
    public int[] minimumSpanningTree(List<List<Node1>> adj, int n){
        int key[] = new int[n];
        int parent[] = new int[n];
        boolean mstSet[] = new boolean[n];

        for(int i = 0; i<n; i++) {
            key[i] = Integer.MAX_VALUE;
            mstSet[i] = false;
        }

        PriorityQueue<Node1> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o.weight));

        key[0] = 0;
        parent[0] = -1;
        pq.add(new Node1(key[0], 0));

        while(!pq.isEmpty()){
            int u = pq.poll().value;

            mstSet[u] = true;

            for(Node1 it: adj.get(u)){
                if(!mstSet[it.value] && it.weight < key[it.value]){
                    pq.add(new Node1(it.value, it.weight));
                    key[it.value] = it.weight;
                    parent[it.value] = u;
                }
            }
        }

        return parent;

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

        PrimsAlgo obj = new PrimsAlgo();

        int[] parent = obj.minimumSpanningTree(adj, n);

        for(int i=1; i<n; i++){
            System.out.print(parent[i] + "-");
        }


    }
}

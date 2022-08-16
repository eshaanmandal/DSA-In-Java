package org.example.graph;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

class NodeWeightPair{
    private int value;
    private int weight;

    NodeWeightPair(int _v, int _w){
        this.value = _v;
        this.weight = _w;
    }
    public int getWeight(){
        return this.weight;
    }
    public int getValue(){
        return this.value;
    }
}
public class practicePrim {
    public int[] mst(List<List<NodeWeightPair>> adj, int N){
        int[] parent = new int[N];
        boolean[] ispartofMST = new boolean[N];
        int[] key = new int[N];

        for(int i=0; i<N; i++){
            parent[i] = -1;
            key[i] = Integer.MAX_VALUE;
        }

        ispartofMST[0] = true;
        key[0] = 0;

        Queue<NodeWeightPair> pq = new PriorityQueue<>((o1,o2) -> (o1.getWeight() - o2.getWeight()));
        pq.add(new NodeWeightPair(0, 0));

        while(!pq.isEmpty()){
            int node = pq.poll().getValue();
            ispartofMST[node] = true;

            for(NodeWeightPair neigh: adj.get(node)){
//                System.out.println(neigh.getValue());
                if(!ispartofMST[neigh.getValue()] && neigh.getWeight() < key[neigh.getValue()]){
                    key[neigh.getValue()] = neigh.getWeight();
                    parent[neigh.getValue()] = node;
                    pq.add(new NodeWeightPair(neigh.getValue(), neigh.getWeight()));
                }
            }

        }
        return parent;
    }
    
    public static void main(String[] args){
        List<List<NodeWeightPair>> adj = new ArrayList<>();
        int N = 5;

        for(int i=0; i<N; i++)
            adj.add(new ArrayList<>());

        adj.get(0).add(new NodeWeightPair(1,2));
        adj.get(0).add(new NodeWeightPair(3,6));

        adj.get(1).add(new NodeWeightPair(0,2));
        adj.get(1).add(new NodeWeightPair(4,5));
        adj.get(1).add(new NodeWeightPair(2,3));

        adj.get(2).add(new NodeWeightPair(1,3));
        adj.get(2).add(new NodeWeightPair(4,2));

        adj.get(3).add(new NodeWeightPair(0,6));
        adj.get(3).add(new NodeWeightPair(1,8));

        adj.get(4).add(new NodeWeightPair(1,5));
        adj.get(4).add(new NodeWeightPair(2,2));

        practicePrim p = new practicePrim();

        int[] parents = p.mst(adj, N);

        for(int x: parents){
            if(x != -1)
                System.out.println(x);
        }
    }
}

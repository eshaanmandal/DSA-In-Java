package org.example.graph;


public class UnionFind {
    static int[] rank = new int[1000];
    static int[] parent  = new int[1000];

    public static int findParent(int node){
        if(node == parent[node])
            return node;
        return parent[node] = findParent(parent[node]);
    }
    public static void union(int u, int v){
        u = findParent(u);
        v = findParent(v);

        if(u == v)
            return;

        if(rank[u] > rank[v]){
            parent[v] = u;
        }
        else if(rank[u] < rank[v]){
            parent[u] = v;
        }
        else{
            parent[v] = u;
            rank[u]++;
        }
    }

    public static void initialise(){
        for(int i=0; i<1000; i++){
            rank[i] = 1;
            parent[i] = i;
        }
    }
    public static void main(String[] args){
        initialise();
        union(2,3);
        union(5,6);
        System.out.println(findParent(3));
        System.out.println(findParent(6));

        union(3,6);
        System.out.println(findParent(5));
    }
}

package org.example.codingexams;

import java.util.*;


public class VaccinationDrive {

    static class Pair{
        int first;
        int second;

        Pair(int f, int s){
            this.first = f;
            this.second = s;
        }
    }
    public static int findMinTime(int n, int[] from, int[] to, int[] status){
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0; i<from.length+1; i++){
            adj.add(new ArrayList<>());
        }
        for(int i=0; i<from.length; i++){
            int f=from[i],t=to[i];
            adj.get(f).add(t);
            adj.get(t).add(f);
        }



        int[] visited = new int[n+10];

        int ans = 0;
        Queue<Pair> q = new LinkedList<>();

        for(int i=0; i<status.length; i++){
            if(status[i] == 3)
                q.add(new Pair(i+1, 0));
        }

        while(!q.isEmpty()){
            Pair x = q.poll();

            if(visited[x.first] == 1){
                continue;
            }
            visited[x.first] = 1;
            if(status[x.first-1] == 1){
                ans = Math.max(ans, x.second);
            }

            for(int j: adj.get(x.first)){
                if(visited[j] == 0){
                    q.add(new Pair(j,x.second+1));
                }
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        int[] center_to = {2, 3, 4, 5, 6, 1};
        int[] center_from = {1, 2, 3, 4, 5, 6};

        int[] status_ = {3,2,1,2,1,2};



        System.out.println(findMinTime(5,center_from,center_to,status_));
    }
}

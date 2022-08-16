package org.example.hashing;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
public class SumFour {
    public static class Pair {
        int first, sec;

        public Pair(int first, int sec)
        {
            this.first = first;
            this.sec = sec;
        }
    }
    public static void main(String[] args){
        int arr[] = { 10, 20, 30, 40, 1, 2 };
        int n = arr.length;
        int[] fourPair = new int[4];
        Map<Integer, ArrayList<Pair>> map = new HashMap<>();

        for(int i=0; i<n-1; i++){
            for(int j=i+1; j<n; j++){
                int sum = arr[i] + arr[j];

                if(map.containsKey(sum)){
                    map.get(sum).add(new Pair(i,j));
                }
                else{
                    ArrayList<Pair> temp = new ArrayList<>();
                    temp.add(new Pair(i,j));
                    map.put(sum, temp);
                }
            }
        }

        for(int key: map.keySet()){
            System.out.print(key+"\t");

            for(int i=0; i<map.get(key).size(); i++){
                System.out.print("{"+map.get(key).get(i).first+", "+map.get(key).get(i).sec+"}" + " ");
            }

            System.out.println();
        }

        System.out.println(map.keySet().size());

    }
}

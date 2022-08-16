package org.example.hashing;

import java.util.SortedMap;
import java.util.TreeMap;

public class treeMap {
    public static void main(String[] args){
        SortedMap<Integer, Integer> m = new TreeMap<>();
        int[] ans = {3,5,7,9,90};
        for(int i=0; i<5; i++){
            m.put(i, ans[i]);
        }
        m.put(-2, 45);
        for(int key: m.keySet()){
            System.out.print(key + " " + m.get(key) + "\n");
        }
    }
}

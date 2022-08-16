package org.example.hashing;//package com.dsa.hashing;

import java.util.SortedMap;
import java.util.TreeMap;
public class SortedMaps{
    public static void main(String[] args){
        int[] A1 = {2, 1, 2, 5, 7, 1, 9, 3, 6, 8, 8};
        int[] A2 = {2, 1, 8, 3};
        

        SortedMap<Integer, Integer> map = new TreeMap<>();

        for(int i : A1){
            map.put(i,map.getOrDefault(i,0)+1);
        }

        int index = 0; //start from the first index

        for(int j : A2){
            int count = map.get(j);
            while(count-- > 0){
                A1[index++] = j;
            }

            map.remove(j);
        }

        for(int j:map.keySet()){
            int count = (Integer)map.get(j);
            while(count-- > 0){
                A1[index++] = j;
            }
        }

        for(int m:A1){
            System.out.print(m + " ");
        }
    }
}

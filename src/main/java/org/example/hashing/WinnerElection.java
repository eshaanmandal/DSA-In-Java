package org.example.hashing;/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
//package com.dsa.hashing;

/**
 *
 * @author eye-of-horus
 */
// { Driver Code Starts

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class WinnerElection
{
    public static void main (String[] args)
    {
        
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            int n = sc.nextInt();
            String arr[] = new String[n];
            
            for(int i = 0; i < n; i++)
                arr[i] = sc.next();
            
            WinnerElectionSolution obj = new WinnerElectionSolution();    
            String result[] = obj.winner(arr, n);
            System.out.println(result[0] + " " + result[1]);
            
           
        }
        
    }
}
// } Driver Code Ends


//User function Template for Java


class WinnerElectionSolution
{
    //Function to return the name of candidate that received maximum votes.
    public static String[] winner(String arr[], int n)
    {
        // SortedMap<String,Integer> candidateMap = new TreeMap<>();
        
        // for(int i=0; i<arr.length; i++){
        //     candidateMap.put(arr[i], candidateMap.getOrDefault(arr[i],0)+1);
        // }
        // String[] result  = new String[2];
        // int max_votes = 0;
        // for(String name : candidateMap.keySet()){
        //     int votes = (Integer)candidateMap.get(name);
        //     if(votes > max_votes){
        //         max_vote = votes;
        //         result[0] = name;
        //         result[1] = Integer.toString(max_votes);
        //     }
        // }
        
        // return result;
        
        Map<String, Integer> cMap = new HashMap<>();
        for(String name : arr){
            cMap.put(name, cMap.getOrDefault(name,0)+1);
        }
        
        String[] res = new String[2];
        String c_name ="";
        String c_vote ="";
        int max_votes = 0;
        
        for(String name: cMap.keySet()){
            int votes = cMap.get(name);
            
            if(votes > max_votes){
                max_votes = votes;
                c_name = name;
                c_vote = Integer.toString(max_votes);
            }
            else if(votes == max_votes && c_name.compareTo(name) > 0){
                c_name = name;
            }
        }
        
        res[0] = c_name;
        res[1] = c_vote;
        
        return res;
    }
}


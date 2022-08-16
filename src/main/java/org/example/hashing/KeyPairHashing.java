/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.example.hashing;

/**
 *
 * @author eye-of-horus
 */
// { Driver Code Starts
//Initial Template for Java


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class KeyPairHashing {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine().trim());
        while (tc-- > 0) {
            String[] inputLine;
            inputLine = br.readLine().trim().split(" ");
            int n = Integer.parseInt(inputLine[0]);
            int x = Integer.parseInt(inputLine[1]);
            int[] arr = new int[n];
            inputLine = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(inputLine[i]);
            }

            boolean ans = new KeyPairHashingSolution().hasArrayTwoCandidates(arr, n, x);
            System.out.println(ans ? "Yes" : "No");
        }
    }
}
// } Driver Code Ends


//User function Template for Java


class KeyPairHashingSolution {
    boolean hasArrayTwoCandidates(int arr[], int n, int x) {
        Map<Integer, Integer> map = new HashMap<>();
        
        for(int e : arr){
            map.put(e, map.getOrDefault(e,0)+1);
        }
        
        for(int first_element : map.keySet()){
            
            
            int second_element = x - first_element;
            
            if(map.containsKey(second_element)){
                if(first_element == second_element && map.get(second_element) > 1){
                    return true;
                }
                else if(first_element != second_element){
                    return true;
                }
                else{
                    return false;
                }
            }
        }
        
        return false;
        
        
        
    }
}

package org.example.hashing;

// { Driver Code Starts
//Initial Template for Java

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

class PositiveNegativePairs {
	public static void main(String[] args) throws IOException
	{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim()); // Inputting the testcases
        while(t-->0)
        {
            long n = Long.parseLong(br.readLine().trim());
            long a[] = new long[(int)(n)];
            
            String inputLine[] = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                a[i] = Long.parseLong(inputLine[i]);
            }
            
            PositiveNegativePairsSolution obj = new PositiveNegativePairsSolution();
            long answer[] = obj.PosNegPair(a, n);
            int sz = answer.length;
            
            if(sz==0)
            System.out.println(0);
            
            else{
                StringBuilder output = new StringBuilder();
                for(int i=0;i<sz;i++)
                output.append(answer[i]+" ");
                System.out.println(output);
            }
            
        }
	}
}

// } Driver Code Ends


//User function Template for Java


class PositiveNegativePairsSolution {
    
    public long[] PosNegPair(long a[], long n){
        ArrayList<Long> res = new ArrayList<>();
        Map<Long,Integer> positive = new HashMap<>();
        Map<Long,Integer> negative = new HashMap<>();
        
        for(int i=0; i<n; i++){
            if(a[i] < 0){
                negative.put(a[i],negative.getOrDefault(a[i],0)+1);
            }
            else{
                positive.put(a[i],positive.getOrDefault(a[i],0)+1);
            }
        }
        for(long key: positive.keySet()){
            int value = positive.get(key);
            
            if(negative.containsKey(-key)){
                int neg_value = negative.get(-key);
                int count = 2*Math.min(value, neg_value);
                while(count-- > 0){
                    res.add(key);
                }
            }
        }
        long[] result = new long[res.size()];
        for(int i=0; i<res.size(); i++){
            result[i] = res.get(i);
        }
        
        Arrays.sort(result);
        
        for(int i=0; i<result.length; i+=2){
            result[i] = -1 * result[i];
        }
        
        return result;
        
    }
}

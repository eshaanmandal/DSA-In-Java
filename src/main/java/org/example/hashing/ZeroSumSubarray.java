package org.example.hashing;

// { Driver Code Starts

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;


public class ZeroSumSubarray {
	public static void main (String[] args) {
		//code
			//code
			
		//taking input using class Scanner
		Scanner scan = new Scanner(System.in);
		
		//taking total number of testcases
		int t = scan.nextInt();
		while(t>0)
		{
		    //taking total count of elements
		    int n = scan.nextInt() ;
		    
		    //Declaring and Initializing an array of size n
		    int arr[] = new int[n];
		    
		    //adding elements to the array
		    for(int i = 0; i<n;i++)
		    {
		        arr[i] = scan.nextInt();
		    }
		    
		    t--;
		    
		     //calling the method findSum
		     //and print "YES" or "NO" based on the result
		     System.out.println(new Solution().findsum(arr,n)==true?"Yes":"No");
		}
	}
	
	
}// } Driver Code Ends


class Solution{
    //Function to check whether there is a subarray present with 0-sum or not.
    static boolean findsum(int arr[],int n)
    {
        int[] psa = new int[n];
        
        psa[0] = arr[0];
        
        for(int i=1; i<n; i++){
            psa[i] = arr[i] + psa[i-1];
        }
        
        Set<Integer> set = new HashSet<>();
        
        for(int i=0; i<n; i++){
            
            if(psa[i] == 0){
                return true;
            }
            
            if(!set.isEmpty() && set.contains(psa[i])){
                return true;
            }
            
            set.add(psa[i]);
        }
        
        return false;
    }
}

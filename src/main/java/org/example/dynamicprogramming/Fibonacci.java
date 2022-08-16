package org.example.dynamicprogramming;
import java.util.Arrays;
class Fibonacci{

   static long[] memo;

   public static void main(String[] args){
       int n = 50;
       memo = new long[n+1];
       Arrays.fill(memo, -1);
       System.out.println(fibo(n));
   }
   static long fibo(int n){
       if(n <= 1){
           return 1;
       }
       if(memo[n] != -1){
           return memo[n];
       }

       return memo[n] = fibo(n-1) + fibo(n-2);
   }
}

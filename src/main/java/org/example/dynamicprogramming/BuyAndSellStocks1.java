package org.example.dynamicprogramming;

public class BuyAndSellStocks1 {
    public static int maxProfit(int[] prices) {
        int min_val = prices[0];
        int max_profit = 0;
        for(int i=1; i<prices.length; i++) {
            int profit = prices[i] - min_val;
            max_profit = Math.max(max_profit, profit);
            min_val = Math.min(prices[i], min_val);
        }

        return max_profit;
    }
    public static void main(String[] args) {
//        System.out.println("Hello World");
        int[] prices = {5, 1, 7, 10, 2, 3};
        System.out.println(maxProfit(prices));
    }
}

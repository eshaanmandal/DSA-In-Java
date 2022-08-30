package org.example.codingexams;
import java.util.*;
import java.util.stream.IntStream;

public class CustomerCisco {
    static class Trip{
        int c;
        int penalty;
        int pref;

        Trip(int c, int p, int pre){
            this.c = c;
            this.penalty = p;
            this.pref = pre;
        }
    }
    static int totalCustomerPenalties(List<Integer> InitialAsk) {
        int n = InitialAsk.get(0);
        Queue<Trip> q = new LinkedList<>();

        for(int i=1; i<n+1; i++){
            q.add(new Trip(i, 0, InitialAsk.get(i)));
        }


        // O(N)
        int[] seats = new int[n+1];
        int total_revenue = 0;
        while(!q.isEmpty()) {
            Trip obj = q.poll();
            int cust = obj.c;
            int penalty = obj.penalty;
            int pref = obj.pref;
//            System.out.println(cust + " " + penalty + " " + pref);

            if(seats[pref] == 0){
                seats[pref] = 1;
            }
            else{
                total_revenue += (penalty+10);
//                System.out.println(total_revenue);
                q.add(new Trip(cust, penalty+10, pref+1));
            }
        }

        return total_revenue;

    }
    public static void main(String[] args){
        List<Integer> l = new ArrayList<>();
        l.add(3);
        l.add(1);
        l.add(1);
        l.add(1);


        System.out.println(totalCustomerPenalties(l));


    }
}

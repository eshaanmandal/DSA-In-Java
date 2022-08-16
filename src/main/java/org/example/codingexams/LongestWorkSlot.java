package org.example.codingexams;

import java.util.*;

class Pair{
    int staff;
    int slot;
    Pair(int s, int sl){
        this.staff = s;
        this.slot = sl;
    }
}
public class LongestWorkSlot {
    static String helper = "abcdefghijklmnopqrstuvwxyz";
    public static char findLongestSingleSlot(List<List<Integer>> leaveTimes){

        Map<Integer, Integer> map = new HashMap<>();
        PriorityQueue<Pair> pq = new PriorityQueue<Pair>((o1,o2)->(o2.slot-o1.slot));
        int curr_time = 0;
//        int longest = 0;

        for(List<Integer> leaveTime: leaveTimes){
            int timeslot = leaveTime.get(1) - curr_time;
            map.put(leaveTime.get(0), map.getOrDefault(leaveTime.get(0) + timeslot, timeslot));
            pq.add(new Pair(leaveTime.get(0), map.get(leaveTime.get(0))));
            curr_time = leaveTime.get(1);
        }

         Pair p = pq.poll();


        return helper.charAt(p.staff);
    }
    public static void main(String[] args){
        List<List<Integer>> x = new ArrayList<>();

        x.add(Arrays.asList(0,1));
        x.add(Arrays.asList(0,3));
        x.add(Arrays.asList(4,5));
        x.add(Arrays.asList(5,6));
        x.add(Arrays.asList(4,10));


        char z = findLongestSingleSlot(x);
        System.out.print(z);
     }
}

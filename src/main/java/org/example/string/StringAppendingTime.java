package org.example.string;

public class StringAppendingTime {
    public static void main(String[] args){
        StringBuilder s = new StringBuilder("");

        int n = 10000;
        long startTime = System.currentTimeMillis();
        for(int i=0; i<=n; i++){
            s.append(i);
        }

        long endTime = System.currentTimeMillis();

        System.out.println(endTime-startTime);


    }
}

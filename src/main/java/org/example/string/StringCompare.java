package org.example.string;

public class StringCompare {
    public static void main(String[] args){
        String s = "Eshaan";
        String s1 = "Eshaan";
        String s2 = new String("Eshaan");

        if(s.equals(s2))
            System.out.println("true");
        else
            System.out.println("false");
    }
}

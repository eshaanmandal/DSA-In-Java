package org.example.backtracking_recursion;

public class StringPerm {
    public static void printPerm(String s, String perm){
        if(s.length() == 0){
            System.out.println(perm);
            return;
        }
        for(int i=0; i<s.length(); i++){
            char x = s.charAt(i);
            String left = s.substring(0,i);
            String right = s.substring(i+1);

            String remaining = left + right;
            printPerm(remaining, perm + x);
        }


    }
    public static void main(String[] args){
        String s = "abba";
        printPerm(s, "");
    }
}

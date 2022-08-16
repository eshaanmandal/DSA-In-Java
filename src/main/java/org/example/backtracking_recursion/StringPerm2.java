package org.example.backtracking_recursion;

import java.util.ArrayList;

public class StringPerm2 {
    static ArrayList<String> findPermutation(String s){
        // base case
        if(s.length() == 0){
            ArrayList<String> bperm = new ArrayList<>();
            bperm.add("");
            return bperm;
        }
        ArrayList<String> res = new ArrayList<>();
        for(int i=0; i<s.length(); i++){
            String curr = s.charAt(i) + "";
            String left = s.substring(0,i);
            String right = s.substring(i+1);

            ArrayList<String> perms= findPermutation(left+right);

            for(String perm: perms){
                res.add(curr + perm);
            }
        }

        return res;
    }
    public static void main(String[] args){
        String s = "abc";

        ArrayList<String> perms = findPermutation(s);

        for(String perm: perms){
            System.out.println(perm);
        }
    }
}

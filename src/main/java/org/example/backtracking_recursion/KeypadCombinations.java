package org.example.backtracking_recursion;

import java.util.ArrayList;
import java.util.Scanner;

public class KeypadCombinations {
    static String[] codes = {".;", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tu", "tu", "vwx", "yz"};
    static ArrayList<String> getCombinations(String s){
        if(s.length() == 0){
            ArrayList<String> rres = new ArrayList<>();
            rres.add("");
            return rres;
        }
        char x = s.charAt(0);
        String rem = s.substring(1);

        ArrayList<String> rres = getCombinations(rem);
        ArrayList<String> mres = new ArrayList<>();

        String curr = codes[Integer.parseInt(x+"")];
        for(int i=0; i< curr.length(); i++){
            char curr_char = curr.charAt(i);
            for(String res: rres){
                mres.add(curr_char + "" +res);
            }
        }

        return mres;

    }
    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);
        String s = scn.nextLine();

        ArrayList<String> final_ans = getCombinations(s);

        for(String each_element : final_ans){
            System.out.println(each_element);
        }

    }
}

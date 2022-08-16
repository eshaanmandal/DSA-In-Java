package org.example.string;

import java.util.ArrayList;
import java.util.HashMap;

public class StringPermutation {

    static ArrayList<String> perms = new ArrayList<>();
    public static void stringperm(int cs, int ts, String s, HashMap<Character, Integer> map){
        if(cs > ts){
            perms.add(s);
            return;
        }
        for(char key: map.keySet()){
            if(map.get(key) > 0){
                map.put(key, map.get(key)-1);
                stringperm(cs+1, ts, s+key, map);
                map.put(key, map.get(key)+1);

            }
        }
    }
    public static void main(String[] args){
        String s = "aabb";
        HashMap<Character,Integer> map = new HashMap<>();

        for(int i=0; i<s.length(); i++){
            char x = s.charAt(i);
            map.put(x, map.getOrDefault(x,0)+1);
        }
        stringperm(1,4,"",map);

        for (String perm : perms) {
            System.out.println(perm);
        }

    }
}


package org.example.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Stack;

public class Haspath {

    public static boolean hasPath(char source, char dest, HashMap<Character, ArrayList<Character>> adj_list){
        if(source == dest)
            return true;

        Stack<Character> s = new Stack<>();
        s.push(source);
        while(!s.isEmpty()){
            char curr = s.pop();
            if(curr == dest){
                return true;
            }

            for(int i=0; i<adj_list.get(curr).size(); i++){
                s.push(adj_list.get(curr).get(i));
            }
        }

        return false;
    }

    public static void main(String[] args){
        HashMap<Character, ArrayList<Character>> adj_list = new HashMap<>();

        char[] nodes = {'f','g','h','i','j','k'};

        for(char x: nodes){
            adj_list.put(x, new ArrayList<>());
        }

        adj_list.get('f').add('g');
        adj_list.get('f').add('i');
        adj_list.get('g').add('h');
        adj_list.get('i').add('g');
        adj_list.get('i').add('k');
        adj_list.get('j').add('i');

        System.out.println(hasPath('f','j',adj_list));

    }
}

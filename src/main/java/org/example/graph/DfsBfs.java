package org.example.graph;
import java.util.*;


public class DfsBfs {
    public static void dfs(char source, HashMap<Character, ArrayList<Character>> adj_list){
        Stack<Character> s = new Stack<>();
        s.push(source);
        while(!s.isEmpty()){
            char curr = s.pop();
            System.out.print(curr + "->");

            for(int i=0; i<adj_list.get(curr).size(); i++){
                s.push(adj_list.get(curr).get(i));
            }
        }
    }
    public static void bfs(char source, HashMap<Character, ArrayList<Character>> adj_list){
        Queue<Character> q = new LinkedList<>();

        q.add(source);

        while(!q.isEmpty()){
            char curr = q.remove();

            System.out.print(curr + "->");

            q.addAll(adj_list.get(curr));
        }
    }
    public static void main(String[] args){


        Character[] nodes = {'a','b','c','d','e','f'};

        CreateGraph<Character> c = new CreateGraph<>();

        HashMap<Character, ArrayList<Character>> adj_list = c.generateAdjList(nodes, nodes.length);

        // populating the hashmap with values
        adj_list.get('a').add('c');
        adj_list.get('a').add('b');
        adj_list.get('b').add('d');
        adj_list.get('c').add('e');
        adj_list.get('d').add('f');

        System.out.println("DFS traversal");
        dfs('a', adj_list);
        System.out.println();
        System.out.println("BFS traversal");
        bfs('a',adj_list);

    }
}

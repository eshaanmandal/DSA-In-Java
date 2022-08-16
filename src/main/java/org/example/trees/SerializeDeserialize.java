package org.example.trees;

import java.util.LinkedList;
import java.util.Queue;

public class SerializeDeserialize {

    public static String serialize(Node root) {
        StringBuilder s = new StringBuilder();
        if(root == null){
            return s.toString();
        }
        Queue<Node> q = new LinkedList<>();

        q.add(root);

        while(!q.isEmpty()){
            Node curr = q.poll();
            if(curr == null) {
                s.append("N ");
                continue;
            }
            else {
                s.append(String.valueOf(curr.data)+ " ");
            }

            q.add(curr.left);
            q.add(curr.right);



        }

        return s.toString();
    }

    public static void main(String[] args){
        Node root = new Node(1);
//        root.left = new Node(2);
//        root.right = new Node(3);
//        root.right.left = new Node(8);
//        root.right.right = new Node(9);
//        root.left.left = new Node(4);
//        root.left.right = new Node(5);
//        root.left.right.left = new Node(6);
//        root.left.right.right = new Node(7);
        root.left = new Node(2);
        root.left.right = new Node(3);
        root.right = new Node(4);

        String s = serialize(root);

        String[] ans = s.split(" ");

        for(String x: ans){
            System.out.println(x);
        }

    System.out.println((int)Math.pow(2,5));

    }
}

package org.example.trees;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

public class ZigZagTraversal {
    public static void main(String[] args){
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
        root.left.left.left = new Node(8);
        root.left.left.right = new Node(9);
        root.left.right.left = new Node(10);
        root.left.right.right = new Node(11);
        root.right.left.left = new Node(12);
        root.right.left.right = new Node(13);
        root.right.right.left = new Node(14);
        root.right.right.right = new Node(15);

        Queue<Node> q = new LinkedList<>();

        q.add(root);
        int flag = -1;
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        while(!q.isEmpty()){
            int s = q.size();
            ArrayList<Integer> tmp = new ArrayList<>();
            while(s-- > 0){
                Node node = q.poll();
                tmp.add(node.data);

                if(node.left != null){
                    q.add(node.left);
                }
                if(node.right != null){
                    q.add(node.right);
                }
            }
            if(flag == -1){
                res.add(tmp);
            }
            else{
                Collections.reverse(tmp);
                res.add(tmp);
            }
            flag = flag * -1;

        }

        for(ArrayList<Integer> lst: res){
            for(int i:lst){
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }
}

package org.example.trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;


public class BFSTraversal {
    public static void levelordertraversal(Node root, List<List<Integer>> lot){
        Queue<Node> q = new LinkedList<>();
        q.add(root);

        while(!q.isEmpty()){
            int s = q.size();
            List<Integer> tmp = new ArrayList<>();
            while(s-- > 0){
                Node node = q.poll();
                if(node != null) {
                    tmp.add(node.data);

                    if (node.left != null)
                        q.add(node.left);

                    if (node.right != null)
                        q.add(node.right);
                }
            }
            lot.add(tmp);
        }

    }
    public static void main(String[] args){
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
        List<List<Integer>> lot = new ArrayList<>();

        System.out.println("Level Order Traversal");
        levelordertraversal(root, lot);
        for(List<Integer> tmp : lot){
            for(int i=0; i<tmp.size(); i++){
                System.out.print(tmp.get(i) + " ");
            }
            System.out.println();
        }
    }
}

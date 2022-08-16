package org.example.trees;

import java.util.ArrayList;

public class RootToNodePath {
    public boolean getPath(Node root, int dst, ArrayList<Integer> path){
        if(root == null){
            return false;
        }
        path.add(root.data);
        if(root.data == dst){
            return true;
        }
        boolean leftSide = getPath(root.left, dst, path);
        boolean rightSide = getPath(root.right, dst, path);
        if(!leftSide && !rightSide){
            path.remove(path.size()-1);
            return false;
        }
        return true;
    }
    public static void main(String[] args){
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.right.left = new Node(8);
        root.right.right = new Node(9);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.left.right.left = new Node(6);
        root.left.right.right = new Node(7);
        ArrayList<Integer> path = new ArrayList<>();
        RootToNodePath obj = new RootToNodePath();
        if(obj.getPath(root, 9, path)){
            for(int x: path){
                System.out.println(x);
            }

        }
        else{
            System.out.println("No path available");
        }


    }
}

package org.example.trees;

public class MaxTreeHeight {
    public static int maxheight(Node root){
        if(root == null)
            return 0;
        int leftHeight = maxheight(root.left);
        int rightHeight = maxheight(root.right);

        return 1 + Math.max(leftHeight, rightHeight);
    }
    public static void main(String[] args){
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.right.left = new Node(4);
        root.right.left.left = new Node(6);
        root.right.left.left.left = new Node(7);
        root.right.left.left.right = new Node(8);
        root.right.right = new Node(5);

        System.out.println(maxheight(root));
    }
}

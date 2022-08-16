package org.example.trees;

public class EqualTree {
    public static void traverse(Node root, int[] tree, int i){
        if(root == null)
            return;
        traverse(root.left, tree, i+1);
        tree[i] = root.data;
        traverse(root.right, tree, i+1);

    }
    public static void main(String[] args){
        Node root1 = new Node(1);
        root1.left = new Node(2);
        root1.right = new Node(3);

        Node root2 = new Node(1);
        root2.left = new Node(2);
//        root2.right = new Node(3);

        int[] tree1 = new int[3];
        int[] tree2 = new int[3];
        traverse(root1, tree1, 0);
        traverse(root2, tree2, 0);

        for(int i=0; i<3; i++){
            if(tree1[i] != tree2[i]){
                System.out.println("False");
            }
        }

    }
}

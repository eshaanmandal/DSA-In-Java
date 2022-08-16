package org.example.trees;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class ConstructFromPreorderInorder {
    static Node createGraph(int[] inorder, int[] preorder){
        if(inorder.length == 0 || preorder.length == 0){
            return null;
        }
        Map<Integer, Integer> val_to_idx = new HashMap<>();

        for(int i=0; i<inorder.length; i++){
            val_to_idx.put(inorder[i],i);
        }
        Node root = new Node(preorder[0]);
        int pivot = val_to_idx.get(preorder[0]);
        root.left = createGraph(Arrays.copyOfRange(inorder, 0, pivot), Arrays.copyOfRange(preorder, 1, pivot+1));
        root.right = createGraph(Arrays.copyOfRange(inorder, pivot+1, inorder.length), Arrays.copyOfRange(preorder, pivot+1, preorder.length));

        return root;

    }
    static void printTree(Node root){
        if(root == null)
            return;
        System.out.println(root.data);
        printTree(root.left);
        printTree(root.right);
    }
    public static void main(String[] args){
        int[] preorder = {0, 1, 3, 7, 8, 4, 9, 10, 2, 5, 11, 6};
        int[] inorder = {7, 3, 8, 1, 9, 4, 10, 0, 11, 5, 2, 6};
        Map<Integer, Integer> val_to_idx = new HashMap<>();

        for(int i=0; i<inorder.length; i++){
            val_to_idx.put(inorder[i],i);
        }

        Node root = new Node(preorder[0]);
        int pivot = val_to_idx.get(preorder[0]);
        root.left = createGraph(Arrays.copyOfRange(inorder, 0, pivot), Arrays.copyOfRange(preorder, 1, pivot+1));
        root.right = createGraph(Arrays.copyOfRange(inorder, pivot+1, inorder.length), Arrays.copyOfRange(preorder, pivot+1, preorder.length));


        printTree(root);




    }
}

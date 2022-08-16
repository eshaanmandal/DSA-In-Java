package org.example.trees;

public class MaxPathSum {
    public int maxpathsum(Node root, int[] max_path_sum){
        if(root == null)
            return 0;

        int leftSum = maxpathsum(root.left, max_path_sum);
        int rightSum = maxpathsum(root.right, max_path_sum);

        max_path_sum[0] = Math.max(max_path_sum[0], root.data + leftSum + rightSum);

        return root.data + Math.max(leftSum, rightSum);
    }
    public static void main(String[] args){
        Node root = new Node(-10);
        root.left = new Node(9);
        root.right = new Node(20);
        root.right.left = new Node(15);
        root.right.right = new Node(7);

        MaxPathSum obj = new MaxPathSum();

        int max[] = new int[1];

        obj.maxpathsum(root, max);

        System.out.println(max[0]);
    }
}

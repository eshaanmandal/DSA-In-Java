package org.example.trees;

public class TreeDiameter {
    static int max_dia = 0;
    public int findDiameter(Node root){
        if(root == null)
            return 0;
        int leftH = findDiameter(root.left);
        int rightH = findDiameter(root.right);

        max_dia = Math.max(max_dia, leftH + rightH);

        return Math.max(leftH, rightH) + 1;

    }
    public static void main(String[] args){
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);

        TreeDiameter obj = new TreeDiameter();

        obj.findDiameter(root);

        System.out.println(max_dia);

    }
}

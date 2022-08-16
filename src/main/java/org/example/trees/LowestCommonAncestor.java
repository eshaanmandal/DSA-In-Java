package org.example.trees;

public class LowestCommonAncestor {
    public static Node lowestCA(Node root, Node p, Node q){
        if(root == null)
            return null;
        if(root.data == p.data || root.data == q.data){
            return root;
        }
        Node leftSearch = lowestCA(root.left, p, q);
        Node rightSearch = lowestCA(root.right, p, q);

        if(leftSearch == null) return rightSearch;
        if(rightSearch == null) return leftSearch;

        return root;
    }
    public static boolean checkNodeExist(Node root, Node root1){
        if(root == null)
            return false;
        if(root.data == root1.data){
            return true;
        }
        boolean leftCheck = checkNodeExist(root.left, root1);
        boolean rightCheck = checkNodeExist(root.right, root1);

        return leftCheck || rightCheck;
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
        Node p = root.right.left;
        Node q = root.right;
        if(!checkNodeExist(root, p) || !checkNodeExist(root, q)){
            System.out.println("One or both the node(s) is invalid");
        }
        else {
            Node lca = lowestCA(root, p, q);

            System.out.println(lca.data);
        }


    }
}

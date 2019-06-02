package C23BinaryTree;

public class BinaryTree {
    public static class Node{
        int value;
        Node left;
        Node right;
    }

    public static void preOrder(Node root) {
        if(root == null) return;
        System.out.print(root.value);
        preOrder(root.left);
        preOrder(root.right);
    }

    public static void inOrder(Node root) {
        if(root == null) return;
        inOrder(root.left);
        System.out.print(root.value);
        inOrder(root.right);
    }

    public static void postOrder(Node root) {
        if(root == null) return;
        postOrder(root.left);
        postOrder(root.right);
        System.out.print(root.value);
    }
}

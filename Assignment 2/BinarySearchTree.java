// Yoyi Liao, BIT265 Structures and Algorithms, Assignment 2 Part 2

/*
 * prompt I asked ChatGPT:
 * write a java program that would ask for user's input, then draw the binary search tree that would 
 * result if the given elements were added to an empty binary search tree in the given order. 
 * Then write the elements of the tree in the order that they would be visited by each kind of 
 * traversal (preorder, inorder, and postorder).
 */
import java.util.Scanner;

public class BinarySearchTree {
    private static class Node {
        int data;
        Node left;
        Node right;

        public Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    private static Node root;

    public BinarySearchTree() {
        this.root = null;
    }

    public void insert(int data) {
        root = insertRecursive(root, data);
    }

    private Node insertRecursive(Node root, int data) {
        if (root == null) {
            root = new Node(data);
            return root;
        }

        if (data < root.data) {
            root.left = insertRecursive(root.left, data);
        } else if (data > root.data) {
            root.right = insertRecursive(root.right, data);
        }

        return root;
    }

    public void traversePreorder(Node root) {
        if (root != null) {
            System.out.print(root.data + " ");
            traversePreorder(root.left);
            traversePreorder(root.right);
        }
    }

    public void traverseInorder(Node root) {
        if (root != null) {
            traverseInorder(root.left);
            System.out.print(root.data + " ");
            traverseInorder(root.right);
        }
    }

    public void traversePostorder(Node root) {
        if (root != null) {
            traversePostorder(root.left);
            traversePostorder(root.right);
            System.out.print(root.data + " ");
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BinarySearchTree bst = new BinarySearchTree();

        System.out.print("Enter the number of elements: ");
        int n = scanner.nextInt();

        System.out.print("Enter the elements: ");
        for (int i = 0; i < n; i++) {
            bst.insert(scanner.nextInt());
        }

        System.out.print("Preorder Traversal: ");
        bst.traversePreorder(root);
        System.out.println();

        System.out.print("Inorder Traversal: ");
        bst.traverseInorder(root);
        System.out.println();

        System.out.print("Postorder Traversal: ");
        bst.traversePostorder(root);
        System.out.println();
    }
}

/*
 * output:
 * Enter the number of elements: 5
   Enter the elements: 11 4 20 15 7
   Preorder Traversal: 11 4 7 20 15 
   Inorder Traversal: 4 7 11 15 20 
   Postorder Traversal: 7 4 15 20 11  
 */

/*
 * reflection:
 * I'm surprise how fast it took to finish the entire task I asked. I believe it took less than 2 minutes to
 * came up with the entire codes without any bug. Although this is not a very difficult task, I struggled a little 
 * when I first learned about BST and recursion, and I'm glad it help me to not having to deal with recursion
 * nightmare again. However, there's one thing I think it can improve. When asking the user to input values, I
 * don't think it gives a clear instruction about how should input it (should the user separate each input by comma, 
 * space, enter, or whatever). It would be great if it could add a sentence that tells user to separate each input by space. 
 */

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

// Node class
class Node {
    int data;
    Node left, right;

    // Constructor
    Node(int d) {
        data = d;
        left = right = null;
    }
}

// Main class
public class searching {
    // Method for level order traversal
    static void levelOrderTraversal(Node root) {
        if (root == null)
            return;

        Queue<Node> q = new LinkedList<>();
        q.add(root);

        while (!q.isEmpty()) {
            Node temp = q.poll();
            System.out.print(temp.data + " ");

            if (temp.left != null)
                q.add(temp.left);

            if (temp.right != null)
                q.add(temp.right);
        }
    }

   

    // Method to insert into BST
    static Node insertIntoBST(Node root, int d) {
        if (root == null) {
            return new Node(d);
        }

        if (d > root.data) {
            root.right = insertIntoBST(root.right, d);
        } else {
            root.left = insertIntoBST(root.left, d);
        }

        return root;
    }

    // Method to search for a key in BST
    static boolean search(Node root, int key) {
        if (root == null)
            return false;

        if (root.data == key)
            return true;
        else if (key < root.data)
            return search(root.left, key);
        else
            return search(root.right, key);
    }

    // Method to take input and create BST
    static Node takeInput() {
        Scanner sc = new Scanner(System.in);
        Node root = null;
        System.out.println("Enter data to create BST (-1 to stop): ");
        int data = sc.nextInt();
        while (data != -1) {
            root = insertIntoBST(root, data);
            data = sc.nextInt();
        }
        return root;
    }

    // Main method
    public static void main(String[] args) {
        Node root = takeInput();

        System.out.println("Printing the BST (Level Order): ");
        levelOrderTraversal(root);

        Scanner sc = new Scanner(System.in);
        System.out.println("\nEnter key to search in BST: ");
        int key = sc.nextInt();
        if (search(root, key))
            System.out.println(key + " found in BST.");
        else
            System.out.println(key + " not found in BST.");
    }
}

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
public class deletion {
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

    // Method to find minimum value node in subtree
    static Node minValueNode(Node node) {
        Node current = node;
        while (current.left != null) {
            current = current.left;
        }
        return current;
    }

    // Method to delete a node from BST
    static Node deleteNode(Node root, int key) {
        if (root == null)
            return root;

        // If the key to be deleted is smaller than the root's key, then it lies in the left subtree
        if (key < root.data)
            root.left = deleteNode(root.left, key);

        // If the key to be deleted is greater than the root's key, then it lies in the right subtree
        else if (key > root.data)
            root.right = deleteNode(root.right, key);

        // If key is same as root's key, then this is the node to be deleted
        else {
            // Node with only one child or no child
            if (root.left == null)
                return root.right;
            else if (root.right == null)
                return root.left;

            // Node with two children: Get the inorder successor (smallest in the right subtree)
            root.data = minValueNode(root.right).data;

            // Delete the inorder successor
            root.right = deleteNode(root.right, root.data);
        }

        return root;
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
        System.out.println("\nEnter key to delete from BST: ");
        int key = sc.nextInt();
        root = deleteNode(root, key);

        System.out.println("BST after deletion:");
        levelOrderTraversal(root);
    }
}

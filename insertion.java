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
public class insertion {
    // Method for level order traversal
    static void levelOrderTraversal(Node root) {
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        q.add(null);

        while (!q.isEmpty()) {
            Node temp = q.poll();

            if (temp == null) {
                System.out.println();
                if (!q.isEmpty()) {
                    q.add(null);
                }
            } else {
                System.out.print(temp.data + " ");

                if (temp.left != null) {
                    q.add(temp.left);
                }

                if (temp.right != null) {
                    q.add(temp.right);
                }
            }
        }
    }

    // Method for inorder traversal
    static void inorder(Node root) {
        if (root == null) {
            return;
        }

        inorder(root.left);
        System.out.print(root.data + " ");
        inorder(root.right);
    }

    // Method for preorder traversal
    static void preorder(Node root) {
        if (root == null) {
            return;
        }

        System.out.print(root.data + " ");
        preorder(root.left);
        preorder(root.right);
    }

    // Method for postorder traversal
    static void postorder(Node root) {
        if (root == null) {
            return;
        }

        postorder(root.left);
        postorder(root.right);
        System.out.print(root.data + " ");
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

        System.out.println("\nPrinting Inorder: ");
        inorder(root);

        System.out.println("\nPrinting Preorder: ");
        preorder(root);

        System.out.println("\nPrinting Postorder: ");
        postorder(root);
    }
}

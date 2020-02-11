// https://www.geeksforgeeks.org/level-order-tree-traversal/

package BST;

import java.util.Queue;
import java.util.Stack;
import java.util.LinkedList;

/* Class to represent Tree node */
class Node {
    int data;
    Node left, right;

    public Node(int item) {
        data = item;
        left = null;
        right = null;
    }
}

/* Class to print Level Order Traversal */
class BinaryTree {

    Node root;

    /*
     * Given a binary tree. Print its nodes in level order using array for
     * implementing queue
     */
    void printLevelOrder() {

        Queue<Node> queue = new LinkedList<Node>();
        queue.add(root);

        while (!queue.isEmpty()) {

            // poll() removes the present head.

            Node tempNode = queue.poll();
            System.out.print(tempNode.data + " ");

            /* Enqueue left child */
            if (tempNode.left != null) {
                queue.add(tempNode.left);
            }

            /* Enqueue right child */
            if (tempNode.right != null) {
                queue.add(tempNode.right);
            }
        }
    }

    // function to print the level order traversal
    void levelOrderZigZag(Node root, int n) {
        // We can just take the size as H+N which
        // implies the height of the tree with the
        // size of the tree
        Node queue[] = new Node[2 * n];

        for (int i = 0; i < 2 * n; i++)
            queue[i] = new Node(i);

        int top = -1;
        int front = 1;
        queue[++top] = null;
        queue[++top] = root;
        queue[++top] = null;

        // Node t=root;
        int prevFront = 0, count = 1;
        while (true) {

            Node curr = queue[front];

            // A level separator found
            if (curr == null) {

                // If this is the only item in dequeue
                if (front == top)
                    break;

                // Else print contents of previous level
                // according to count
                else {
                    if (count % 2 == 0) {
                        for (int i = prevFront + 1; i < front; i++)
                            System.out.printf("%d ", queue[i].data);
                    } else {
                        for (int i = front - 1; i > prevFront; i--)
                            System.out.printf("%d ", queue[i].data);
                    }

                    prevFront = front;
                    count++;
                    front++;

                    // Insert a new level separator
                    queue[++top] = null;

                    continue;
                }
            }

            if (curr.left != null)
                queue[++top] = curr.left;
            if (curr.right != null)
                queue[++top] = curr.right;
            front++;
        }

        if (count % 2 == 0) {
            for (int i = prevFront + 1; i < top; i++)
                System.out.printf("%d ", queue[i].data);
        } else {
            for (int i = top - 1; i > prevFront; i--)
                System.out.printf("%d ", queue[i].data);
        }
    }

    void printSpiral(Node node) 
    { 
        if (node == null) 
            return; // NULL check 
  
        // Create two stacks to store alternate levels 
        // For levels to be printed from right to left 
        Stack<Node> s1 = new Stack<Node>();  
        // For levels to be printed from left to right 
        Stack<Node> s2 = new Stack<Node>();  
  
        // Push first level to first stack 's1' 
        s1.push(node); 
  
        // Keep printing while any of the stacks has some nodes 
        while (!s1.empty() || !s2.empty()) { 
            // Print nodes of current level from s1 and push nodes of 
            // next level to s2 
            while (!s1.empty()) { 
                Node temp = s1.peek(); 
                s1.pop(); 
                System.out.print(temp.data + " "); 
  
                // Note that is right is pushed before left 
                if (temp.right != null) 
                    s2.push(temp.right); 
  
                if (temp.left != null) 
                    s2.push(temp.left); 
            } 
  
            // Print nodes of current level from s2 and push nodes of 
            // next level to s1 
            while (!s2.empty()) { 
                Node temp = s2.peek(); 
                s2.pop(); 
                System.out.print(temp.data + " "); 
  
                // Note that is left is pushed before right 
                if (temp.left != null) 
                    s1.push(temp.left); 
                if (temp.right != null) 
                    s1.push(temp.right); 
            } 
        } 
    } 

    public static void main(String args[]) {

        BinaryTree tree_level = new BinaryTree();

        tree_level.root = new Node(1);
        tree_level.root.left = new Node(2);
        tree_level.root.right = new Node(3);
        tree_level.root.left.left = new Node(4);
        tree_level.root.left.right = new Node(5);

        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(7);
        root.left.right = new Node(6);
        root.right.left = new Node(5);
        root.right.right = new Node(4);

        System.out.println("Level order zigzag traversal of binary tree is - ");
        tree_level.levelOrderZigZag(root, 7);

        System.out.println("Level order traversal of binary tree is - ");
        tree_level.printLevelOrder();

        System.out.println("Spiral traversal of binary tree is - ");
        tree_level.printSpiral(root);
    }
}

package datastructures.binaryTree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * @author rams0516
 *         Date: 5/24/2017
 *         Time: 1:06 PM
 */
public class TreeImpl {
    Node root = new Node(10);
    Node one = new Node(8);
    Node two = new Node(2);
    Node three = new Node(3);
    Node four = new Node(5);
    Node five = new Node(2);

    public void create() {
        root.setLeftChild(one);
        root.setRightChild(two);
        one.setLeftChild(three);
        one.setRightChild(four);
        two.setLeftChild(five);
    }

    /**
     * Tree traversal is broadly of two types
     * Depth First Search (DFS)
     * Breadth First Search (BFS)
     * DFS is of three types
     * Pre order, In Order, Post Order
     * BFS is of one type, level order traversal
     */

    /**
     * Pre order traversal of tree
     * Time complexity O(n)
     * @param root
     */
    public void preOrder(Node root) {
        if(root != null) {
            System.out.println(root.getData());
            preOrder(root.getLeftChild());
            preOrder(root.getRightChild());
        }
    }

    /**
     * In order traversal of tree
     * Time Complexity O(n)
     * @param root
     */
    public void inOrder(Node root) {
        if(root != null) {
            inOrder(root.getLeftChild());
            System.out.println(root.getData());
            inOrder(root.getRightChild());
        }
    }

    /**
     * Post order traversal of tree
     * Time Complexity O(n)
     * @param root
     */
    public  void postOrder(Node root) {
        if(root != null) {
            postOrder(root.getLeftChild());
            postOrder(root.getRightChild());
            System.out.println(root.getData());
        }
    }

    /**
     * Does the level order traversal of the tree
     * Time Complexity O(n), since every node is visited exactly once
     * @param root
     */
    public void levelOrderTraversal(Node root) {

        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            Node candidate = queue.poll();
            System.out.print(candidate.getData()+"->");
            if(candidate.getLeftChild() != null) {
                queue.add(candidate.getLeftChild());
            }
            if(candidate.getRightChild() != null) {
                queue.add(candidate.getRightChild());
            }
        }
    }

    /**
     * In order traversal of tree without recursion
     * Time complexity O(n)
     * TODO See once more for clarity
     * @param root
     */
    public void inOrderNoRecursion(Node root) {

        Node node = root;
        Stack<Node> stack = new Stack<>();

        //First node to be printed is the left most node
        while (node != null) {
            stack.push(node);
            node = node.getLeftChild();
        }

        while (stack.size() > 0) {
            node = stack.pop();
            System.out.println(node.getData()+"-");
            if(node.getRightChild() != null) {
                node = node.getRightChild();

                while (node != null) {
                    stack.push(node);
                    node = node.getLeftChild();
                }
            }
        }
    }

    /**
     * Prints the level order in reverse, that is from bottom to top
     * Time complexity O(n) since every node is visited exactly once
     * @param root
     */
    public void reverseLevelOrder(Node root) {

        Queue<Node> queue = new LinkedList<>();
        Stack<Node> stack = new Stack<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            Node temp = queue.poll();
            stack.push(temp);
            if(temp.getRightChild() != null) {
                queue.add(temp.getRightChild());
            }
            if(temp.getLeftChild() != null) {
                queue.add(temp.getLeftChild());
            }
        }
        while (!stack.isEmpty()) {
            System.out.print(stack.pop().getData()+"-");
        }
    }

    /**
     * Check if the tree follows the children sum property
     * @param root
     * @return
     */
    public boolean childrenSumProperty(Node root) {
        int leftData = 0;
        int rightData = 0;

        if(root == null ||
                root.getLeftChild() == null &&
                root.getRightChild() == null) {
            return true;
        }

        if(root.getLeftChild() != null) {
            leftData = root.getLeftChild().getData();
        }
        if(root.getRightChild() != null) {
            rightData = root.getRightChild().getData();
        }
        return (root.getData() == leftData + rightData &&
                childrenSumProperty(root.getLeftChild()) &&
                childrenSumProperty(root.getRightChild()));
    }
}
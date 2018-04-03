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

    public  Node create() {

        Node root = new Node(10);
        Node one = new Node(8);
        Node two = new Node(2);
        Node three = new Node(3);
        Node four = new Node(5);
        Node five = new Node(2);

        root.setLeftChild(one);
        root.setRightChild(two);
        one.setLeftChild(three);
        one.setRightChild(four);
        two.setLeftChild(five);
        return root;
    }

    public  Node createDup() {

        Node root = new Node(10);
        Node one = new Node(8);
        Node two = new Node(2);
        Node three = new Node(3);
        Node four = new Node(5);
        Node five = new Node(0);

        root.setLeftChild(one);
        root.setRightChild(two);
        one.setLeftChild(three);
        one.setRightChild(four);
        two.setLeftChild(five);
        return root;
    }

    public Node createTreeWithHalfNodes() {

        Node root = new Node(2);
        Node two = new Node(7);
        Node three = new Node(5);
        Node four = new Node(6);
        Node five = new Node(9);
        Node six = new Node(1);
        Node seven = new Node(2);
        Node eight = new Node(8);

        root.setLeftChild(two);
        root.setRightChild(three);
        two.setRightChild(four);
        three.setRightChild(five);
        four.setLeftChild(six);
        four.setRightChild(seven);
        five.setLeftChild(eight);
        return root;
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

    /** Pre order traversal of tree without recursion
     * Time complexity O(n)
     * @param root
     */
    public void preOrderNoRecursion(Node root) {

    }

    /** Pre order traversal of tree without recursion
     * Time complexity O(n)
     * @param root
     */
    public void postOrderNoRecursion(Node root) {

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
     * Count the number of half Nodes in a binary tree
     * Half node in a tree is a tree which has one child
     * Time complexity : O(n)
     * @param root
     */
    public void countHalfNodes(Node root) {
        int count = 0;
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            Node temp = queue.poll();
            if((temp.getLeftChild() == null && temp.getRightChild() != null) ||
                    temp.getLeftChild() != null && temp.getRightChild() == null) {
                count++;
            }
            if(temp.getLeftChild() != null) {
                queue.add(temp.getLeftChild());
            }
            if(temp.getRightChild() != null) {
                queue.add(temp.getRightChild());
            }
        }
        System.out.println("Count of half nodes = "+count);
    }

    /**
     * Count the number of th leaf nodes in a binary tree, iterative approach
     * Time complexity : O(n)
     * @param root
     */
    public void countLeavesIterative(Node root) {

        int countLeaf = 0;
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            Node temp = queue.poll();
            if (temp.getLeftChild() == null && temp.getRightChild() == null) {
                countLeaf++;
            }
            if(temp.getLeftChild() != null) {
                queue.add(temp.getLeftChild());
            }
            if(temp.getRightChild() != null) {
                queue.add(temp.getRightChild());
            }
        }
        System.out.println("Count of leaf nodes in the tree = "+countLeaf);
    }

    /**
     * Counts the number of full nodes in a binary tree
     * A full node is one which has both left & right child
     * Time complexity : O(n)
     * @param root
     */
    public void countFullNodes(Node root) {

        int fullNodeCount = 0;
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            Node temp = queue.poll();
            if(temp.getLeftChild() != null && temp.getRightChild() != null) {
                fullNodeCount++;
            }
            if(temp.getLeftChild() != null) {
                queue.add(temp.getLeftChild());
            }
            if(temp.getRightChild() != null) {
                queue.add(temp.getRightChild());
            }
        }
        System.out.println("Count of full nodes in the tree = "+fullNodeCount);
    }

    /**
     * Checks whether two binary trees are identical or not
     * Two identical trees have same number of node with data in same order
     * @param treeOne
     * @param treeTwo
     * @return
     */
    public boolean isIdentical(Node treeOne, Node treeTwo) {

        boolean flag = true;
        Queue<Node> queueOne = new LinkedList<>();
        Queue<Node> queueTwo = new LinkedList<>();
        queueOne.add(treeOne);
        queueTwo.add(treeTwo);

        while (!queueOne.isEmpty() && !queueTwo.isEmpty()) {
            Node tempOne = queueOne.poll();
            Node tempTwo = queueTwo.poll();
            if(tempOne.getData() != tempTwo.getData()) {
                flag = false;
                break;
            }
            if(tempOne.getLeftChild() != null) {
                queueOne.add(tempOne.getLeftChild());
            }
            if(tempOne.getRightChild() != null) {
                queueOne.add(tempOne.getRightChild());
            }

            if(tempTwo.getLeftChild() != null) {
                queueTwo.add(tempTwo.getLeftChild());
            }
            if(tempTwo.getRightChild() != null) {
                queueTwo.add(tempTwo.getRightChild());
            }
        }
        if(queueOne.size() != queueTwo.size()) {
            flag = false;
        }
        return flag;
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
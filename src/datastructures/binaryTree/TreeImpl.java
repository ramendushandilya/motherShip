package datastructures.binaryTree;

import java.util.Arrays;
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

        Node cursor = root;
        Stack<Node> stack = new Stack<>();
        stack.push(cursor);

        while (!stack.isEmpty()) {
            cursor = stack.pop();
            System.out.print(cursor.getData()+" - ");

            if(cursor.getRightChild() != null) {
                stack.push(cursor.getRightChild());
            }

            if(cursor.getLeftChild() != null) {
                stack.push(cursor.getLeftChild());
            }
        }
    }

    /** Post order traversal of tree without recursion and using two stacks
     * Time complexity O(n)
     * @param root
     */
    public void postOrderNoRecursionTwoStack(Node root) {

        Stack<Node> one = new Stack<>();
        Stack<Node> two = new Stack<>();
        one.push(root);

        //Traverse the tree in pre order fashion with difference being right subtree is visited before left one
        while (!one.isEmpty()) {

            Node temp = one.pop();
            two.push(temp); //While doing the modified pre order traversal we push elements to stack
            if(temp.getLeftChild() != null) {
                one.push(temp.getLeftChild());
            }
            if(temp.getRightChild() != null) {
                one.push(temp.getRightChild());
            }
        }

        //Pop the second stack and it gives us the post order traversal
        while (!two.isEmpty()) {
            System.out.print(two.pop().getData()+" - ");
        }
    }

    /**
     * Post order traversal of a binary tree without recursion and using one stack
     * TODO Needs revision
     * @param root
     */
    public void postOrderNoRecursionOneStack(Node root) {


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
     * Iterative way to find the height of the tree, use of level order traversal
     * Time complexity O(n)
     *
     * @param root
     */
    public void findHeightIterative(Node root) {

        int height = 0;
        int nodeCount;
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            nodeCount = queue.size();
            if(nodeCount == 0) {
                return;
            } else {
                height++;
            }

            while (nodeCount > 0) {
                Node temp = queue.remove();
                if(temp.getLeftChild() != null) {
                    queue.add(temp.getLeftChild());
                }
                if(temp.getRightChild() != null) {
                    queue.add(temp.getRightChild());
                }
                nodeCount--;
            }
        }
        System.out.println("Height of the tree = "+height);
    }

    /**
     * Get the size of the binary tree
     * Time complexity O(n)
     * @param root
     * @return
     */
    public int getSize(Node root) {

        if(root == null) {
            return 0;
        } else {
            return getSize(root.getLeftChild()) + 1 + getSize(root.getRightChild());
        }
    }

    /**
     * Return the lowest common ancestor of given two nodes in a binary tree
     * TODO
     * @param root
     * @param one
     * @param two
     * @return
     */
    public Node getLca(Node root, int one, int two) {

        if(root == null) {
            return null;
        }

        if(root.getData() == one || root.getData() == two) {
            return root;
        }

        Node left = getLca(root.getLeftChild(), one, two);
        Node right = getLca(root.getRightChild(), one, two);

        if(left != null && right != null) {
            return root;
        }

        if(left == null) {
            return right;
        } else {
            return left;
        }
    }

    /**
     * Count the number of leaf nodes in a binary tree using recursion
     * @param root
     * @return
     */
    public int countLeafRecursive(Node root) {

        if(root == null)
            return 0;
        if(root.getLeftChild() == null && root.getRightChild() == null)
            return 1;
        return countLeafRecursive(root.getLeftChild()) + countLeafRecursive(root.getRightChild());
    }

    /**
     * Find the average of numbers at each level of a binary tree
     * @param root
     */
    public void averageOfLevels(Node root) {

        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            int sizeCache = 0;
            int size = queue.size();
            sizeCache = size;
            int sum = 0;

            while (size > 0) {
                Node temp = queue.remove();
                sum += temp.getData();
                size--;
                if(temp.getLeftChild() != null)
                    queue.add(temp.getLeftChild());
                if(temp.getRightChild() != null)
                    queue.add(temp.getRightChild());
            }
            System.out.println((sum)/sizeCache);
        }
    }

    /**
     * Print all the corner nodes at each level
     * Time complexity O(n), Space complexity O(n)
     * @param root
     */
    public void cornerNodesAtLevel(Node root) {

        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            int sizeCache = size; //Maintains the value of size of the queue for later comparison
            boolean firstCheck = false;

            while (size > 0) {
                Node temp = queue.remove();

                //When the queue contains only one element Just print it, since it's a corner element
                if(sizeCache == 1) {
                    System.out.print(temp.getData() + " - ");
                }

                //When the number of elements in the queue is more than one
                if(sizeCache > 1) {
                    //If the condition is reset then that node is the first node for that level
                    if(firstCheck == false) {
                        System.out.print(temp.getData()+" - ");
                        firstCheck = true;
                    }
                    //If the current queue size is one and the and the cached size is more than one
                    //It means that the current node is the last node in the queue and hence the corner one
                    if(size == 1)
                        System.out.print(temp.getData()+" - ");
                }

                //Usual stuff
                if(temp.getLeftChild() != null)
                    queue.add(temp.getLeftChild());
                if(temp.getRightChild() != null)
                    queue.add(temp.getRightChild());
                size--;
            }
        }
    }

    /**
     * Find the height of the binary tree using recursive way
     * @param root
     * @return
     */
    public int getHeightRecursive(Node root) {

        return root == null ? 0 :
                Math.max(getHeightRecursive(root.getLeftChild()), getHeightRecursive(root.getRightChild())) + 1;
    }

    /**
     * Construct a mirror tree of a binary tree
     * Time complexity O(n), space complexity O(n)
     * @param root
     * @return
     */
    public Node mirrorTree(Node root) {

        if(root == null) {
            return root;
        }

        Node left = mirrorTree(root.getLeftChild());
        Node right = mirrorTree(root.getRightChild());

        root.setLeftChild(right);
        root.setRightChild(left);
        return root;
    }

    /**
     * Find if the two trees are isomorphic or not
     * TODO
     * @param rootOne
     * @param rootTwo
     * @return
     */
    public boolean isIsomorphic(Node rootOne, Node rootTwo) {

        return true;
    }

    /**
     * Print a tree in Spiral form
     * @param root
     */
    public void printSpiral(Node root) {

        Stack<Node> stackOne = new Stack<>();
        Stack<Node> stackTwo = new Stack<>();
        stackOne.push(root);

        while (!stackOne.isEmpty() || !stackTwo.isEmpty()) {

            while (!stackOne.isEmpty()) {
                Node temp = stackOne.pop();
                System.out.print(temp.getData()+" - ");
                if(temp.getLeftChild() != null) {
                    stackTwo.push(temp.getLeftChild());
                }
                if(temp.getRightChild() != null) {
                    stackTwo.push(temp.getRightChild());
                }
            }

            while (!stackTwo.isEmpty()) {
                Node temp = stackTwo.pop();
                System.out.print(temp.getData()+" - ");
                if(temp.getRightChild() != null) {
                    stackOne.push(temp.getRightChild());
                }
                if(temp.getLeftChild() != null) {
                    stackOne.push(temp.getLeftChild());
                }
            }
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
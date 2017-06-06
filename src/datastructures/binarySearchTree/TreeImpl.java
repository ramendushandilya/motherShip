package datastructures.binarySearchTree;

/**
 * @author rams0516
 *         Date: 5/24/2017
 *         Time: 1:21 PM
 *         Binary Search Tree Implementation
 */
public class TreeImpl {
    Node root;

    public  TreeImpl() {
        root = null;
    }

    public void insert(int data) {
        root = insert(root, data);
    }

    /**
     * Insert into binary search tree
     * @param node
     * @param data
     * @return
     */
    private Node insert(Node node, int data) {
        if(node== null) {
            node = new Node(data);
        } else {
            if(data <= node.getData()) {
                node.setLeftChild(insert(node.getLeftChild(), data));
            } else {
                node.setRightChild(insert(node.getRightChild(), data));
            }
        }
        return node;
    }


    public void inOrder(Node root) {
        if(root != null) {
            inOrder(root.getLeftChild());
            System.out.println(root.getData());
            inOrder(root.getRightChild());
        }
    }

    /**
     * Count the number of nodes in the tree
     * @param root
     * @return
     */
    public int count(Node root) {
        if(root == null) return 0;
        return count(root.getLeftChild()) + count(root.getRightChild()) + 1;
    }

    /**
     * Check if two trees are identical or not
     * @param rootOne
     * @param rootTwo
     * @return
     */
    public boolean areIdentical(Node rootOne, Node rootTwo) {
        if(rootOne == null && rootTwo == null) return true;

        if(rootOne != null && rootTwo != null) {
            return (rootOne.getData() == rootTwo.getData() &&
            areIdentical(rootOne.getLeftChild(), rootTwo.getLeftChild()) &&
            areIdentical(rootOne.getRightChild(), rootTwo.getRightChild()));
        }
        return false;
    }

    /**
     * Find depth/height of the tree
     * @param root
     * @return
     */
    public int findHeight(Node root) {
        if(root == null) return 0;
        int left = findHeight(root.getLeftChild());
        int right = findHeight(root.getRightChild());
        if(left > right) {
            return left + 1;
        } else {
            return right + 1;
        }
    }

    /**
     * Delete tree using post order, because before deleting parent we need to delete the children
     * @param root
     */
    public void deleteTree(Node root) {
        if(root == null) return;

        deleteTree(root.getLeftChild());
        deleteTree(root.getRightChild());

        System.out.print("Delete node is = "+root.getData());
        root = null;
    }

    /**
     * Make a mirror of the tree
     * @param root
     */
    public Node mirrorTree(Node root) {
        if(root == null) return root;

        Node left = mirrorTree(root.getLeftChild());
        Node right = mirrorTree(root.getRightChild());

        root.setLeftChild(right);
        root.setRightChild(left);

        return root;
    }

    /**
     * Given two tree traversals can a binary tree be reconstructed
     * Look here http://www.geeksforgeeks.org/if-you-are-given-two-traversal-sequences-can-you-construct-the-binary-tree/
     */


}
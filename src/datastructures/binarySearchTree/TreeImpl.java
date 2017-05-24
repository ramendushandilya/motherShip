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
}
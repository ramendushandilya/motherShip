package datastructures.binaryTree;

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

    public void preOrder(Node root) {
        if(root != null) {
            System.out.println(root.getData());
            preOrder(root.getLeftChild());
            preOrder(root.getRightChild());
        }
    }

    public void inOrder(Node root) {
        if(root != null) {
            inOrder(root.getLeftChild());
            System.out.println(root.getData());
            inOrder(root.getRightChild());
        }
    }

    public  void postOrder(Node root) {
        if(root != null) {
            postOrder(root.getLeftChild());
            postOrder(root.getRightChild());
            System.out.println(root.getData());
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
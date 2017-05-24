package datastructures.binaryTree;

/**
 * @author rams0516
 *         Date: 5/24/2017
 *         Time: 1:06 PM
 */
public class TreeImpl {
    Node root = new Node(15);
    Node one = new Node(16);
    Node two = new Node(17);
    Node three = new Node(18);

    public void create() {
        root.setLeftChild(one);
        root.setRightChild(two);
        one.setLeftChild(three);
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
}
package datastructures.binaryTree;

/**
 * @author rams0516
 *         Date: 5/24/2017
 *         Time: 1:11 PM
 */
public class Runner {
    public static void main(String[] args) {
        TreeImpl tree = new TreeImpl();
        tree.countHalfNodes(tree.createTreeWithHalfNodes());
    }
}
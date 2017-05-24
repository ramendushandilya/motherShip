package datastructures.binarySearchTree;

/**
 * @author rams0516
 *         Date: 5/24/2017
 *         Time: 1:22 PM
 */
public class Runner {
    public static void main(String[] args) {
        TreeImpl tree = new TreeImpl();
        tree.insert(16);
        tree.insert(14);
        tree.insert(7);
        tree.insert(15);
        tree.insert(18);
        tree.insert(17);
        tree.insert(19);

        System.out.print(tree.count(tree.root));
    }
}
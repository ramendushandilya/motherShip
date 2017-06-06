package datastructures.binarySearchTree;

/**
 * @author rams0516
 *         Date: 5/24/2017
 *         Time: 1:22 PM
 */
public class Runner {
    public static final String YES = "Yes";
    public static final String NO = "No";
    public static void main(String[] args) {

        TreeImpl tree = new TreeImpl();
        tree.insert(16);
        tree.insert(14);
        tree.insert(7);
        tree.insert(15);
        tree.insert(18);
        tree.insert(17);
        tree.insert(19);

        TreeImpl treeo = new TreeImpl();
        treeo.insert(16);
        treeo.insert(14);
        treeo.insert(7);
        treeo.insert(15);
        treeo.insert(18);
        treeo.insert(17);
        treeo.insert(0);

        treeo.deleteTree(treeo.root);
    }
}
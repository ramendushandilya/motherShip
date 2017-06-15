package datastructures.binaryTree;

/**
 * @author rams0516
 *         Date: 5/24/2017
 *         Time: 1:11 PM
 */
public class Runner {
    public static void main(String[] args) {
        TreeImpl tree = new TreeImpl();
        tree.create();
        boolean result = tree.childrenSumProperty(tree.root);
        if(result == true) {
            System.out.print("Follows");
        } else {
            System.out.print("Doesn't follow");
        }
    }
}
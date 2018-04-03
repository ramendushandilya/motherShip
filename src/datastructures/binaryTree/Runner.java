package datastructures.binaryTree;

/**
 * @author rams0516
 *         Date: 5/24/2017
 *         Time: 1:11 PM
 */
public class Runner {
    public static void main(String[] args) {
        Node one = new TreeImpl().create();
        Node two = new TreeImpl().createDup();

        boolean flag = new TreeImpl().isIdentical(one, two);
        System.out.println(flag);
    }
}
package datastructures.binaryTree;

/**
 * @author rams0516
 *         Date: 5/24/2017
 *         Time: 1:11 PM
 */
public class Runner {
    public static void main(String[] args) {
        TreeImpl tree = new TreeImpl();
        //tree.cornerNodesAtLevel(tree.create());
        //System.out.println(tree.getHeightRecursive(tree.create()));
        //Node root = tree.create();
        //tree.preOrder(root);
        //System.out.println("\n");
        //Node mirror = tree.mirrorTree(root);
        //System.out.println(mirror.getData());
        //tree.preOrder(tree.mirrorTree(root));
        //tree.postOrderNoRecursionOneStack(tree.create());

        int[] pre = {10,8,3,5,2,2};
        int[] in = {3,8,5,10,2,2};
        TreeImpl.postOrderFromInPre(in, pre, 0, pre.length-1);
    }
}
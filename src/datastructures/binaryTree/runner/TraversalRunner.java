package datastructures.binaryTree.runner;

import datastructures.binaryTree.TraversalsInterface;
import datastructures.binaryTree.commons.Node;
import datastructures.binaryTree.impl.TraversalsImpl;
import datastructures.binaryTree.impl.TreeHelper;

/**
 * @author failedOptimus
 *
 * Normal Tree <= create()
 *          10
 *        /   \
 *       8     2
 *      / \   /
 *     3  5  2
 *
 * Half Nodes Tree <= createTreeWithHalfNodes()
 *
 */

public class TraversalRunner {

    static Node normalTree = new TreeHelper().create();
    static TraversalsInterface traversals = new TraversalsImpl();
    public static void main(String[] args) {

        System.out.println("\nIn Order traversal ::");
        traversals.recursiveInOrder(normalTree);
        System.out.println("\nPre Order traversal ::");
        traversals.recursivePreOrder(normalTree);
        System.out.println("\nPost Order traversal ::");
        traversals.recursivePostOrder(normalTree);
    }
}
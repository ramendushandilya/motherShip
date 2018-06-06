package datastructures.binaryTree;

import datastructures.binaryTree.commons.Node;

/**
 * @author failedOptimus
 * recursiveInOrder => Traverses a binary tree in order using resursive way
 * recursivePreOrder => Traverses a binary tree in pre order using recursive way
 * recursivePostOrder => Traverses a binary tree in post order using recursive way
 */

public interface TraversalsInterface {

    void recursiveInOrder(Node root);
    void recursivePreOrder(Node root);
    void recursivePostOrder(Node root);
}
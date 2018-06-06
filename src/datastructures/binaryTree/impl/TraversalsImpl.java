package datastructures.binaryTree.impl;

import datastructures.binaryTree.commons.Node;
import datastructures.binaryTree.TraversalsInterface;

/**
 * @author failedOptimus
 */

public class TraversalsImpl implements TraversalsInterface{

    @Override
    public void recursiveInOrder(Node root) {

        if(root != null) {
            recursiveInOrder(root.getLeftChild());
            System.out.print(root.getData()+" - ");
            recursiveInOrder(root.getRightChild());
        }
    }

    @Override
    public void recursivePreOrder(Node root) {

        if(root != null) {
            System.out.print(root.getData()+" - ");
            recursivePreOrder(root.getLeftChild());
            recursivePreOrder(root.getRightChild());
        }
    }

    @Override
    public void recursivePostOrder(Node root) {

        if(root != null) {
            recursivePostOrder(root.getLeftChild());
            recursivePostOrder(root.getRightChild());
            System.out.print(root.getData()+" - ");
        }
    }
}
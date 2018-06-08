package datastructures.binaryTree.impl;

import datastructures.binaryTree.commons.Node;
import datastructures.binaryTree.TraversalsInterface;

import java.util.Stack;

/**
 * @author failedOptimus
 * Tree traversal is of two types BFS, DFS
 * DFS is of three tpes, InOrder, PreOrder, PostOrder
 * BFS is of one type, LevelOrder
 */

public class TraversalsImpl implements TraversalsInterface{

    /**
     * Time complexity : O(n)
     * @param root
     */
    @Override
    public void recursiveInOrder(Node root) {

        if(root != null) {
            recursiveInOrder(root.getLeftChild());
            System.out.print(root.getData()+" - ");
            recursiveInOrder(root.getRightChild());
        }
    }

    /**
     * Time complexity : O(n)
     * @param root
     */
    @Override
    public void recursivePreOrder(Node root) {

        if(root != null) {
            System.out.print(root.getData()+" - ");
            recursivePreOrder(root.getLeftChild());
            recursivePreOrder(root.getRightChild());
        }
    }

    /**
     * Time complexity : O(n)
     * @param root
     */
    @Override
    public void recursivePostOrder(Node root) {

        if(root != null) {
            recursivePostOrder(root.getLeftChild());
            recursivePostOrder(root.getRightChild());
            System.out.print(root.getData()+" - ");
        }
    }

    @Override
    public void inorderTraversalNoRecursion(Node root) {

        Node current = root;
        Stack<Node> stack = new Stack<>();

        while (current != null) {
            stack.push(current);
            current = current.getLeftChild();
        }

        while(stack.size() > 0) {
            Node ejected = stack.pop();
            System.out.print(ejected.getData()+" - ");

            if(ejected.getRightChild() != null) {
                Node rightChild = ejected.getRightChild();

                while (rightChild != null) {
                    stack.push(rightChild);
                    rightChild = rightChild.getLeftChild();
                }
            }
        }
    }

    @Override
    public void inorderTraversalNoRecursionNoStack(Node root) {


    }

    @Override
    public void postOrderTraversalFromGivenInorderAndPreorder(Node root) {

    }

    @Override
    public void findAllBinaryTreeFromGivenInorder(Node root) {

    }

    @Override
    public void replaceNodeSumInorderPredecessorSuccessor(Node root) {

    }

    @Override
    public void populateInorderSuccessorAllNodes(Node root) {

    }

    @Override
    public void inorderSuccessorOfNode(Node root) {

    }

    @Override
    public void findNthNodeOfInorderTraversal(Node root) {

    }

    @Override
    public void levelOrderTreeTraversal(Node root) {

    }

    @Override
    public void levelOrderTreeTraversalSpiral(Node root) {

    }

    @Override
    public void leveOrderTraversalLineByLine(Node root) {

    }

    @Override
    public void levelOrderTraversalDirectionChangeEveryTwoLevels(Node root) {

    }

    @Override
    public void reverseLevelOrder(Node root) {

    }

    @Override
    public void reverseTreePath(Node root) {

    }

    @Override
    public void perfectBinaryTreespecificLevelOrder(Node root) {

    }

    @Override
    public void perfectBinaryTreeSpecificLevelOrderAlt(Node root) {

    }

    @Override
    public void reverseAlternateLevelsPerfectBinaryTree(Node root) {

    }

    @Override
    public void morrisTraversalPreorder(Node root) {

    }

    @Override
    public void iterativePreorder(Node root) {

    }

    @Override
    public void iterativePostOrderTwoStacks(Node root) {

    }

    @Override
    public void iterativePostorderOneStack(Node root) {

    }

    @Override
    public void postOrderNoRecursionNoStack(Node root) {

    }

    @Override
    public void diagonalTraversal(Node root) {

    }

    @Override
    public void iterativeDiagonalTraversal(Node root) {

    }

    @Override
    public void boundaryTraversal(Node root) {

    }

    @Override
    public void densityOfBinaryTreeOneTraversal(Node root) {

    }

    @Override
    public void depthFullBinaryTreePreorder(Node root) {

    }

    @Override
    public void findNumberOfBinaryTreesForPreorderSequenceLength(Node root) {

    }

    @Override
    public void modifyBinaryTreeToGetPreorderTraversalUsingRightNodesOnly(Node root) {

    }
}
package datastructures.binaryTree;

import datastructures.binaryTree.commons.Node;

/**
 * Master Source : https://www.geeksforgeeks.org/binary-tree-data-structure/binary-tree-traversal/
 * @author failedOptimus
 * recursiveInOrder => Traverses a binary tree in order using resursive way
 * recursivePreOrder => Traverses a binary tree in pre order using recursive way
 * recursivePostOrder => Traverses a binary tree in post order using recursive way
 */

public interface TraversalsInterface {

    //Recursive Tree Traversals
    /**1*/  void recursiveInOrder(Node root);
    /**1*/  void recursivePreOrder(Node root);
    /**1*/  void recursivePostOrder(Node root);

    /**2*/  void inorderTraversalNoRecursion(Node root);
    /**3*/  void inorderTraversalNoRecursionNoStack(Node root);

    /**4*/  void postOrderTraversalFromGivenInorderAndPreorder(Node root);
    /**5*/  void findAllBinaryTreeFromGivenInorder(Node root);
    /**6*/  void replaceNodeSumInorderPredecessorSuccessor(Node root);
    /**7*/  void populateInorderSuccessorAllNodes(Node root);
    /**8*/  void inorderSuccessorOfNode(Node root);
    /**9*/  void findNthNodeOfInorderTraversal(Node root);

    //Level Order Tree Traversals
    /**10*/ void levelOrderTreeTraversal(Node root);
    /**11*/ void levelOrderTreeTraversalSpiral(Node root);
    /**12*/ void leveOrderTraversalLineByLine(Node root);
    /**13*/ void levelOrderTraversalDirectionChangeEveryTwoLevels(Node root);
    /**14*/ void reverseLevelOrder(Node root);
    /**15*/ void reverseTreePath(Node root);
    /**16*/ void perfectBinaryTreespecificLevelOrder(Node root);
    /**17*/ void perfectBinaryTreeSpecificLevelOrderAlt(Node root);
    /**18*/ void reverseAlternateLevelsPerfectBinaryTree(Node root);
    /**19*/ void morrisTraversalPreorder(Node root);
    /**20*/ void iterativePreorder(Node root);
    /**21*/ void iterativePostOrderTwoStacks(Node root);
    /**22*/ void iterativePostorderOneStack(Node root);
    /**23*/ void postOrderNoRecursionNoStack(Node root);
    /**24*/ void diagonalTraversal(Node root);
    /**25*/ void iterativeDiagonalTraversal(Node root);
    /**26*/ void boundaryTraversal(Node root);
    /**27*/ void densityOfBinaryTreeOneTraversal(Node root);
    /**28*/ void depthFullBinaryTreePreorder(Node root);
    /**29*/ void findNumberOfBinaryTreesForPreorderSequenceLength(Node root);
    /**30*/ void modifyBinaryTreeToGetPreorderTraversalUsingRightNodesOnly(Node root);
}
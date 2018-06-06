package datastructures.binaryTree.impl;

import datastructures.binaryTree.commons.Node;

/**
 * @author failedOptimus
 */

public class TreeHelper {

    public Node create() {

        Node root = new Node(10);
        Node one = new Node(8);
        Node two = new Node(2);
        Node three = new Node(3);
        Node four = new Node(5);
        Node five = new Node(2);

        root.setLeftChild(one);
        root.setRightChild(two);
        one.setLeftChild(three);
        one.setRightChild(four);
        two.setLeftChild(five);
        return root;
    }

    public  Node createDup() {

        Node root = new Node(10);
        Node one = new Node(8);
        Node two = new Node(2);
        Node three = new Node(3);
        Node four = new Node(5);
        Node five = new Node(0);

        root.setLeftChild(one);
        root.setRightChild(two);
        one.setLeftChild(three);
        one.setRightChild(four);
        two.setLeftChild(five);
        return root;
    }

    public Node createTreeWithHalfNodes() {

        Node root = new Node(2);
        Node two = new Node(7);
        Node three = new Node(5);
        Node four = new Node(6);
        Node five = new Node(9);
        Node six = new Node(1);
        Node seven = new Node(2);
        Node eight = new Node(8);

        root.setLeftChild(two);
        root.setRightChild(three);
        two.setRightChild(four);
        three.setRightChild(five);
        four.setLeftChild(six);
        four.setRightChild(seven);
        five.setLeftChild(eight);
        return root;
    }
}
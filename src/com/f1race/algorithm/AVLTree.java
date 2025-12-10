package com.f1race.algorithm;

import java.util.ArrayList;
import java.util.List;

public class AVLTree<T extends Comparable<T>> {

    private AVLNode<T> root;
    /*********************************************************************
    Name: AVLTree
    Parameters: none
    Purpose: Initialize an empty AVL tree
    *********************************************************************/
    public AVLTree() {
        this.root = null;
    }

    /*********************************************************************
    Name: height
    Parameters: AVLNode<T> n
    Purpose: Get the height of a node
    *********************************************************************/
    private int height(AVLNode<T> n) {
        return (n == null) ? 0 : n.height;
    }
    /*********************************************************************
    Name: getBalance
    Parameters: AVLNode<T> n
    Purpose: Get balance factor of node n
    *********************************************************************/
    private int getBalance(AVLNode<T> n) {
        return (n == null) ? 0 : height(n.left) - height(n.right);
    }
    /*********************************************************************
    Name: rightRotate
    Parameters: AVLNode<T> y
    Purpose: Perform right rotation on node y
    *********************************************************************/
    private AVLNode<T> rightRotate(AVLNode<T> y) {
        AVLNode<T> x = y.left;
        AVLNode<T> T2 = x.right;

        x.right = y;
        y.left = T2;

        y.height = Math.max(height(y.left), height(y.right)) + 1;
        x.height = Math.max(height(x.left), height(x.right)) + 1;

        return x;
    }

    /*********************************************************************
    Name: leftRotate
    Parameters: AVLNode<T> x
    Purpose: Perform left rotation on node x
    *********************************************************************/
    private AVLNode<T> leftRotate(AVLNode<T> x) {
        AVLNode<T> y = x.right;
        AVLNode<T> T2 = y.left;

        y.left = x;
        x.right = T2;

        x.height = Math.max(height(x.left), height(x.right)) + 1;
        y.height = Math.max(height(y.left), height(y.right)) + 1;

        return y;
    }
    /*********************************************************************
    Name: insert
    Parameters: AVLNode<T> node, T key
    Purpose: Insert key into AVL tree and balance it
    *********************************************************************/
    private AVLNode<T> insert(AVLNode<T> node, T key) {
        if (node == null) return new AVLNode<>(key);

        if (key.compareTo(node.key) < 0)
            node.left = insert(node.left, key);
        else if (key.compareTo(node.key) > 0)
            node.right = insert(node.right, key);
        else
            return node;

        node.height = 1 + Math.max(height(node.left), height(node.right));

        int balance = getBalance(node);

        if (balance > 1 && key.compareTo(node.left.key) < 0)
            return rightRotate(node);

        if (balance < -1 && key.compareTo(node.right.key) > 0)
            return leftRotate(node);

        if (balance > 1 && key.compareTo(node.left.key) > 0) {
            node.left = leftRotate(node.left);
            return rightRotate(node);
        }

        if (balance < -1 && key.compareTo(node.right.key) < 0) {
            node.right = rightRotate(node.right);
            return leftRotate(node);
        }

        return node;
    }

    /*********************************************************************
    Name: insert
    Parameters: T key
    Purpose: Public method to insert key into AVL tree
    *********************************************************************/
    public void insert(T key) {
        root = insert(root, key);
    }
    /*********************************************************************
    Name: inOrder
    Parameters: none
    Purpose: Perform in-order traversal of AVL tree and return list of keys
    *********************************************************************/
    public List<T> inOrder() {
        List<T> out = new ArrayList<>();
        inOrderTraversal(root, out);
        return out;
    }
    /*********************************************************************  
    Name: inOrderTraversal
    Parameters: AVLNode<T> node, List<T> list
    Purpose: Helper method to perform in-order traversal of AVL tree
    *********************************************************************/
    private void inOrderTraversal(AVLNode<T> node, List<T> list) {
        if (node != null) {
            inOrderTraversal(node.left, list);
            list.add(node.key);
            inOrderTraversal(node.right, list);
        }
    }
}

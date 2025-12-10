package com.f1race.algorithm;

public class AVLNode<T extends Comparable<T>> {
    T key;
    AVLNode<T> left;
    AVLNode<T> right;
    int height;
    /*********************************************************************
    Name: AVLNode
    Parameters: T key
    Purpose: Constructor to initialize an AVL tree node with given key
    ***********************************************************************/
    public AVLNode(T key) {
        this.key = key;
        this.left = null;
        this.right = null;
        this.height = 1; 
    }
}

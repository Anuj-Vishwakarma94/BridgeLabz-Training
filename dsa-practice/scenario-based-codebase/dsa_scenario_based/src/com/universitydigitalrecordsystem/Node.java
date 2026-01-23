package com.universitydigitalrecordsystem;

public class Node {

    int key;
    String data;
    Node left;
    Node right;

    Node(int key, String data) {
        this.key = key;
        this.data = data;
        left = null;
        right = null;
    }
}



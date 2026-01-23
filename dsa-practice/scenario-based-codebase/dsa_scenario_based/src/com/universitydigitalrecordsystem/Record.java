package com.universitydigitalrecordsystem;

public class Record {

    Node root;

    Node insert(Node root, int key, String data) {
        if (root == null) {
            return new Node(key, data);
        }

        if (key < root.key) {
            root.left = insert(root.left, key, data);
        } else if (key > root.key) {
            root.right = insert(root.right, key, data);
        }

        return root;
    }

    Node search(Node root, int key) {
        if (root == null || root.key == key) {
            return root;
        }

        if (key < root.key) {
            return search(root.left, key);
        } else {
            return search(root.right, key);
        }
    }

    int findMin(Node root) {
        int minValue = root.key;
        while (root.left != null) {
            root = root.left;
            minValue = root.key;
        }
        return minValue;
    }

    Node delete(Node root, int key) {
        if (root == null) {
            return null;
        }

        if (key < root.key) {
            root.left = delete(root.left, key);
        } else if (key > root.key) {
            root.right = delete(root.right, key);
        } else {

            if (root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.left;
            }

            root.key = findMin(root.right);
            root.right = delete(root.right, root.key);
        }

        return root;
    }


    void inorder(Node root) {
        if (root != null) {
            inorder(root.left);
            System.out.println("Roll no: " + root.key + " | Name: " + root.data);
            inorder(root.right);
        }
    }
}

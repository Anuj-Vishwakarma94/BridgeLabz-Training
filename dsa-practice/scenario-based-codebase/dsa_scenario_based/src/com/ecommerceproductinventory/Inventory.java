package com.ecommerceproductinventory;

public class Inventory{

    ProductNode root;

    ProductNode insert(ProductNode root, int key, String name, double price) {
        if (root == null) {
            return new ProductNode(key, name, price);
        }

        if (key < root.key) {
            root.left = insert(root.left, key, name, price);
        } else if (key > root.key) {
            root.right = insert(root.right, key, name, price);
        }

        return root;
    }

    ProductNode search(ProductNode root, int key) {
        if (root == null || root.key == key) {
            return root;
        }

        if (key < root.key) {
            return search(root.left, key);
        } else {
            return search(root.right, key);
        }
    }

    boolean updatePrice(int key, double newPrice) {
        ProductNode product = search(root, key);

        if (product != null) {
            product.price = newPrice;
            return true;
        }

        return false;
    }

    void inorder(ProductNode root) {
        if (root != null) {
            inorder(root.left);
            System.out.println("SKU: " + root.key + " | Name: " + root.name + " | Price: ₹" + root.price);
            inorder(root.right);
        }
    }
}





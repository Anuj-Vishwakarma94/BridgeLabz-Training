package com.gamingapp;

public class LeaderBoard {

    PlayerNode root;

    int height(PlayerNode node) {
        if (node == null) {
            return 0;
        }
        return node.height;
    }

    int getBalance(PlayerNode node) {
        if (node == null) {
            return 0;
        }
        return height(node.left) - height(node.right);
    }

    PlayerNode rightRotate(PlayerNode y) {
        PlayerNode x = y.left;
        PlayerNode T2 = x.right;

        x.right = y;
        y.left = T2;

        y.height = Math.max(height(y.left), height(y.right)) + 1;
        x.height = Math.max(height(x.left), height(x.right)) + 1;

        return x;
    }

    PlayerNode leftRotate(PlayerNode x) {
        PlayerNode y = x.right;
        PlayerNode T2 = y.left;

        y.left = x;
        x.right = T2;

        x.height = Math.max(height(x.left), height(x.right)) + 1;
        y.height = Math.max(height(y.left), height(y.right)) + 1;

        return y;
    }
    
    PlayerNode insertPlayer(PlayerNode node, int score, String name) {
        if (node == null) {
            return new PlayerNode(score, name);
        }

        if (score < node.score) {
            node.left = insertPlayer(node.left, score, name);
        } else if (score > node.score) {
            node.right = insertPlayer(node.right, score, name);
        } else {
            return node;
        }

        node.height = 1 + Math.max(height(node.left), height(node.right));

        int balance = getBalance(node);

        if (balance > 1 && score < node.left.score) {
            return rightRotate(node);
        }

        if (balance < -1 && score > node.right.score) {
            return leftRotate(node);
        }

        if (balance > 1 && score > node.left.score) {
            node.left = leftRotate(node.left);
            return rightRotate(node);
        }

        if (balance < -1 && score < node.right.score) {
            node.right = rightRotate(node.right);
            return leftRotate(node);
        }

        return node;
    }

    PlayerNode minValueNode(PlayerNode node) {
        PlayerNode current = node;
        while (current.left != null) {
            current = current.left;
        }
        return current;
    }

    PlayerNode removePlayer(PlayerNode root, int score) {
        if (root == null) {
            return root;
        }

        if (score < root.score) {
            root.left = removePlayer(root.left, score);
        } else if (score > root.score) {
            root.right = removePlayer(root.right, score);
        } else {

            if ((root.left == null) || (root.right == null)) {
                PlayerNode temp;

                if (root.left != null) {
                    temp = root.left;
                } else {
                    temp = root.right;
                }

                if (temp == null) {
                    root = null;
                } else {
                    root = temp;
                }
            } else {
                PlayerNode temp = minValueNode(root.right);
                root.score = temp.score;
                root.playerName = temp.playerName;
                root.right = removePlayer(root.right, temp.score);
            }
        }

        if (root == null) {
            return root;
        }

        root.height = Math.max(height(root.left), height(root.right)) + 1;

        int balance = getBalance(root);

        if (balance > 1 && getBalance(root.left) >= 0) {
            return rightRotate(root);
        }

        if (balance > 1 && getBalance(root.left) < 0) {
            root.left = leftRotate(root.left);
            return rightRotate(root);
        }

        if (balance < -1 && getBalance(root.right) <= 0) {
            return leftRotate(root);
        }

        if (balance < -1 && getBalance(root.right) > 0) {
            root.right = rightRotate(root.right);
            return leftRotate(root);
        }

        return root;
    }

    void displayLeaderboard(PlayerNode root) {
        if (root != null) {
            displayLeaderboard(root.left);
            System.out.println("Player: " + root.playerName + " | Score: " + root.score);
            displayLeaderboard(root.right);
        }
    }
}


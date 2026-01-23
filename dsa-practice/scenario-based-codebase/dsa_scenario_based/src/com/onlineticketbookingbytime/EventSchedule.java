package com.onlineticketbookingbytime;

public class EventSchedule {

    EventNode root;

    int height(EventNode node) {
        if (node == null) {
            return 0;
        }
        return node.height;
    }

    int getBalance(EventNode node) {
        if (node == null) {
            return 0;
        }
        return height(node.left) - height(node.right);
    }

    EventNode rightRotate(EventNode y) {
        EventNode x = y.left;
        EventNode T2 = x.right;

        x.right = y;
        y.left = T2;

        y.height = Math.max(height(y.left), height(y.right)) + 1;
        x.height = Math.max(height(x.left), height(x.right)) + 1;

        return x;
    }

    EventNode leftRotate(EventNode x) {
        EventNode y = x.right;
        EventNode T2 = y.left;

        y.left = x;
        x.right = T2;

        x.height = Math.max(height(x.left), height(x.right)) + 1;
        y.height = Math.max(height(y.left), height(y.right)) + 1;

        return y;
    }

    EventNode insertEvent(EventNode node, int time, String name) {
        if (node == null) {
            return new EventNode(time, name);
        }

        if (time < node.eventTime) {
            node.left = insertEvent(node.left, time, name);
        } else if (time > node.eventTime) {
            node.right = insertEvent(node.right, time, name);
        } else {
            return node;
        }

        node.height = 1 + Math.max(height(node.left), height(node.right));

        int balance = getBalance(node);
        
        if (balance > 1 && time < node.left.eventTime) {
            return rightRotate(node);
        }
       
        if (balance < -1 && time > node.right.eventTime) {
            return leftRotate(node);
        }
      
        if (balance > 1 && time > node.left.eventTime) {
            node.left = leftRotate(node.left);
            return rightRotate(node);
        }
        
        if (balance < -1 && time < node.right.eventTime) {
            node.right = rightRotate(node.right);
            return leftRotate(node);
        }

        return node;
    }

    EventNode minValueNode(EventNode node) {
        EventNode current = node;
        while (current.left != null) {
            current = current.left;
        }
        return current;
    }

    EventNode cancelEvent(EventNode root, int time) {
        if (root == null) {
            return root;
        }

        if (time < root.eventTime) {
            root.left = cancelEvent(root.left, time);
        } else if (time > root.eventTime) {
            root.right = cancelEvent(root.right, time);
        } else {

            if (root.left == null || root.right == null) {
                EventNode temp;
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
                EventNode temp = minValueNode(root.right);
                root.eventTime = temp.eventTime;
                root.eventName = temp.eventName;
                root.right = cancelEvent(root.right, temp.eventTime);
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

    void displaySchedule(EventNode root) {
        if (root != null) {
            displaySchedule(root.left);
            System.out.println("Event: " + root.eventName + " | Time: " + root.eventTime);
            displaySchedule(root.right);
        }
    }
}


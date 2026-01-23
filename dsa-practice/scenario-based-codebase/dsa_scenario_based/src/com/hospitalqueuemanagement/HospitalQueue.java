package com.hospitalqueuemanagement;

public class HospitalQueue {

    PatientNode root;

    int height(PatientNode node) {
        if (node == null) {
            return 0;
        }
        return node.height;
    }

    int getBalance(PatientNode node) {
        if (node == null) {
            return 0;
        }
        return height(node.left) - height(node.right);
    }

    PatientNode rightRotate(PatientNode y) {
        PatientNode x = y.left;
        PatientNode T2 = x.right;

        x.right = y;
        y.left = T2;

        y.height = Math.max(height(y.left), height(y.right)) + 1;
        x.height = Math.max(height(x.left), height(x.right)) + 1;

        return x;
    }

    PatientNode leftRotate(PatientNode x) {
        PatientNode y = x.right;
        PatientNode T2 = y.left;

        y.left = x;
        x.right = T2;

        x.height = Math.max(height(x.left), height(x.right)) + 1;
        y.height = Math.max(height(y.left), height(y.right)) + 1;

        return y;
    }

    PatientNode registerPatient(PatientNode node, int time, String name) {
        if (node == null) {
            return new PatientNode(time, name);
        }

        if (time < node.checkInTime) {
            node.left = registerPatient(node.left, time, name);
        } else if (time > node.checkInTime) {
            node.right = registerPatient(node.right, time, name);
        } else {
            return node;
        }

        node.height = 1 + Math.max(height(node.left), height(node.right));

        int balance = getBalance(node);
       
        if (balance > 1 && time < node.left.checkInTime) {
            return rightRotate(node);
        }
      
        if (balance < -1 && time > node.right.checkInTime) {
            return leftRotate(node);
        }
        
        if (balance > 1 && time > node.left.checkInTime) {
            node.left = leftRotate(node.left);
            return rightRotate(node);
        }
        
        if (balance < -1 && time < node.right.checkInTime) {
            node.right = rightRotate(node.right);
            return leftRotate(node);
        }

        return node;
    }

    PatientNode minValueNode(PatientNode node) {
        PatientNode current = node;
        while (current.left != null) {
            current = current.left;
        }
        return current;
    }

    PatientNode dischargePatient(PatientNode root, int time) {
        if (root == null) {
            return root;
        }

        if (time < root.checkInTime) {
            root.left = dischargePatient(root.left, time);
        } else if (time > root.checkInTime) {
            root.right = dischargePatient(root.right, time);
        } else {

            if (root.left == null || root.right == null) {
                PatientNode temp;
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
                PatientNode temp = minValueNode(root.right);
                root.checkInTime = temp.checkInTime;
                root.patientName = temp.patientName;
                root.right = dischargePatient(root.right, temp.checkInTime);
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

    void displayQueue(PatientNode root) {
        if (root != null) {
            displayQueue(root.left);
            System.out.println("Patient: " + root.patientName + " | Check-In Time: " + root.checkInTime);
            displayQueue(root.right);
        }
    }
}


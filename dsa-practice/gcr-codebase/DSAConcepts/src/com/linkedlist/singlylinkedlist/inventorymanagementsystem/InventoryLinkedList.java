package com.linkedlist.singlylinkedlist.inventorymanagementsystem;

public class InventoryLinkedList {
    private ItemNode head;

    // Add at beginning
    public void addAtBeginning(int id, String name, int qty, double price) {
        ItemNode newNode = new ItemNode(id, name, qty, price);
        newNode.next = head;
        head = newNode;
    }

    // Add at end
    public void addAtEnd(int id, String name, int qty, double price) {
        ItemNode newNode = new ItemNode(id, name, qty, price);
        if (head == null) {
            head = newNode;
            return;
        }
        ItemNode temp = head;
        while (temp.next != null)
            temp = temp.next;
        temp.next = newNode;
    }

    // Add at specific position
    public void addAtPosition(int pos, int id, String name, int qty, double price) {
        if (pos <= 0) {
            System.out.println("Invalid position");
            return;
        }
        if (pos == 1) {
            addAtBeginning(id, name, qty, price);
            return;
        }
        ItemNode newNode = new ItemNode(id, name, qty, price);
        ItemNode temp = head;
        for (int i = 1; i < pos - 1 && temp != null; i++)
            temp = temp.next;

        if (temp == null) {
            System.out.println("Position out of range");
            return;
        }
        newNode.next = temp.next;
        temp.next = newNode;
    }

    public void removeByItemId(int id) {
        if (head == null)
            return;

        if (head.itemId == id) {
            head = head.next;
            System.out.println("Item removed");
            return;
        }

        ItemNode temp = head;
        while (temp.next != null && temp.next.itemId != id)
            temp = temp.next;

        if (temp.next == null)
            System.out.println("Item not found");
        else {
            temp.next = temp.next.next;
            System.out.println("Item removed");
        }
    }

    public void updateQuantity(int id, int newQty) {
        ItemNode temp = head;
        while (temp != null) {
            if (temp.itemId == id) {
                temp.quantity = newQty;
                System.out.println("Quantity updated");
                return;
            }
            temp = temp.next;
        }
        System.out.println("Item not found");
    }

    public void searchById(int id) {
        ItemNode temp = head;
        while (temp != null) {
            if (temp.itemId == id) {
                displayItem(temp);
                return;
            }
            temp = temp.next;
        }
        System.out.println("Item not found");
    }

    public void searchByName(String name) {
        ItemNode temp = head;
        boolean found = false;
        while (temp != null) {
            if (temp.itemName.equalsIgnoreCase(name)) {
                displayItem(temp);
                found = true;
            }
            temp = temp.next;
        }
        if (!found)
            System.out.println("Item not found");
    }

    public void totalInventoryValue() {
        double total = 0;
        ItemNode temp = head;
        while (temp != null) {
            total += temp.quantity * temp.price;
            temp = temp.next;
        }
        System.out.println("Total Inventory Value = ₹" + total);
    }

    public void displayAll() {
        if (head == null) {
            System.out.println("Inventory empty");
            return;
        }
        ItemNode temp = head;
        while (temp != null) {
            displayItem(temp);
            temp = temp.next;
        }
    }

    private void displayItem(ItemNode item) {
        System.out.println(
            "ID: " + item.itemId +
            ", Name: " + item.itemName +
            ", Qty: " + item.quantity +
            ", Price: ₹" + item.price
        );
    }

    public void sortByName(boolean ascending) {
        head = mergeSort(head, "name", ascending);
    }

    public void sortByPrice(boolean ascending) {
        head = mergeSort(head, "price", ascending);
    }

    private ItemNode mergeSort(ItemNode node, String key, boolean asc) {
        if (node == null || node.next == null)
            return node;

        ItemNode mid = getMiddle(node);
        ItemNode nextMid = mid.next;
        mid.next = null;

        ItemNode left = mergeSort(node, key, asc);
        ItemNode right = mergeSort(nextMid, key, asc);

        return merge(left, right, key, asc);
    }

    private ItemNode merge(ItemNode a, ItemNode b, String key, boolean asc) {
        if (a == null) return b;
        if (b == null) return a;

        boolean condition;
        if (key.equals("name")) {
            condition = asc ?
                a.itemName.compareToIgnoreCase(b.itemName) <= 0 :
                a.itemName.compareToIgnoreCase(b.itemName) > 0;
        } else {
            condition = asc ? a.price <= b.price : a.price > b.price;
        }

        if (condition) {
            a.next = merge(a.next, b, key, asc);
            return a;
        } else {
            b.next = merge(a, b.next, key, asc);
            return b;
        }
    }

    private ItemNode getMiddle(ItemNode node) {
        ItemNode slow = node, fast = node.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}
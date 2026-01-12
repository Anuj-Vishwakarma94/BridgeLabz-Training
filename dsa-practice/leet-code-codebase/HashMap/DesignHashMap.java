import java.util.Scanner;

class DesignHashMap {

    static class Node {
        int key;
        int value;
        Node next;

        Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    private final int SIZE = 1000;
    private Node[] buckets;

    public MyHashMap() {
        buckets = new Node[SIZE];
    }

    private int hash(int key) {
        return key % SIZE;
    }

    public void put(int key, int value) {
        int index = hash(key);
        Node head = buckets[index];

        Node curr = head;
        while (curr != null) {
            if (curr.key == key) {
                curr.value = value;
                return;
            }
            curr = curr.next;
        }

        Node newNode = new Node(key, value);
        newNode.next = head;
        buckets[index] = newNode;
    }

    public int get(int key) {
        int index = hash(key);
        Node curr = buckets[index];

        while (curr != null) {
            if (curr.key == key) {
                return curr.value;
            }
            curr = curr.next;
        }

        return -1;
    }

    public void remove(int key) {
        int index = hash(key);
        Node curr = buckets[index];
        Node prev = null;

        while (curr != null) {
            if (curr.key == key) {
                if (prev == null) {
                    buckets[index] = curr.next;
                } else {
                    prev.next = curr.next;
                }
                return;
            }
            prev = curr;
            curr = curr.next;
        }
    }

    // ---------- MAIN METHOD ----------
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        MyHashMap map = new MyHashMap();

        while (true) {
            System.out.println("\n1. Put");
            System.out.println("2. Get");
            System.out.println("3. Remove");
            System.out.println("4. Exit");
            System.out.print("Enter choice: ");

            int choice = sc.nextInt();

            if (choice == 1) {
                System.out.print("Enter key: ");
                int key = sc.nextInt();
                System.out.print("Enter value: ");
                int value = sc.nextInt();
                map.put(key, value);
                System.out.println("Inserted successfully");
            } 
            else if (choice == 2) {
                System.out.print("Enter key: ");
                int key = sc.nextInt();
                System.out.println("Value: " + map.get(key));
            } 
            else if (choice == 3) {
                System.out.print("Enter key: ");
                int key = sc.nextInt();
                map.remove(key);
                System.out.println("Key removed if existed");
            } 
            else if (choice == 4) {
                System.out.println("Exiting...");
                break;
            } 
            else {
                System.out.println("Invalid choice");
            }
        }
    }
}

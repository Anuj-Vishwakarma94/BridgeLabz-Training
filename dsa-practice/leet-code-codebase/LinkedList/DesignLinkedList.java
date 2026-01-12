import java.util.Scanner;

class DesignLinkedList {

    class Node {
        int val;
        Node next;

        Node(int val) {
            this.val = val;
            this.next = null;
        }
    }

    private Node head;
    private int size;

    public MyLinkedList() {
        head = null;
        size = 0;
    }

    public int get(int index) {
        if (index < 0 || index >= size) {
            return -1;
        }

        Node curr = head;
        for (int i = 0; i < index; i++) {
            curr = curr.next;
        }

        return curr.val;
    }

    public void addAtHead(int val) {
        Node newNode = new Node(val);
        newNode.next = head;
        head = newNode;
        size++;
    }

    public void addAtTail(int val) {
        Node newNode = new Node(val);

        if (head == null) {
            head = newNode;
        } else {
            Node curr = head;
            while (curr.next != null) {
                curr = curr.next;
            }
            curr.next = newNode;
        }

        size++;
    }

    public void addAtIndex(int index, int val) {
        if (index < 0 || index > size) {
            return;
        }

        if (index == 0) {
            addAtHead(val);
            return;
        }

        Node curr = head;
        for (int i = 0; i < index - 1; i++) {
            curr = curr.next;
        }

        Node newNode = new Node(val);
        newNode.next = curr.next;
        curr.next = newNode;
        size++;
    }

    public void deleteAtIndex(int index) {
        if (index < 0 || index >= size) {
            return;
        }

        if (index == 0) {
            head = head.next;
        } else {
            Node curr = head;
            for (int i = 0; i < index - 1; i++) {
                curr = curr.next;
            }
            curr.next = curr.next.next;
        }

        size--;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        MyLinkedList list = new MyLinkedList();

        while (true) {
            System.out.println("\n1. Add at Head");
            System.out.println("2. Add at Tail");
            System.out.println("3. Add at Index");
            System.out.println("4. Get value at Index");
            System.out.println("5. Delete at Index");
            System.out.println("6. Exit");
            System.out.print("Enter choice: ");

            int choice = sc.nextInt();

            if (choice == 1) {
                System.out.print("Enter value: ");
                int val = sc.nextInt();
                list.addAtHead(val);
                System.out.println("Added at head");
            }
            else if (choice == 2) {
                System.out.print("Enter value: ");
                int val = sc.nextInt();
                list.addAtTail(val);
                System.out.println("Added at tail");
            }
            else if (choice == 3) {
                System.out.print("Enter index: ");
                int index = sc.nextInt();
                System.out.print("Enter value: ");
                int val = sc.nextInt();
                list.addAtIndex(index, val);
                System.out.println("Added at index");
            }
            else if (choice == 4) {
                System.out.print("Enter index: ");
                int index = sc.nextInt();
                System.out.println("Value: " + list.get(index));
            }
            else if (choice == 5) {
                System.out.print("Enter index: ");
                int index = sc.nextInt();
                list.deleteAtIndex(index);
                System.out.println("Deleted at index");
            }
            else if (choice == 6) {
                System.out.println("Exiting...");
                break;
            }
            else {
                System.out.println("Invalid choice");
            }
        }
    }
}

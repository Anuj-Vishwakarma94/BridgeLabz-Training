class ListNode {
    int val;
    ListNode next;

    ListNode(int val) {
        this.val = val;
        this.next = null;
    }
}

public class LinkedListCycle {

    public static boolean hasCycle(ListNode head) {
        if (head == null || head.next == null)
            return false;

        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast)
                return true;
        }
        return false;
    }

    public static void main(String[] args) {

        
        ListNode head = new ListNode(1);
        ListNode second = new ListNode(2);

        head.next = second;
        second.next = head; 

        System.out.println(hasCycle(head));  
         
        ListNode single = new ListNode(1);

        System.out.println(hasCycle(single)); 
    }
}
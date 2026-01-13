import java.util.*;

class IntersectionOfTwoLinkedLists {

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
        }
    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) return null;

        ListNode pA = headA;
        ListNode pB = headB;

        while (pA != pB) {
            pA = (pA == null) ? headB : pA.next;
            pB = (pB == null) ? headA : pB.next;
        }

        return pA;
    }

    private static ListNode buildList(int[] arr) {
        if (arr.length == 0) return null;

        ListNode head = new ListNode(arr[0]);
        ListNode curr = head;

        for (int i = 1; i < arr.length; i++) {
            curr.next = new ListNode(arr[i]);
            curr = curr.next;
        }
        return head;
    }

    private static ListNode getNodeAt(ListNode head, int index) {
        while (index-- > 0 && head != null) {
            head = head.next;
        }
        return head;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int m = sc.nextInt();
        int[] arrA = new int[m];
        for (int i = 0; i < m; i++) arrA[i] = sc.nextInt();

        int n = sc.nextInt();
        int[] arrB = new int[n];
        for (int i = 0; i < n; i++) arrB[i] = sc.nextInt();

        int skipA = sc.nextInt();
        int skipB = sc.nextInt();

        ListNode headA = buildList(arrA);
        ListNode headB = buildList(arrB);

        if (skipA < m && skipB < n) {
            ListNode nodeA = getNodeAt(headA, skipA);
            ListNode nodeB = getNodeAt(headB, skipB);
            ListNode temp = headB;
            while (temp.next != null) temp = temp.next;
            temp.next = nodeA;
        }

        IntersectionOfTwoLinkedLists obj = new IntersectionOfTwoLinkedLists();
        ListNode res = obj.getIntersectionNode(headA, headB);

        if (res == null) System.out.println("No intersection");
        else System.out.println(res.val);
    }
}

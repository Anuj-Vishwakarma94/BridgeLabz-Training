package com.browserbuddy;
class TabHistory {
    private HistoryNode head;
    private HistoryNode current;

    public void visitPage(String url) {
        HistoryNode newNode = new HistoryNode(url);

        if (head == null) {
            head = newNode;
            current = newNode;
            return;
        }

        current.next = null;
        newNode.prev = current;
        current.next = newNode;
        current = newNode;
    }

    public void goBack() {
        if (current != null && current.prev != null) {
            current = current.prev;
        } else {
            System.out.println("No previous page");
        }
    }

    public void goForward() {
        if (current != null && current.next != null) {
            current = current.next;
        } else {
            System.out.println("No next page");
        }
    }

    public void showCurrentPage() {
        if (current != null) {
            System.out.println("Current Page: " + current.url);
        } else {
            System.out.println("No page open");
        }
    }
}
package com.linkedlist.doublylinkedlist.undoredofunctionality;

public class TextEditorUndoRedo {
    private TextState head;
    private TextState tail;
    private TextState current;
    private int size;
    private final int MAX_HISTORY = 10;

    public void addState(String newContent) {

        // Clear redo history if new action is performed after undo
        if (current != tail) {
            TextState temp = current.next;
            while (temp != null) {
                TextState next = temp.next;
                temp.prev = temp.next = null;
                temp = next;
                size--;
            }
            current.next = null;
            tail = current;
        }

        TextState newState = new TextState(newContent);

        if (head == null) {
            head = tail = current = newState;
            size = 1;
            return;
        }

        tail.next = newState;
        newState.prev = tail;
        tail = newState;
        current = newState;
        size++;

        // Maintain history limit
        if (size > MAX_HISTORY) {
            head = head.next;
            head.prev = null;
            size--;
        }
    }

    public void undo() {
        if (current != null && current.prev != null) {
            current = current.prev;
            System.out.println("Undo performed");
        } else {
            System.out.println("No more undo available");
        }
    }

    public void redo() {
        if (current != null && current.next != null) {
            current = current.next;
            System.out.println("Redo performed");
        } else {
            System.out.println("No more redo available");
        }
    }

    public void displayCurrentState() {
        if (current == null) {
            System.out.println("Editor empty");
        } else {
            System.out.println("Current Text: \"" + current.content + "\"");
        }
    }

    public void displayHistoryForward() {
        TextState temp = head;
        System.out.println("\nHistory (Oldest → Newest):");
        while (temp != null) {
            System.out.println(temp.content);
            temp = temp.next;
        }
    }
}

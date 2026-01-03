package com.linkedlist.doublylinkedlist.undoredofunctionality;

public class UndoRedoTextEditor {
    public static void main(String[] args) {

        TextEditorUndoRedo editor = new TextEditorUndoRedo();

        editor.addState("Hello");
        editor.addState("Hello World");
        editor.addState("Hello World!");
        editor.addState("Hello World! Welcome");
        editor.addState("Hello World! Welcome to Java");

        editor.displayCurrentState();

        System.out.println("\n--- Undo Operations ---");
        editor.undo();
        editor.displayCurrentState();

        editor.undo();
        editor.displayCurrentState();

        System.out.println("\n--- Redo Operation ---");
        editor.redo();
        editor.displayCurrentState();

        System.out.println("\n--- New Action After Undo (Redo Cleared) ---");
        editor.addState("Hello World! Java DSA");
        editor.displayCurrentState();

        System.out.println("\n--- Full History ---");
        editor.displayHistoryForward();
    }
}
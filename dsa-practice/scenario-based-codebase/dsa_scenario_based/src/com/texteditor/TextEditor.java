package com.texteditor;

import java.util.Stack;
public class TextEditor {
	private String text;
    private Stack<String> undoStack;
    private Stack<String> redoStack;
    
    public TextEditor() {
        text = "";
        undoStack = new Stack<>();
        redoStack = new Stack<>();
    }
    public void insert(String newText) {
        undoStack.push(text);
        text = text + newText;
        redoStack.clear();
    }

    public void delete(int count) {
        if (count > text.length()) {
            System.out.println("Not enough characters to delete");
            return;
        }
        undoStack.push(text);
        text = text.substring(0, text.length() - count);
        redoStack.clear();
    }

    public void undo() {
        if (undoStack.isEmpty()) {
            System.out.println("Nothing to undo");
            return;
        }
        redoStack.push(text);
        text = undoStack.pop();
    }

    public void redo() {
        if (redoStack.isEmpty()) {
            System.out.println("Nothing to redo");
            return;
        }
        undoStack.push(text);
        text = redoStack.pop();
    }

    public String getText() {
        return text;
    }
}

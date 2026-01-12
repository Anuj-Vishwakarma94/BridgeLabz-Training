package com.texteditor;

import java.util.Scanner;
public class TextEditorMain {
	public static void main(String []args) {
		Scanner sc = new Scanner(System.in);
        TextEditor editor = new TextEditor();

        while (true) {
            System.out.println("\n1 Insert");
            System.out.println("2 Delete");
            System.out.println("3 Undo");
            System.out.println("4 Redo");
            System.out.println("5 Show Text");
            System.out.println("6 Exit");
            System.out.print("Choose option: ");

            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter text to insert: ");
                    String text = sc.nextLine();
                    editor.insert(text);
                    break;

                case 2:
                    System.out.print("Enter number of characters to delete: ");
                    int count = sc.nextInt();
                    editor.delete(count);
                    break;

                case 3:
                    editor.undo();
                    break;

                case 4:
                    editor.redo();
                    break;

                case 5:
                    System.out.println("Current Text: " + editor.getText());
                    break;

                case 6:
                    System.out.println("Editor closed");
                    return;

                default:
                    System.out.println("Invalid choice");
            }
        }
	}
}

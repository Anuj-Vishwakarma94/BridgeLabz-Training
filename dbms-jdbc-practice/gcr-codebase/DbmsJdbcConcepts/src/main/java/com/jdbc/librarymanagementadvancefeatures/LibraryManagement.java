package com.jdbc.librarymanagementadvancefeatures;
import java.sql.*;
import java.util.Scanner;

public class LibraryManagement {

    static final String url = "jdbc:mysql://localhost:3306/sqlpractice";
    static final String username = "root";
    static final String password = "Gamebit@8878";

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        while(true) {

            System.out.println("\n===== Library Management System =====");
            System.out.println("1. View Book Inventory");
            System.out.println("2. Borrow Book");
            System.out.println("3. Return Book (Fine Calculation)");
            System.out.println("4. Search Book");
            System.out.println("5. Borrow History");
            System.out.println("6. Exit");

            System.out.print("Enter choice: ");
            int choice = sc.nextInt();

            switch(choice) {

                case 1: viewBooks(); break;
                case 2: borrowBook(); break;
                case 3: returnBook(); break;
                case 4: searchBooks(); break;
                case 5: borrowHistory(); break;
                case 6: System.exit(0);
            }
        }
    }

    // ============================================
    // View Book Inventory
    // ============================================
    static void viewBooks() {

        try(Connection con = DriverManager.getConnection(url, username, password)) {

            String query = "SELECT * FROM books";

            Statement st = con.createStatement();

            ResultSet rs = st.executeQuery(query);

            while(rs.next()) {

                System.out.println(
                        rs.getInt("book_id") + " | " +
                        rs.getString("title") + " | " +
                        rs.getString("author") + " | " +
                        rs.getString("genre") + " | Available: " +
                        rs.getInt("available_copies"));
            }

        } catch(Exception e) {
            System.out.println(e);
        }
    }

    // ============================================
    // Borrow Book (Transaction)
    // ============================================
    static void borrowBook() {

        try(Connection con = DriverManager.getConnection(url, username, password)) {

            System.out.print("Enter Student ID: ");
            int studentId = sc.nextInt();

            System.out.print("Enter Book ID: ");
            int bookId = sc.nextInt();

            con.setAutoCommit(false);

            // Check availability
            PreparedStatement checkStmt =
                    con.prepareStatement("SELECT available_copies FROM books WHERE book_id=?");

            checkStmt.setInt(1, bookId);

            ResultSet rs = checkStmt.executeQuery();

            if(!rs.next() || rs.getInt("available_copies") <= 0) {

                System.out.println("Book not available");
                return;
            }

            // Insert borrow record
            PreparedStatement insertStmt =
                    con.prepareStatement(
                            "INSERT INTO borrow_records(student_id, book_id, borrow_date) VALUES (?, ?, CURDATE())");

            insertStmt.setInt(1, studentId);
            insertStmt.setInt(2, bookId);

            insertStmt.executeUpdate();

            // Reduce available copies
            PreparedStatement updateStmt =
                    con.prepareStatement(
                            "UPDATE books SET available_copies=available_copies-1 WHERE book_id=?");

            updateStmt.setInt(1, bookId);

            updateStmt.executeUpdate();

            con.commit();

            System.out.println("Book Borrowed Successfully");

        } catch(Exception e) {

            System.out.println("Borrow Failed");
            System.out.println(e);
        }
    }

    // ============================================
    // Return Book and Calculate Fine
    // Fine = ₹10 per day after 7 days
    // ============================================
    static void returnBook() {

        try(Connection con = DriverManager.getConnection(url, username, password)) {

            System.out.print("Enter Record ID: ");
            int recordId = sc.nextInt();

            con.setAutoCommit(false);

            // Update return date and fine
            PreparedStatement updateFine =
                    con.prepareStatement(
                            "UPDATE borrow_records " +
                            "SET return_date=CURDATE(), " +
                            "fine = CASE " +
                            "WHEN DATEDIFF(CURDATE(), borrow_date) > 7 " +
                            "THEN (DATEDIFF(CURDATE(), borrow_date)-7)*10 " +
                            "ELSE 0 END " +
                            "WHERE record_id=?");

            updateFine.setInt(1, recordId);

            updateFine.executeUpdate();

            // Get book id
            PreparedStatement getBook =
                    con.prepareStatement(
                            "SELECT book_id FROM borrow_records WHERE record_id=?");

            getBook.setInt(1, recordId);

            ResultSet rs = getBook.executeQuery();

            if(rs.next()) {

                int bookId = rs.getInt("book_id");

                // Increase available copies
                PreparedStatement updateBook =
                        con.prepareStatement(
                                "UPDATE books SET available_copies=available_copies+1 WHERE book_id=?");

                updateBook.setInt(1, bookId);

                updateBook.executeUpdate();
            }

            con.commit();

            System.out.println("Book Returned Successfully");

        } catch(Exception e) {

            System.out.println("Return Failed");
            System.out.println(e);
        }
    }

    // ============================================
    // Search Books (Multiple Filters)
    // ============================================
    static void searchBooks() {

        try(Connection con = DriverManager.getConnection(url, username, password)) {

            sc.nextLine();

            System.out.print("Enter Genre: ");
            String genre = sc.nextLine();

            System.out.print("Enter Author: ");
            String author = sc.nextLine();

            String query =
                    "SELECT * FROM books WHERE genre=? AND author LIKE ? AND available_copies>0";

            PreparedStatement ps = con.prepareStatement(query);

            ps.setString(1, genre);
            ps.setString(2, "%" + author + "%");

            ResultSet rs = ps.executeQuery();

            while(rs.next()) {

                System.out.println(
                        rs.getInt("book_id") + " | " +
                        rs.getString("title") + " | " +
                        rs.getString("author") + " | Available: " +
                        rs.getInt("available_copies"));
            }

        } catch(Exception e) {
            System.out.println(e);
        }
    }

    // ============================================
    // Borrow History
    // ============================================
    static void borrowHistory() {

        try(Connection con = DriverManager.getConnection(url, username, password)) {

            String query =
                    "SELECT br.record_id, s.student_name, b.title, br.borrow_date, br.return_date, br.fine " +
                    "FROM borrow_records br " +
                    "JOIN students s ON br.student_id=s.student_id " +
                    "JOIN books b ON br.book_id=b.book_id";

            Statement st = con.createStatement();

            ResultSet rs = st.executeQuery(query);

            while(rs.next()) {

                System.out.println(
                        rs.getInt("record_id") + " | " +
                        rs.getString("student_name") + " | " +
                        rs.getString("title") + " | " +
                        rs.getDate("borrow_date") + " | " +
                        rs.getDate("return_date") + " | Fine: ₹" +
                        rs.getDouble("fine"));
            }

        } catch(Exception e) {
            System.out.println(e);
        }
    }
}

import java.sql.*;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/iut"; // replace "mydatabase" with your database name
        String username = "root"; // replace with your username
        String password = ""; // replace with your password

        try {
            Connection conn = DriverManager.getConnection(url, username, password);
            java.sql.Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM student");

            while (rs.next()) {
                int studentId = rs.getInt("student_id");
                String firstName = rs.getString("first_name");
                String lastName = rs.getString("last_name");
                int age = rs.getInt("age");
                String address = rs.getString("address");

                System.out.println("Student ID: " + studentId);
                System.out.println("First Name: " + firstName);
                System.out.println("Last Name: " + lastName);
                System.out.println("Age: " + age);
                System.out.println("Address: " + address);
                System.out.println();
            }
            Scanner scanner = new Scanner(System.in);

            System.out.println("Enter Student ID:");
            int studentId = scanner.nextInt();
            scanner.nextLine(); // consume newline character

            System.out.println("Enter First Name:");
            String firstName = scanner.nextLine();

            System.out.println("Enter Last Name:");
            String lastName = scanner.nextLine();

            System.out.println("Enter Age:");
            int age = scanner.nextInt();
            scanner.nextLine(); // consume newline character

            System.out.println("Enter Address:");
            String address = scanner.nextLine();

            PreparedStatement pstmt = conn.prepareStatement(
                "INSERT INTO student (student_id, first_name, last_name, age, address) VALUES (?, ?, ?, ?, ?)"
            );
            pstmt.setInt(1, studentId);
            pstmt.setString(2, firstName);
            pstmt.setString(3, lastName);
            pstmt.setInt(4, age);
            pstmt.setString(5, address);
            pstmt.executeUpdate();

            System.out.println("Record added successfully.");

            pstmt.close();
            conn.close();
            scanner.close();
            rs.close();
            stmt.close();
            conn.close();
        } catch (SQLException e) {
            System.out.println("Database connection failed: " + e.getMessage());
        }
    }
}

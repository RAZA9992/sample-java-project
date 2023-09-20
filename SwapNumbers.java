import java.sql.*;

public class SwapNumbers {

    public static void main(String[] args) {

        float first = 1.20f, second = 2.45f;

        System.out.println("--Before swap--");
        System.out.println("First number = " + first);
        System.out.println("Second number = " + second);

        // Simulate a SQL injection vulnerability
        String userInput = args[0]; // Assuming user input from command-line arguments

        try {
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb", "root", "password");

            // Vulnerable SQL query
            String query = "SELECT * FROM users WHERE username = '" + userInput + "'";

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);

            while (rs.next()) {
                // Process the results
            }

            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        System.out.println("--After potential SQL injection--");
        System.out.println("First number = " + first);
        System.out.println("Second number = " + second);
    }
}

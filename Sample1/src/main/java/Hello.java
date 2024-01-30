import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Hello {
    String dbUrl = "jdbc:mysql://localhost:3306/ngpdb";
    String dbUname = "root";
    String dbPassword = "";
    String dbDriver = "com.mysql.cj.jdbc.Driver";
    String name, pass, email, number;

    // Constructor with parameters
    public Hello(String name, String pass, String email, String number) {
        this.name = name;
        this.pass = pass;
        this.email = email;
        this.number = number;
    }

    // Default constructor (if needed)
    public Hello() {
        // Default constructor
    }

    public StringBuilder performRegistration() {
        StringBuilder consoleMessages = new StringBuilder();

        try (Connection con = DriverManager.getConnection(dbUrl, dbUname, dbPassword)) {
            Class.forName(dbDriver);

            // Check if the user with the given name, email, and mobile number already exists
            if (isUserAlreadyRegistered(con, name, email, number)) {
                consoleMessages.append("Given name, email, and mobile number already registered.");
                consoleMessages.append("Please Login.");
                return consoleMessages;
            }

            String sql = "INSERT INTO user_details (Name, Password, Email, Phone_no) VALUES (?, ?, ?, ?)";
            try (PreparedStatement preparedStatement = con.prepareStatement(sql)) {
                preparedStatement.setString(1, name);
                preparedStatement.setString(2, pass);
                preparedStatement.setString(3, email);
                preparedStatement.setString(4, number);

                preparedStatement.executeUpdate();
                consoleMessages.append("Registration successful! You can now login.");
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            consoleMessages.append("An error occurred during registration.");
        }

        return consoleMessages;
    }

    private boolean isUserAlreadyRegistered(Connection con, String name, String email, String number) throws SQLException {
        String sql = "SELECT * FROM user_details WHERE Name = ? AND Email = ? AND Phone_no = ?";
        try (PreparedStatement preparedStatement = con.prepareStatement(sql)) {
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, email);
            preparedStatement.setString(3, number);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                return resultSet.next(); // Returns true if a matching record is found
            }
        }
    }

    public static void main(String[] args) {
        // Example usage
        Hello hello = new Hello("John Doe", "password123", "john.doe@example.com", "1234567890");
        StringBuilder result = hello.performRegistration();
        System.out.println(result.toString());
    }
}

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UserReviewDAO {

    private String dbUrl = "jdbc:mysql://localhost:3306/NGPDB";
    private String dbUname = "root";
    private String dbPassword = "";
    private String dbDriver = "com.mysql.cj.jdbc.Driver";

    public void insertReview(String username, int rating, String review) {
        try {
            Class.forName(dbDriver);
            Connection con = DriverManager.getConnection(dbUrl, dbUname, dbPassword);

            String query = "INSERT INTO user_reviews (username, rating, review) VALUES (?, ?, ?)";
            try (PreparedStatement preparedStatement = con.prepareStatement(query)) {
                preparedStatement.setString(1, username);
                preparedStatement.setInt(2, rating);
                preparedStatement.setString(3, review);

                int rowsAffected = preparedStatement.executeUpdate();

                if (rowsAffected > 0) {
                    System.out.println("Review successfully inserted into the database.");
                } else {
                    System.out.println("Failed to insert the review into the database.");
                }
            }

            con.close();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        // Example usage
        UserReviewDAO userReviewDAO = new UserReviewDAO();
        userReviewDAO.insertReview("JohnDoe", 4, "Great experience!");
    }
}

// FetchBookRequestsServlet.java

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/fetchBookRequestsServlet")
public class fetchBookRequestsServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("application/json");
        PrintWriter out = response.getWriter();

        List<BookRequest> bookRequests = new ArrayList<>();

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ngpdb", "root", "");
            Statement statement = con.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT `Book Name`, `Author Name` FROM bookreq");

            while (resultSet.next()) {
                String bookName = resultSet.getString("Book Name");
                String authorName = resultSet.getString("Author Name");
                bookRequests.add(new BookRequest(bookName, authorName));
            }

            con.close();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            // Handle exceptions appropriately
        }

        // Convert the list of book requests to JSON format
        String json = convertToJson(bookRequests);

        // Send JSON response back to the client
        out.println(json);
    }

    private String convertToJson(List<BookRequest> bookRequests) {
        StringBuilder jsonBuilder = new StringBuilder("[");
        for (int i = 0; i < bookRequests.size(); i++) {
            BookRequest request = bookRequests.get(i);
            jsonBuilder.append("{\"bookName\":\"").append(request.getBookName()).append("\",\"authorName\":\"").append(request.getAuthorName()).append("\"}");
            if (i < bookRequests.size() - 1) {
                jsonBuilder.append(",");
            }
        }
        jsonBuilder.append("]");
        return jsonBuilder.toString();
    }
}

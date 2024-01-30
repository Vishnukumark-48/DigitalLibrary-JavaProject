import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.HashSet;
import java.util.Set;

@WebServlet("/BookServlet")
public class BookServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ngpdb", "root", "");
             PreparedStatement preparedStatement = con.prepareStatement("SELECT DISTINCT Category FROM library")) {

            ResultSet resultSet = preparedStatement.executeQuery();
            Set<String> categories = new HashSet<>();

            while (resultSet.next()) {
                String category = resultSet.getString("Category");
                categories.add(category);
            }

            for (String category : categories) {
                out.println("<option value='" + category + "'>" + category + "</option>");
            }

        } catch (Exception e) {
            e.printStackTrace();
            out.println("Error fetching category data.");
        } finally {
            out.close();
        }
    }
}

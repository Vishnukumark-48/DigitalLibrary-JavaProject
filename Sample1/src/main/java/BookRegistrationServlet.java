import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

@WebServlet("/BookRegistrationServlet")
public class BookRegistrationServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        // Retrieve book details from the form
        String bookName = request.getParameter("bookName");
        String authorName = request.getParameter("authorName");
//        String category = request.getParameter("category");

        try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ngpdb", "root", "");
             PreparedStatement preparedStatement = con.prepareStatement("INSERT INTO library (`Book Name`, `Author Name`) VALUES (?, ?)")) {

            preparedStatement.setString(1, bookName);
            preparedStatement.setString(2, authorName);
//            preparedStatement.setString(3, category);

            int rowsAffected = preparedStatement.executeUpdate();

            out.println("<html><head><style>");
            out.println("body {");
            out.println("    display: flex;");
            out.println("    justify-content: center;");
            out.println("    align-items: center;");
            out.println("    height: 100vh;");
            out.println("    margin: 0;");
            out.println("    padding: 0;");
            out.println("    font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;");
            out.println("    background: url(https://images.pexels.com/photos/1097930/pexels-photo-1097930.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=2); background-size: cover;");
            out.println("    transition: background 0.5s ease-in-out");
            out.println("}");
            out.println("h2 {");
            out.println("    margin-bottom: 20px;");
            out.println("    color: #333;  /* Green color for the header */");
            out.println("}");
            out.println(".container {");
            out.println("    background-color: #fff;");
            out.println("    padding: 20px;");
            out.println("    border-radius: 8px;");
            out.println("    box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);");
            out.println("    width: 350px;");
            out.println("    text-align: center;");
            out.println("    transition: box-shadow 0.3s ease-in-out;");
            out.println("}");
            out.println("button {");
            out.println("    display: block;");
            out.println("    margin: 0 auto; /* Center the button */");
            out.println("    background-color: #333;");
            out.println("    color: #fff;");
            out.println("    padding: 12px 20px;");
            out.println("    border: 1px solid #333 ;");
            out.println("    border-radius: 4px;");
            out.println("    cursor: pointer;");
            out.println("    font-size: 16px;");
            out.println("    transition: background-color 0.3s ease-in-out;");
            out.println("}");
            out.println("button:hover {");
            out.println("    background-color: red;");
            out.println("    border-color: #333;");
            out.println("}");
            out.println("</style></head><body>");
            
            if (rowsAffected > 0) {
                out.println("<div class='container'>");
                out.println("    <h2 style='color: #333;'>Book registration successful!</h2>");
                out.println("    <button onclick='redirectToRegistration()'>Go to Book Registration</button>");
                out.println("</div>");
                out.println("<script>");
                out.println("function redirectToRegistration() {");
                out.println("    window.location.href = 'book-registration.html';");
                out.println("}");
                out.println("</script>");
            } else {
                out.println("<div class='container' style='color: red;'>");
                out.println("    <h2>Error in book registration.</h2>");
                out.println("    <button onclick='redirectToRegistration()'>Go to Book Registration</button>");
                out.println("</div>");
                out.println("<script>");
                out.println("function redirectToRegistration() {");
                out.println("    window.location.href = 'book-registration.html';");
                out.println("}");
                out.println("</script>");
            }

            out.println("</body></html>");

        } catch (SQLException e) {
            e.printStackTrace();
            out.println("<html><body style='color: red;'>");
            out.println("    <h2>An error occurred during book registration.</h2>");
            out.println("    <button onclick='redirectToRegistration()'>Go to Book Registration</button>");
            out.println("    <script>");
            out.println("    function redirectToRegistration() {");
            out.println("        window.location.href = 'book-registration.html';");
            out.println("    }");
            out.println("    </script>");
            out.println("</body></html>");
        }
    }
}

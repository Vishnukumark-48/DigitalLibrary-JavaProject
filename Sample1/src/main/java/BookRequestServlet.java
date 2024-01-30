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

@WebServlet("/BookRequestServlet")
public class BookRequestServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        // Retrieve book details from the form
        String bookName = request.getParameter("bookName");
        String authorName = request.getParameter("authorName");

        try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ngpdb", "root", "");
             PreparedStatement preparedStatement = con.prepareStatement("INSERT INTO bookreq (`Book Name`, `Author Name`) VALUES (?, ?)")) {

            preparedStatement.setString(1, bookName);
            preparedStatement.setString(2, authorName);

            int rowsAffected = preparedStatement.executeUpdate();

            out.println("<html><head>");
            out.println("<style>");
            out.println("body {");
            out.println("    display: flex;");
            out.println("    align-items: center;");
            out.println("    justify-content: center;");
            out.println("    height: 100vh;");
            out.println("    margin: 0;");
            out.println("    font-family: 'Arial', sans-serif;");
            out.println("    background-color: #f0f0f0;");
            out.println("}");

            out.println(".container {");
            out.println("    background-color: #fff;");
            out.println("    border-radius: 8px;");
            out.println("    box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);");
            out.println("    padding: 20px;");
            out.println("    text-align: center;");
            out.println("    width: 400px;");
            out.println("    margin: 0 auto;");
            out.println("}");

            out.println("h2 {");
            out.println("    margin-bottom: 20px;");
            out.println("    color: #4caf50;");
            out.println("}");

            out.println("label {");
            out.println("    display: block;");
            out.println("    margin-bottom: 5px;");
            out.println("    font-weight: bold;");
            out.println("    text-align: left;");
            out.println("}");

            out.println("input, select {");
            out.println("    width: calc(100% - 20px);");
            out.println("    padding: 8px;");
            out.println("    margin-bottom: 10px;");
            out.println("    box-sizing: border-box;");
            out.println("    border: 1px solid #ccc;");
            out.println("    border-radius: 4px;");
            out.println("    text-align: left;");
            out.println("}");

            out.println("button {");
            out.println("    background-color: #333;");
            out.println("    color: #fff;");
            out.println("    padding: 10px 15px;");
            out.println("    border: 1px solid #333;");
            out.println("    border-radius: 5px;");
            out.println("    cursor: pointer;");
            out.println("    margin: 0 auto;");
            out.println("    display: block;");
            out.println("}");

            out.println("button:hover {");
            out.println("    background-color: red;");
            out.println("    color: #fff;");
            out.println("}");
            out.println("</style>");
            out.println("</head>");

            out.println("<body style=\"background-image: url('https://images.pexels.com/photos/1097930/pexels-photo-1097930.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=2'); background-size: cover;\">");

            if (rowsAffected > 0) {
                out.println("<div class='container'>");
                out.println("    <h2 style='color: green;'>Book request successful!</h2>");
                out.println("    <button onclick='redirectToRequest()'>Go to Home</button>");
            } else {
                out.println("<div class='container' style='color: red;'>");
                out.println("    <h2>Error in book request.</h2>");
                out.println("    <button onclick='redirectToRequest()'>Go to Home</button>");
            }

            out.println("<script>");
            out.println("function redirectToRequest() {");
            out.println("    window.location.href = 'welcome.html';");
            out.println("}");
            out.println("</script>");
            out.println("</div>");

            out.println("</body></html>");

        } catch (SQLException e) {
            e.printStackTrace();
            out.println("<html><body style='color: red;'>");
            out.println("    <h2>An error occurred during book request.</h2>");
            out.println("    <button onclick='redirectToRequest()'>Go to Home</button>");
            out.println("    <script>");
            out.println("    function redirectToRequest() {");
            out.println("        window.location.href = 'welcome.html';");
            out.println("    }");
            out.println("    </script>");
            out.println("</body></html>");
        }
    }
}

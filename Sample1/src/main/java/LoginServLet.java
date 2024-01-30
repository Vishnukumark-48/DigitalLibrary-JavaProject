import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/LoginServLet")
public class LoginServLet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public LoginServLet() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.getWriter().append("Served at: ").append(request.getContextPath());
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String name = request.getParameter("name");
        String pass = request.getParameter("password");
        CheckDatabase obj = new CheckDatabase(name, pass, response);
        obj.check();
        // Note: Calling doGet might not be necessary here, depending on your use case.
        // If you want to handle the response in doPost itself, you can remove the doGet call.
    }
}



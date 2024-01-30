import java.awt.Desktop;
import java.net.URI;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Servlet implementation class BookpresentServlet
 */
@WebServlet("/BookpresentServlet")
public class BookpresentServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public BookpresentServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // TODO Auto-generated method stub
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // TODO Auto-generated method stub
        String name = request.getParameter("bookName");
        String pass = request.getParameter("authorName");
        BookcheckDatabase obj = new BookcheckDatabase(name, pass, response);
        obj.check();

        doGet(request, response);
        response.setContentType("text/html");
        try (PrintWriter out = response.getWriter()) {
            out.println("<html><head><title>Registration Status</title>");
            out.println("<style>");
            out.println("body { font-family: 'Arial', sans-serif; background-color: #f0f0f0; text-align: center;background-size: cover;\r\n"
            		+ "            background-image: url(https://images.pexels.com/photos/1097930/pexels-photo-1097930.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=2); display: flex; align-items: center; justify-content: center; height: 100vh; margin: 0; }");
            out.println("h2 { color: #333; }");
            out.println("p { color: #555; margin: 20px 0; }");
            
            
            out.println("form { margin-top: 20px; }");
            // Updated button style
            out.println("input[type='submit'] { padding: 10px 20px; font-size: 16px; background-color: #333; color: #fff; border: 1px solid #333; border-radius: 5px; cursor: pointer; }");
            out.println("input[type='submit']:hover { background-color: red; }");
            out.println("</style>");
            out.println("</head><body>");
            out.println("<div>");
            out.println("<h2>Want to Search a New Book ?</h2>");
//            out.println("<p>" + consoleMessages.toString() + "</p>");
            
            // Updated styled login button to redirect to Login.html
            out.println("<form action='home.html'>");
            out.println("<input type='submit' value='Go to Home'/>");
            out.println("</form>");
            out.println("</div>");
            out.println("</body></html>");
        }
    }

}

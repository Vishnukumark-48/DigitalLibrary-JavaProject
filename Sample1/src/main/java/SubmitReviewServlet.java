import java.io.IOException;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/SubmitReviewServlet")
public class SubmitReviewServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) {
        String username = request.getParameter("username");
        int rating = Integer.parseInt(request.getParameter("rating"));
        String review = request.getParameter("review");

        UserReviewDAO userReviewDAO = new UserReviewDAO();
        userReviewDAO.insertReview(username, rating, review);

        // Redirect or forward to another page as needed
        // For example, redirect to a confirmation page
        try {
			response.sendRedirect("confirmation.jsp");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
}

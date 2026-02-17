import jakarta.servlet.*;
import jakarta.servlet.http.*;
import java.io.IOException;

public class StudentServlet extends HttpServlet {

    protected void doPost(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {

        String name = req.getParameter("name");
        String email = req.getParameter("email");
        String course = req.getParameter("course");

        Student s = new Student(name, email, course);

        boolean status = StudentDAO.addStudent(s);

        if (status) {
            res.sendRedirect("index.html");
        } else {
            res.getWriter().println("Error adding student");
        }
    }
}

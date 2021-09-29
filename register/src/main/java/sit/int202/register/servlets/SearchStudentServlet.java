package sit.int202.register.servlets;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import sit.int202.register.models.Student;
import sit.int202.register.models.StudentRepository;


import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "SearchStudent", value = "/search-student")
public class SearchStudentServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/SearchStudent.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        StudentRepository studentRepository = new StudentRepository();
        String paramId = request.getParameter("id");
        Integer id = null;
        if (paramId != null) {
            id = Integer.valueOf(paramId);
        }
        Student student = studentRepository.find(id);
        try (PrintWriter out = response.getWriter()) {
            out.println("<html>");
            out.println("<body style='padding: 100px'>");
            out.println("<h3>Student List ::</h3><hr>");
            out.println("<table>");
            if (student  != null) {
                out.println("<tr><td>Id: </td> <td>" + ((Student) student).getId() + "</td></tr>");
                out.println("<tr><td>Name: </td> <td>" + student.getName() + "</td></tr>");
                out.println("<tr><td>GPAX: </td> <td>" + student.getGpax() + "</td></tr>");
                out.println("<tr><td colspan='2'><hr></td></tr>");
            } else {
                out.println("<tr><td> Student ID: '" + paramId + "' does not exist !!</td></tr>");
            }
            out.println("</table>");
            out.println("</body>");
            out.println("</html>");
        }
    }
}
package sit.int202.register.servlets;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import sit.int202.register.models.StudentRepository;


import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "StudentListServlet", value = "/student-list")
public class StudentListServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        StudentRepository studentRepository = new StudentRepository();
        request.setAttribute("students", studentRepository.all());
        getServletContext().getRequestDispatcher("/StudentList.jsp").forward(request, response);
    }


//        Old -- in doGet() method
//        try (PrintWriter out = response.getWriter()) {
//            out.println("<html>");
//            out.println("<body style='padding-left: 100px'>");
//            out.println("<h3>Student List ::</h3><hr>");
//            out.println("<table>");
//            for (Student student : studentRepository.all()) {
//                out.println("<tr><td>Id: </td> <td>" + student.getId() + "</td></tr>");
//                out.println("<tr><td>Name: </td> <td>" + student.getName() + "</td></tr>");
//                out.println("<tr><td>GPAX: </td> <td>" + student.getGpax() + "</td></tr>");
//                out.println("<tr><td colspan='2'><hr></td></tr>");
//            }
//            out.println("</table>");
//            out.println("<hr>");
//            out.println("<a href='index.jsp'> Back to Index </a>");
//            out.println("</body>");
//            out.println("</html>");
//        }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}

package sit.int202.register.servlets;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import sit.int202.register.models.CourseRegistered;
import sit.int202.register.models.Student;
import sit.int202.register.models.StudentRepository;

import java.io.IOException;
import java.util.Map;

@WebServlet(name = "RemoveStudentServlet", value = "/remove-student")
public class RemoveStudentServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/RemoveStudent.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Map<String, String[]> parameterMap = request.getParameterMap();

        int id = Integer.valueOf(parameterMap.get("id")[0]);

        StudentRepository studentRepository = new StudentRepository();

        HttpSession session = request.getSession();

        request.setAttribute("id", studentRepository.remove(id));

        getServletContext().getRequestDispatcher("/index.jsp").forward(request,response);

    }
}

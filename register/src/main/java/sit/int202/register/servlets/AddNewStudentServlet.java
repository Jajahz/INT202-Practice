package sit.int202.register.servlets;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import sit.int202.register.models.Student;
import sit.int202.register.models.StudentRepository;


import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "AddNewStudentServlet", value = "/add-new-student")
public class AddNewStudentServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/StudentForm.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        String name = request.getParameter("name");
        String gpax = request.getParameter("gpax");
        // validate request parameters
        Student student = new Student(Integer.valueOf(id), name, Double.valueOf(gpax));
        StudentRepository studentRepository = new StudentRepository();
        studentRepository.save(student);
//        getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
        request.setAttribute("newStudent", student);
        getServletContext().getRequestDispatcher("/NewStudentInfo.jsp").forward(request, response);
    }
}

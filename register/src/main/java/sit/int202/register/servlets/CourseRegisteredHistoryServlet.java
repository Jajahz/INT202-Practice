package sit.int202.register.servlets;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "CourseRegisteredHistoryServlet", value = "/course-registered-history")
public class CourseRegisteredHistoryServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(false);
        if(session == null || session.getAttribute("courseRegistered") == null){
            request.setAttribute("message", "ไม่มีข้อมูล การลงทะเบียน ขอให้ลงทะเบียนก่อน");
        }
        getServletContext().getRequestDispatcher("/ShowRegisterHistory.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}

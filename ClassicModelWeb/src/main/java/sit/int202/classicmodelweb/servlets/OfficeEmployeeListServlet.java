package sit.int202.classicmodelweb.servlets;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import sit.int202.classicmodelweb.repositories.OfficeRepository;

import java.io.IOException;

@WebServlet(name = "OfficeEmployeeListServlet", value = "/office-list")
public class OfficeEmployeeListServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        OfficeRepository officeRepository = new OfficeRepository();
        request.setAttribute("offices", officeRepository.findAll());
        String officeCode = request.getParameter("officeCode");
        if (officeCode != null || officeCode.length() > 0) {
            request.setAttribute("selectedOffice", officeRepository.find(officeCode));
        }
//        getServletContext().getRequestDispatcher("/OfficeList.jsp").forward(request, response);

        Cookie ck = new Cookie("lastpage", "office-list");
        ck.setMaxAge(7*24*60*60);
        response.addCookie(ck);

        getServletContext().getRequestDispatcher("/OfficeListPart.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}

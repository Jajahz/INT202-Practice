package sit.int202.classicmodelweb.filters;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebFilter(filterName = "AuthenticationFilter", servletNames = {"OfficeEmployeeListServlet"})
public class AuthenticationFilter implements Filter {
    private FilterConfig config;

    public void init(FilterConfig config) throws ServletException {
        this.config = config;
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        HttpSession session = ((HttpServletRequest) request).getSession(false);
        if(session==null || session.getAttribute("user")==null) {
            ((HttpServletResponse) response).sendError(HttpServletResponse.SC_UNAUTHORIZED);
            return;
        }
        if(session.getAttribute("role") == "admin"){
            chain.doFilter(request,response);
            RequestDispatcher dispatcher = request.getRequestDispatcher("/135/admin/");
            dispatcher.forward(request, response);
        } else if (session.getAttribute("role") == "user") {
        chain.doFilter(request, response);
            RequestDispatcher dispatcher = request.getRequestDispatcher("/135/user/");
            dispatcher.forward(request, response);
    } else {
            chain.doFilter(request, response);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/");
        dispatcher.forward(request, response);

    }
        chain.doFilter(request,response);
    }

    public void destroy() {
    }
}
package sit.int202.classicmodelweb.servlets;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import sit.int202.classicmodelweb.entities.Product;
import sit.int202.classicmodelweb.repositories.ProductRepository;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "ProductListServlet", value = "/product-list")
public class ProductListServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String page = request.getParameter("page");
        String pageSize = request.getParameter("pageSize");
        int startItem = 0;
        int itemPerPage = 10;
        if (pageSize != null) {
            itemPerPage = Integer.valueOf(pageSize);
        }
        if (page != null) {
            startItem = (Integer.valueOf(page) - 1) * itemPerPage;
        }
        ProductRepository productRepository = new ProductRepository();
        List<Product> productList = null;
        productList = productRepository.findAll(startItem, itemPerPage);
        request.setAttribute("products", productList);
        request.setAttribute("page", page == null ? "1" : page);
        request.setAttribute("pageSize", itemPerPage);
        request.setAttribute("itemCount", productRepository.countAll());
        int itemCount = productRepository.countAll();
        int totalPage = itemCount / itemPerPage + (itemCount % itemPerPage == 0 ? 0 : 1);
        request.setAttribute("totalPage", totalPage);

        Cookie ck = new Cookie("lastpage", "product-list");
        ck.setMaxAge(7*24*60*60);
        response.addCookie(ck);

        getServletContext().getRequestDispatcher("/ProductList.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}

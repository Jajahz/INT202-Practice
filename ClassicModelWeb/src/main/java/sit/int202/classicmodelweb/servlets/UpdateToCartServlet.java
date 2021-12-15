package sit.int202.classicmodelweb.servlets;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import sit.int202.classicmodelweb.entities.Product;
import sit.int202.classicmodelweb.models.Cart;
import sit.int202.classicmodelweb.models.ClassicModelLineItem;
import sit.int202.classicmodelweb.repositories.ProductRepository;

import java.io.IOException;

@WebServlet(name = "UpdateToCartServlet", value = "/update-to-cart")
public class UpdateToCartServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String productCode = request.getParameter("productCode");
        String newQuantity = request.getParameter("quantity");
        HttpSession session = request.getSession();
        Cart<String, ClassicModelLineItem> cart = (Cart)
                session.getAttribute("cart");
        ProductRepository productRepository = new ProductRepository();
        Product product = productRepository.find(productCode);
        if(Integer.valueOf(newQuantity) == 0){
            cart.removeItem(productCode);
        }else if(product != null || Integer.valueOf(newQuantity) > 0){
            cart.updateItem(productCode, Integer.valueOf(newQuantity));
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}

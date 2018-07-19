/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package naborBeauty.controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import naborBeauty.business.Product;
import naborBeauty.data.ProductDB;
/**
 *
 * @author hyejeongkim
 */
@WebServlet(name = "DeleteServlet", urlPatterns = {"/Delete"})
public class DeleteServlet extends HttpServlet {

    /**
     * doGet method to delete a product which has specific product code from database. 
     * after delete a product, application will display total products list again. 
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException 
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String code = request.getParameter("productCode");
        String yes = request.getParameter("yes");
        HttpSession session = request.getSession();
        ServletContext sc = this.getServletContext();
       
        Product product = ProductDB.selectProduct(request.getParameter("productCode"));
        session.setAttribute("product", product);
        String url = "";
        
        if (yes == null){
            url = "/deleteProduct.jsp";
            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(url);
            dispatcher.forward(request, response);
                    
        } if("yes".equals(yes)){
            ProductDB.delete(product);
            url = "/ManagementPos";
            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(url);
            dispatcher.forward(request, response);
        } 
    }
    

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }
}

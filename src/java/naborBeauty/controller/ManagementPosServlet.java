/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package naborBeauty.controller;

import naborBeauty.business.Product;
import naborBeauty.data.ProductDB;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.*;
import javax.servlet.http.*;
/**
 *
 * @author hyejeongkim
 */
public class ManagementPosServlet extends HttpServlet {
    /**
     * doPost method which get list of product from database and dispatch to displayProduct.jsp 
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException 
     */
    @Override
    protected void doPost(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {
        ServletContext sc = getServletContext(); 

        List<Product> products = ( List) ProductDB.selectAllProduct();
       HttpSession session = request.getSession(true);
       session.setAttribute("products", products);

       RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/displayProducts.jsp");
       dispatcher.forward(request, response);

    }
    
    @Override
    protected void doGet(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }
    
}
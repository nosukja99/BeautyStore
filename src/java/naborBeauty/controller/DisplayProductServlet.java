/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package naborBeauty.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
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
@WebServlet(name = "DisplayProductServlet", urlPatterns = {"/DisplayProduct"})
public class DisplayProductServlet extends HttpServlet {
    /**
     * doGet method which will display product which was selected by user.
     * It will display all information of a product 
     * 
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException 
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        ServletContext sc = getServletContext();
        HttpSession session = request.getSession(true);
        String message = "";
        session.setAttribute("message", message);             
        
      if(request.getParameter("productCode") == null){
            Product product = new Product();
            session.setAttribute("product", product); 
            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/addProduct.jsp");
            dispatcher.forward(request, response);
        }else{   
            Product product = ProductDB.selectProduct(request.getParameter("productCode"));
            session.setAttribute("product", product);

            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/addProduct.jsp");
            dispatcher.forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }
}
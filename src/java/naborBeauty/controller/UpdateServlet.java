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
@WebServlet(name = "UpdateServlet", urlPatterns = {"/Update"})
public class UpdateServlet extends HttpServlet {
/**
 * doGet method which update product from database.
 * If there are missing info, it will display appropriate message and if the code was already existed it will get the product from
 * database and update it with new info. If the code is not existed it will make a new product and save it to database. 
 * @param request
 * @param response
 * @throws ServletException
 * @throws IOException 
 */
@Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String code = request.getParameter("ProductCode");
        String description = request.getParameter("ProductDescription");
        double price = Double.parseDouble(request.getParameter("ProductPrice"));
        int productQty = Integer.parseInt(request.getParameter("ProductQty"));
        //System.out.println("prodect qty change"+ productQty);
        
        HttpSession session = request.getSession();
        String message = "";
        ServletContext sc = this.getServletContext();
        
        message = (String)session.getAttribute("message");
        String url = "";
        Product p1 = null;
        if ((code.isEmpty()) || (description.isEmpty() || (price==0))){
            message = "You must enter in all information";
            session.setAttribute("message", message);
            url = "/addProduct.jsp";
        }else{
            if((p1=ProductDB.codeExists(code))!=null){
                
                p1.setProductID(p1.getProductID());
                p1.setCode(code);
                p1.setDescription(description);
                p1.setPrice(price);
                p1.setProductQty(productQty);
                ProductDB.update(p1);
                url="/DisplayProduct?productCode="+p1.getCode();
            }else{
                Product p2 = new Product();
                p2.setCode(code);
                p2.setDescription(description);
                p2.setPrice(price);
                p2.setProductQty(productQty);
                System.out.println(productQty+"should be 60");
                ProductDB.insert(p2);
                url="/DisplayProduct?productCode="+p2.getCode();
            }
        }
       RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(url);
            dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            doGet(request, response);
    }
}



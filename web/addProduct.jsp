<%@page import="naborBeauty.business.Product"%>
<%@page import="java.util.Enumeration"%>
<%@page import="naborBeauty.business.Product"%>
<%@page import="java.util.ArrayList"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>Add new Inventory</title>
    <link rel="stylesheet" href="styles/main.css" type="text/css"/>
</head>
<body>
    <img src="image/naborlogo.JPG" alt="Nabor Beauty Logo" width="100"/>
    <h1>Product</h1>
    
    <i>Please enter a description for the product</i>
    <br>
    <br>  
    <%
    Product prod = (Product)session.getAttribute("product");
    String message = (String) session.getAttribute("message");
%>  
        <%=message%>
        <br>
        <br>
  <form action="Update" method="get"> 
       
      Product Code: <input type="text" name="ProductCode" value="<%=prod.getCode()%>"> <br>
      Product Description: <input type="text" name="ProductDescription" value="<%=prod.getDescription()%>">   <br>
      Product Price: <input type="text" name="ProductPrice" value="<%=prod.getPrice()%>"><br>
      Product Quantity: <input type="text" name="ProductQty" value="<%=prod.getProductQty()%>"><br>

         <br>
        <input type="submit" name="updateProduct" value="Update Product">
        </form> 
    <form action="ManagementPos" method="get">
         <input type="submit" name="viewProducts" value="View Products">
         </form>
      
</body>
</html>
<%@page import="java.util.List"%>
<%@page import="naborBeauty.business.Product"%>
<%@page import="java.util.ArrayList"%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>Nabor Beauty Products List</title>
    <link rel="stylesheet" href="styles/main.css" type="text/css"/>
</head>
<body>
    <img src="image/naborlogo.JPG" alt="Nabor Beauty Logo" width="100"/>
    <h1>Current Products</h1>
<table>
    <tr>
      <td>Code</td>
      <td>Description</td>
      <td>Price</td>
      <td>Inventory</td>
      <th>&nbsp;</th>
      <th>&nbsp;</th>
    </tr>
            <%
               List<Product> hjprod1 = (List)session.getAttribute("products");

              for(int i = 0; i<hjprod1.size(); i++){
                   Product hjprod = hjprod1.get(i);

           %>
    <tr>
                    <td><%=hjprod.getCode()%></td>
                    <td><%=hjprod.getDescription()%></td>
                    <td><%=hjprod.getPrice()%></td>
                    <td><%=hjprod.getProductQty()%></td>
                    <td><a href="DisplayProduct?productCode=<%=hjprod.getCode()%>">EDIT</a></td>
                    <td><a href="Delete?productCode=<%=hjprod.getCode()%>">DELETE</a></td>
                </tr>
                <% } %>
   
</table>
<br>
            <form action="DisplayProduct" method="get">
                <input type="submit" value="Add Product">
            </form>  
</body>
</html>
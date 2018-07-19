<%@page import="naborBeauty.business.Product"%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>Product Maintenance</title>
    <link rel="stylesheet" href="styles/main.css" type="text/css"/>
</head>
<body>
    <img src="image/naborlogo.JPG" alt="Nabor Beauty Logo" width="100"/>
    <%
Product product = (Product)session.getAttribute("product");         
%> 
    <h1>Are you sure you want to delete this product?</h1>
    Product Code: <%=product.getCode()%> <br/>
        Product Description: <%=product.getDescription()%> <br/>
        Product Price: <%=product.getPrice()%> <br/>
        
        <form action="Delete">
            <input type="submit" value="Yes"/>
            <input type="hidden" name="productCode" value="<%=product.getCode()%>" />
            <input type="hidden" name="yes" value="yes"/>
        </form>
        <form action="ManagementPos">
            <input type="submit" value="No"/>
        </form>
        
    </body>
</html>
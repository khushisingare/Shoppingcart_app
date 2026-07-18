<%@page import="java.util.ArrayList"%>
<%@page import="com.dao.ShoppingCartDAO"%>
<%@page import="com.model.ShoppingCartItem"%>
<%@ page language="java"
    contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Shopping Cart</title>

<link rel="stylesheet" href="style.css">

</head>

<body>

<div class="container">

<h1>Shopping Cart</h1>

<a href="addItem.jsp">
<button class="addBtn">Add Item</button>
</a>

<br><br>

<table>

<tr>
<th>ID</th>
<th>Item Name</th>
<th>Price</th>
<th>Action</th>
</tr>

<%

ShoppingCartDAO dao = new ShoppingCartDAO();

ArrayList<ShoppingCartItem> list = dao.getAllItems();

for(ShoppingCartItem item : list)
{

%>

<tr>

<td><%=item.getId()%></td>

<td><%=item.getName()%></td>

<td>₹ <%=item.getPrice()%></td>

<td>

<a href="RemoveItemServlet?id=<%=item.getId()%>">

<button class="removeBtn">

Remove

</button>

</a>

</td>

</tr>

<%

}

%>

</table>

</div>

</body>
</html>
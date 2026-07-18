<%@ page language="java"
    contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>

<meta charset="UTF-8">

<title>Add Item</title>

<link rel="stylesheet" href="style.css">

</head>

<body>

<div class="container">

<h1>Add Item</h1>

<form action="AddItemServlet" method="post">

<label>Item Name</label>

<input
type="text"
name="name"
required>
<br>
<br>

<label>Price</label>

<input
type="number"
step="0.01"
name="price"
required>
<br>
<br>

<input
type="submit"
value="Add Item"
class="addBtn">

</form>

<br>

<a href="index.jsp">

<button class="backBtn">

Back

</button>

</a>

</div>

</body>

</html>
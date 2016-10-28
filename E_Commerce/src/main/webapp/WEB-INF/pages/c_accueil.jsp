
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<link href="<c:url value="/resources/styles/bootstrap.min.css" />"
	rel="stylesheet">
<script src="<c:url value="/resources/javascript/bootstrap.min.js" />"></script>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">


<style>
body {
	margin: 0;
}

ul {
	list-style-type: none;
	margin: 0;
	padding: 0;
	width: 15%;
	background-color: #f1f1f1;
	position: fixed;
	height: 100%;
	overflow: auto;
}

li a {
	display: block;
	color: #000;
	padding: 8px 16px;
	text-decoration: none;
}

li a.active {
	background-color: #4CAF50;
	color: white;
}

li a:hover:not (.active ) {
	background-color: #555;
	color: white;
}

table {
	margin-left:17%;
    border-collapse: collapse;
    width: 100%;
}

th, td {
    text-align: left;
    padding: 8px;
}

tr:nth-child(even){background-color: #f2f2f2}

th {
    background-color: #4CAF50;
    color: white;
}
</style>


<title>E-commerce</title>

</head>
<body>

	<!-- ===============================Nav Catégorie================================ -->
	<ul>
		<li><a class="active" href="accueil" ><h3 style="font-weight: bold;">Catégorie</h3></a></li>
		<c:forEach var="cat" items="${cat_liste}">

			<li><a href="catProduit/${cat.nom}">${cat.nom}</a></li>

		</c:forEach>
	</ul>
	<!-- ============================================================================ -->
	<div style="width: 75%; padding: 15px; margin-left: 2%;">
	<table>
		<tr>
		<th style="">Produit</th>
		<th>Prix</th>
		</tr>
		<c:forEach var="prod" items="${prod_liste}">
			<tr>
			<td><h4 style="font-weight: bold;">${prod.nom}</h4> <br/> ${prod.description}</td>
			<td>${prod.prix}</td>
			</tr>
		</c:forEach>
	</table>
	</div>

</body>
</html>
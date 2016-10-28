<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link href="<c:url value='/resources/styles/bootstrap.min.css' />" rel="stylesheet">
<script src="<c:url value="/resources/javascript/bootstrap.min.js" />"></script>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>

<style>
body {
    margin: 0;
}

ul {
    list-style-type: none;
    margin: 0;
    padding: 0;
    width: 25%;
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

li a:hover:not(.active) {
    background-color: #555;
    color: white;
}

div{
	width: 75%;
    float: right;
    padding: 15px;
}



table {
    font-family: arial, sans-serif;
    border-collapse: collapse;
    width: 100%;
}

td, th {
    border: 1px solid #dddddd;
    text-align: left;
    padding: 8px;
}

tr:nth-child(even) {
    background-color: #dddddd;
}


</style>

</head>
<body>


<ul>
  <li><a class="active" href="gestAccueil">Produits</a></li>
  <li><a href="#news">Categorie</a></li>
  <li><a href="#contact">Client</a></li>
</ul>

	<div>

		<table>
			
			<tr bgcolor="grey" style="color: white">
				<th>Id</th>
				<th>Nom</th>
				<th>Description</th>
				<th>Prix</th>
				<th>Quantite</th>
				<th>Selection</th>
			</tr>

			<c:forEach var="prod" items="${listeProd}">
				<tr>
					<td>${prod.id_produit}</td>
					<td>${prod.nom}</td>
					<td>${prod.description}</td>
					<td>${prod.prix}</td>
					<td>${prod.quantite}</td>
					<td>${prod.selection}</td>
				</tr>
			</c:forEach>
			
		</table>

	</div>

</body>
</html>
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
}

ul.horiz1 {
	width: 80%;
	float: right;
    overflow: hidden;
    background-color: #333;
}

ul.verti {
    width: 20%;
    background-color: #f1f1f1;
    height: 100%; /* Full height */
    position: fixed; /* Make it stick, even on scroll */
    overflow: auto; /* Enable scrolling if the sidenav has too much content */
}

/********************************/

li.horiz1 {
    float: left;
}


li a {
    display: block;
    text-decoration: none;
}


li.verti a {
    color: #000;
    font-size: 15px;
    padding: 14px 16px;
}



li.horiz1 a {
    color: white;
    font-size: 15px;
    text-align: center;
    padding: 14px 16px;
}


/******************************************/


li a.active {
    background-color: #4CAF50;
}

li.horiz1 a.active {
    color: white;
}

li.verti a.active {
    bottom: 0; 
}

/************************************/

li.verti a:hover:not(.active) {
    background-color: #555;
    color: white;
}

li.horiz1 a:hover {
    background-color: #111;
}



table {
    font-family: arial, sans-serif;
    border-collapse: collapse;
    width: 78%;
    float: right;
    margin: 11px;
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



<ul class="verti">
  <li class="verti"><a href="gestAccueil">Produits</a></li>
  <li class="verti"><a href="#gestCategorie">Catégories</a></li>
  <li class="verti"><a href="#gestClient">Clients</a></li>
  <li class="verti"><a class="active" href="#gestDeconnection">Déconnection</a></li>
</ul>

<ul class="horiz1">
  <li class="horiz1"><a class="active" href="formAjProdGest">Ajouter</a></li>
  <li class="horiz1"><a href="#upDProd">Modifier</a></li>
  <li class="horiz1"><a href="#suppProd">Supprimer</a></li>
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
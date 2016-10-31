<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<!--CDN-->

<link rel="stylesheet"
	href="http://netdna.bootstrapcdn.com/bootstrap/3.1.1/css/bootstrap.min.css">

<link rel="stylesheet"
	href="http://netdna.bootstrapcdn.com/bootstrap/3.1.1/css/bootstrap-theme.min.css">

<link href="<c:url value='/resources/styles/bootstrap.min.css' />"
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

li

a

:hover

:not

(
.active

)
{
background-color

:
#555

;
color

:

white

;
}
table {
	margin-left: 17%;
	border-collapse: collapse;
	width: 100%;
}

th, td {
	text-align: left;
	padding: 8px;
}

tr:nth-child(even) {
	background-color: #f2f2f2
}

th {
	background-color: #4CAF50;
	color: white;
}
</style>
<title>Panier</title>
</head>
<body>

	<ul>
		<li><a class="active"
			href="${pageContext.request.contextPath}/index/accueil"><h3
					style="font-weight: bold;">Accueil</h3></a></li>
		<li><a href="${pageContext.request.contextPath}/index/panier/deletePanier">Supprimer panier</a>
	</ul>

	<!-- ===================================Corps==================================== -->
	<br/>
	<h2 style="font-weight: bold;" align="center">Votre panier</h2>
	<div style="width: 75%; padding: 15px; margin-left: 2%;">
		<table>
			<tr>
				<th style="font-weight: bold;">Produit</th>
				<th style="font-weight: bold;">Quantité</th>
				<th style="font-weight: bold;">Prix</th>
				<th></th>
			</tr>
			<c:forEach var="liste" items="${liste}">
				<tr>
					<td><h4 style="font-weight: bold;">${liste.produit.nom}</h4></td>
					<td>${liste.quantite}
						<a href="${pageContext.request.contextPath}/index/panier/plus/${liste.produit.id_produit}">
						<i class="glyphicon glyphicon-plus"></i>
						</a> 
						
						<a href="${pageContext.request.contextPath}/index/panier/moins/${liste.produit.id_produit}">
						<i class="glyphicon glyphicon-minus"></i>
						</a>
					</td>
					<td style="font-weight: bold;">${liste.prix}<i class="glyphicon glyphicon-eur"></i></td>
					<td>
						<a href="${pageContext.request.contextPath}/index/panier/delete/${liste.produit.id_produit}">
						<i class="glyphicon glyphicon-remove"></i>
						</a>
					</td>
				</tr>
			</c:forEach>
			<tr style="border: 2px solid black">
				<td style="font-weight: bold;">Total :</td>
				<td style="font-weight: bold;">${panierActif.nbArticle}</td>
				<td style="font-weight: bold;">${panierActif.prixTotal}<i class="glyphicon glyphicon-eur"></i></td>
			</tr>
		</table>
	</div>
	<!-- ============================================================================ -->
</body>
</html>
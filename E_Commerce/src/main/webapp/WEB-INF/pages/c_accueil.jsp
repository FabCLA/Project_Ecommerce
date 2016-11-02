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


<title>E-commerce</title>

</head>
<body>
	<!-- ==================================Header==================================== -->
	<!-- 	Bouton panier -->
	
		<a
			style="background-color: silver;; color: white; padding: 14px 25px; text-align: center; display: inline-block; float: right; border: 1px solid gray;"
			href="${pageContext.request.contextPath}/gestionnaire/login">
			<div>
				<i class="glyphicon glyphicon-sunglasses"></i>
			</div> <span class="bold">Gestion</span> 
		</a>
	<!-- 	Bouton login -->

			<a
				style="background-color: silver; color: white; padding: 14px 25px; text-align: center; display: inline-block; float: right; border: 1px solid gray;"
				href="${pageContext.request.contextPath}/index/login">
				<div>
					<i style="color: ${loginColor};" class="glyphicon glyphicon-user"></i>
				</div> <span class="bold">Login</span>
			</a>
		
	<!-- 	Bouton panier -->
	
		<a
			style="background-color: silver;; color: white; padding: 14px 25px; text-align: center; display: inline-block; float: right; border: 1px solid gray;"
			href="${pageContext.request.contextPath}/index/panier">
			<div>
				<i class="glyphicon glyphicon-shopping-cart"></i>
			</div> <span class="bold">Panier</span> <span>(${panierActif.nbArticle})</span>
		</a>

	<!-- ============================================================================ -->
	<!-- ===============================Nav Catégorie================================ -->
	<ul>
		<li><a class="active"
			href="${pageContext.request.contextPath}/index/accueil"><h3
					style="font-weight: bold;">E-Commerce</h3></a></li>
		<c:forEach var="cat" items="${cat_liste}">

			<li><a
				href="${pageContext.request.contextPath}/index/catProduit/${cat.nom}">${cat.nom}</a></li>

		</c:forEach>
	</ul>
	<!-- ============================================================================ -->
	<!-- ===================================Corps==================================== -->
	<br/>
	<h2 style="font-weight: bold;margin-left: 250px;" align="center">Bienvenue sur ce site d'Ecommerce</h2>
	<div style="width: 75%; padding: 15px; margin-left: 2%;">
		<table style="border: 1px solid green">
			<tr>

				<th style="font-weight: bold;">Produit</th>
				<th style="font-weight: bold;">Prix</th>
				<th style="font-weight: bold;">En Stock</th>
				<th></th>
			</tr>
			<c:forEach var="prod" items="${prod_liste}">
				<tr style="border: 1px solid green">

					<td><h4 style="font-weight: bold;">${prod.nom}</h4> <br />
						${prod.description}</td>
					<td>${prod.prix} <i class="glyphicon glyphicon-eur"></i></td>
					<td>${prod.quantite}</td>
					<td>
						<a  href="${pageContext.request.contextPath}/index/addProd/${prod.id_produit}">
								<i class="glyphicon glyphicon-shopping-cart"></i>
							</div>
					</a></td>
				</tr>
			</c:forEach>
		</table>
	</div>
	<!-- ============================================================================ -->

</body>
</html>
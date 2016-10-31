<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link href="<c:url value='/resources/styles/bootstrap.min.css' />"
	rel="stylesheet">
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
	overflow: auto;
	/* Enable scrolling if the sidenav has too much content */
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
li.verti a:hover:not (.active ) {
	background-color: #555;
	color: white;
}

li.horiz1 a:hover {
	background-color: #111;
}

div.container {
	width: 78%;
	float: right;
	margin-top: 40px;
}
</style>

</head>
<body>



	<ul class="verti">
		<li class="verti"><a href="gestAccueil">Produits</a></li>
		<li class="verti"><a href="#gestCategorie">Cat�gories</a></li>
		<li class="verti"><a href="#gestClient">Clients</a></li>
		<li class="verti"><a class="active" href="#gestDeconnection">D�connection</a></li>
	</ul>

	<ul class="horiz1">
		<li class="horiz1"><a class="active" href="formAjProdGest">Ajouter</a></li>
		<li class="horiz1"><a href="gestUpDProd">Modifier</a></li>
		<li class="horiz1"><a href="formDelProdGest">Supprimer</a></li>
	</ul>

	<div class="container">
		<form class="form-horizontal" method="post" action="gestDelProd" modelAttribute="produit">
			<div class="form-group">
				<label class="control-label col-sm-3" for="prod">Produit � supprimer</label>
				<div class="col-sm-7">
					<select class="form-control" id="prod" name="categorie">
						<c:forEach var="produits" items="${produitList}">
							<option>${produits.nom}	${produits.prix}	${produits.quantite}	${produits.categorie.nom}</option>
						</c:forEach>
					</select>
				</div>
				<br>

			</div>
			<div class="form-group">
				<div class="col-sm-offset-3 col-sm-7">
					<button type="submit" class="btn btn-primary">Supprimer</button>
				</div>
			</div>
		</form>
	</div>


</body>
</html>
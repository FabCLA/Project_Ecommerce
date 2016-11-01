<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

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

</style>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<title>Connexion</title>
</head>
<body>
	<!-- ===================================Nav====================================== -->
	<ul>
		<li><a class="active"
			href="${pageContext.request.contextPath}/index/accueil"><h3
					style="font-weight: bold;">E-Commerce</h3></a></li>
		<li><a
				href="${pageContext.request.contextPath}/index/modifClient/">Modifier</a></li>
		<li><a
				href="${pageContext.request.contextPath}/index/logout/">Déconnexion</a>
		</li>
	</ul>
	<!-- ============================================================================ -->
	<br/>
	<!-- ===============================Identification=============================== -->
	<table class="blanc" style="margin-left: 250px; width: 80%;">
		<tr>
			<th>
				<div
					style="width: 70%;padding: 10px; border: 1px solid green; border-left: 4px solid green; ">
					<h4 align="center">Déjà inscrit</h4>
					<form style="padding: 15px; width: 95%;" class="form-horizontal"
						method="post" action="findClient" modelAttribute="client">
						<div class="form-group">
							<label for="email">Adresse mail :</label> <input type="email"
								class="form-control" id="email" name="mail">
						</div>
						<div class="form-group">
							<label for="pwd">Password:</label> <input type="password"
								class="form-control" id="pwd" name="password">
						</div>
						<button type="submit" class="btn btn-default">Login</button>
					</form>
				</div>
			</th>
			<!-- ============================================================================ -->

			<th>
				<div
					style="width: 70%; padding: 10px; border: 1px solid green; border-left: 4px solid green;">
					<h4 align="center">Nouveau membre</h4>
					<form style="padding: 15px; width: 95%;" class="form-horizontal"
						method="post" action="addClient" modelAttribute="client">
						<div class="form-group">
							<label for="nom">Nom :</label> <input type="text"
								class="form-control" id="nom" name="nom">
						</div>
						<div class="form-group">
							<label for="adresse">Adresse :</label> <input type="text"
								class="form-control" id="adresse" name="adresse">
						</div>
						<div class="form-group">
							<label for="tel">Telephone :</label> <input 
								class="form-control" id="tel" name="tel">
						</div>
						<div class="form-group">
							<label for="email">Adresse mail :</label> <input type="text"
								class="form-control" id="email" name="mail">
						</div>
						<div class="form-group">
							<label for="pwd">Password:</label> <input type="password"
								class="form-control" id="pwd" name="password">
						</div>
						<button type="submit" class="btn btn-default">Inscription</button>
					</form>
				</div>
			</th>
		</tr>
	</table>
</body>
</html>
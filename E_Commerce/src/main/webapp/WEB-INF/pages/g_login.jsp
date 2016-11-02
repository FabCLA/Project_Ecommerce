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
<title>Insert title here</title>
</head>
<body>


	<h4 align="center">Identification</h4>

	<form class="form-horizontal" method="post" action="findGest"
		modelAttribute="gestionnaire">

		<div class="form-group">
			<label class="control-label col-sm-3" for="ident">Identifiant:</label>
			<div class="col-sm-7">
				<input type="text" class="form-control" id="ident" name="login">
			</div>
		</div>
		<div class="form-group">
			<label class="control-label col-sm-3" for="mdp">Mot de passe:</label>
			<div class="col-sm-7">
				<input type="password" class="form-control" id="mdp" name="mdp">
			</div>
		</div>

		<div class="form-group">
			<div class="col-sm-offset-3 col-sm-7">
				<button type="submit" class="btn btn-default">Valider</button>
			</div>
		</div>
	</form>

</body>
</html>
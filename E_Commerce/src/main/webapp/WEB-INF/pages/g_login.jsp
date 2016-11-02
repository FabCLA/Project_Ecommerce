<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

				<div
					style="width: 70%;padding: 10px; border: 1px solid green; border-left: 4px solid green; ">
					<h4 align="center">Identification</h4>
					<form style="padding: 15px; width: 95%;" class="form-horizontal"
						method="post" action="findGest" modelAttribute="gestionnaire">
						<div class="form-group">
							<label for="email">Identifiant</label> <input type="text"
								class="form-control" id="ident" name="login">
						</div>
						<div class="form-group">
							<label for="pwd">Mot de passe:</label> <input type="password"
								class="form-control" id="mdp" name="mdp">
						</div>
						<button type="submit" class="btn btn-default">Valider</button>
					</form>
				</div>

</body>
</html>
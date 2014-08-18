<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Prijava</title>

    <link href="<c:url value="/resources/css/bootstrap.min.css" />" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="<c:url value="/resources/css/signin.css" />" rel="stylesheet">

    <!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
      <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
  </head>

  <body>

    <div class="container">

      <form action="j_spring_security_check" method="POST" class="form-signin" role="form">
        <h2 class="form-signin-heading">Prijava</h2>
        <input type="text" name="j_username" class="form-control" placeholder="Korisničko ime" required autofocus>
        <input type="password" name="j_password" class="form-control" placeholder="Lozinka" required>
        <label class="checkbox">
          <input type="checkbox" value="remember-me"> Remember me
        </label>
        <button class="btn btn-lg btn-primary btn-block" type="submit">Prijava</button>
      </form>
      <c:if test="${param.prijava_error == 't' }">
      	<div class="alert alert-danger">
			Unijeli ste pogrešno korisničko ime ili lozinku!
		</div>
      </c:if>
      
      <c:if test="${param.odjava == 't' }">
      	<div class="alert alert-success">
			Uspješno ste se odjavili!
		</div>
      </c:if>

    </div> <!-- /container -->


    <!-- Bootstrap core JavaScript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
  </body>
</html>

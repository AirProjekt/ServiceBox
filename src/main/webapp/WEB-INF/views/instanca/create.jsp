<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Instanca</title>

    <!-- Bootstrap core CSS -->
    <link href="<c:url value="/resources/css/bootstrap.min.css" />" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="<c:url value="/resources/css/navbar.css" />" rel="stylesheet">

    <!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
      <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->

</head>
<body>
<div class="container">

      <!-- Static navbar -->
      <div class="navbar navbar-default" role="navigation">
        <div class="container-fluid">
          <div class="navbar-header">
            <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
              <span class="sr-only">Toggle navigation</span>
              <span class="icon-bar"></span>
              <span class="icon-bar"></span>
              <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href='<spring:url value="/"></spring:url>'>ServiceBox</a>
          </div>
          <div class="navbar-collapse collapse">
            <ul class="nav navbar-nav">
              <li><a href='<spring:url value="/kategorija"></spring:url>'>Kategorija</a></li>
              <li><a href='<spring:url value="/objekt"></spring:url>'>Objekt</a></li>
              <li class="active"><a href='<spring:url value="/instanca"></spring:url>'>Instanca</a></li>
              <li><a href='<spring:url value="/ocjene"></spring:url>'>Ocjene</a></li>
            </ul>
            <ul class="nav navbar-nav navbar-right">
				<li class="dropdown">
                <a href="#" class="dropdown-toggle" data-toggle="dropdown">Odjavi se <b class="caret"></b></a>
                <ul class="dropdown-menu">
                  <li>
                  	<form method="POST" action='<spring:url value="/j_spring_security_logout"></spring:url>' >
						<button type="submit" class="btn btn-link">
							Odjava
						</button>
					</form>
                  </li>
                </ul>
              </li>
            </ul>
          </div><!--/.nav-collapse -->
        </div><!--/.container-fluid -->
      </div>

      <!-- Main component for a primary marketing message or call to action -->
      <div class="jumbotron">
      	<div class="row">
	      	<div class="col-lg-8">
	      		<div class="page-header">
	      			<h3>Unos nove Instance</h3>
	      		</div>
	      		<form:form modelAttribute="instanca" class="form-horizontal">
					<div class="form-group">
						<label for="nazivKolegija" class="col-lg-2 control-label">Naziv:</label>
						<div class="col-lg-6">
							<form:input path="name" size="30" maxlength="50" class="form-control" /><br/>
							<form:errors path="name" cssClass="alert alert-danger" />
						</div>
					</div>
					<div class="form-group">
						<label for="nazivKolegija" class="col-lg-2 control-label">Telefon:</label>
						<div class="col-lg-6">
							<form:input path="telefon" size="30" maxlength="50" class="form-control" /><br/>
							<form:errors path="telefon" cssClass="alert alert-danger" />
						</div>
					</div>
					<div class="form-group">
						<label for="nazivKolegija" class="col-lg-2 control-label">Adresa:</label>
						<div class="col-lg-6">
							<form:input path="adresa" size="30" maxlength="50" class="form-control" /><br/>
							<form:errors path="adresa" cssClass="alert alert-danger" />
						</div>
					</div>
					<div class="form-group">
						<label for="nazivKolegija" class="col-lg-2 control-label">Grad:</label>
						<div class="col-lg-6">
							<form:input path="grad" size="30" maxlength="50" class="form-control" /><br/>
							<form:errors path="grad" cssClass="alert alert-danger" />
						</div>
					</div>
					<div class="form-group">
						<label for="nazivKolegija" class="col-lg-2 control-label">Web:</label>
						<div class="col-lg-6">
							<form:input path="web" size="30" maxlength="50" class="form-control" /><br/>
							<form:errors path="web" cssClass="alert alert-danger" />
						</div>
					</div>
					<div class="form-group">
						<label for="nazivKolegija" class="col-lg-2 control-label">Opis:</label>
						<div class="col-lg-6">
							<form:textarea path="opis" class="form-control" /><br/>
							<form:errors path="opis" cssClass="alert alert-danger" />
						</div>
					</div>
					<div class="form-group">
						<label for="nazivKolegija" class="col-lg-2 control-label">Latituda:</label>
						<div class="col-lg-7">
							<form:input path="latitude" size="30" maxlength="50" class="form-control"/><br/>
							<form:errors path="latitude" cssClass="alert alert-danger" />
						</div>
					</div>
					<div class="form-group">
						<label for="nazivKolegija" class="col-lg-2 control-label">Longituda:</label>
						<div class="col-lg-7">
							<form:input path="longitude" size="30" maxlength="50" class="form-control" /><br/>
							<form:errors path="longitude" cssClass="alert alert-danger" />
						</div>
					</div>
					<div class="form-group">
						<label for="nazivKolegija" class="col-lg-2 control-label">Objekt:</label>
						<div class="col-lg-4">
							<form:select path="objekt.id" cssClass="form-control" items="${ listaObjekt }" itemLabel="name" itemValue="id"></form:select><br/>
							<form:errors path="objekt.id" cssClass="alert alert-danger" />
						</div>
					</div>
					<br>
					<div class="form-group">
					    <div class="col-lg-offset-1 col-lg-1">
					      <input type="submit" value="Spremi" class="btn btn-primary">
					    </div>
				  	</div>
				</form:form>
				<c:if test="${ requestScope['uneseno'] != null }">
					<div class="alert alert-success">
						<c:out value="${ uneseno }"/>
					</div>
				</c:if>
	       	</div>
	       	<div class="col-lg-4">
		       	<ul class="nav nav-pills nav-stacked pull-right">
				  <li><a href='<spring:url value="/instanca"></spring:url>'>Popis Instanci</a></li>
				  <li class="active"><a href='<spring:url value="/instanca?form"></spring:url>'>Ubaci novu</a></li>
				</ul>
			</div>
		</div>
      </div>

    </div> <!-- /container -->
    
    <!-- Bootstrap core JavaScript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
    <script type="text/javascript"
      src="https://maps.googleapis.com/maps/api/js?key=AIzaSyBwc7n1Pgo2pw2p2SJJuezHRQXJna06K74">
    </script>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.0/jquery.min.js"></script>
    <script src="<c:url value="/resources/js/bootstrap.min.js" />"></script>
</body>
</html>
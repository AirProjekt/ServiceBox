<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Objekt</title>

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
              <li class="active"><a href='<spring:url value="/objekt"></spring:url>'>Objekt</a></li>
              <li><a href='<spring:url value="/instanca"></spring:url>'>Instanca</a></li>
              <li><a href='<spring:url value="/ocjene"></spring:url>'>Ocjene</a></li>
            </ul>
            <ul class="nav navbar-nav navbar-right">
				<li class="dropdown">
                <a href="#" class="dropdown-toggle" data-toggle="dropdown">Odjavi se <b class="caret"></b></a>
                <ul class="dropdown-menu">
                  <li>
                  	<form method="POST" action='<spring:url value="j_spring_security_logout"></spring:url>' >
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
	      	<div class="col-lg-4">
	      		<select id="fltr" class=form-control>
	      			<option value="0">--- Select ---</option>
	      			<c:forEach items="${ requestScope[ 'listaKategorija' ] }" var="data">
	      				<option value="${ data.id }">${ data.name }</option>
	      			</c:forEach>
	      		</select>
	      		<br>
	      		<div class="panel panel-primary">
		      		<div class="panel-heading">Objekti</div>
		      		<table class="table table-hover">
						<thead>
							<tr>
					  			<th>#</th>
					  			<th>Name</th>
					  			<th>Kategorija</th>
					  			<th></th>
					  			<th></th>
							</tr>
						</thead>
						<tbody id="objekti">
						</tbody>
					</table>
		       	</div>
	       	</div>
	       	<div class="col-lg-8">
		       	<ul class="nav nav-pills nav-stacked pull-right">
				  <li class="active"><a href='<spring:url value="/objekt"></spring:url>'>Popis Objekata</a></li>
				  <li><a href='<spring:url value="/objekt?form"></spring:url>'>Ubaci novi</a></li>
				</ul>
			</div>
		</div>
      </div>

    </div> <!-- /container -->
    
    <!-- Bootstrap core JavaScript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.0/jquery.min.js"></script>
    <script src="<c:url value="/resources/js/bootstrap.min.js" />"></script>
    <script type="text/javascript">
    $(document).ready(function(){
        $( "#fltr" ).change(function () {
            var str = "";
            $( "#fltr option:selected" ).each(function() {
            	str += $( this ).val();
            });
            $.ajax({
           		type: "POST",
           	    url: "objekt?ajax",
           	    data: { id: str }
           	}).done(function( html ) {
           	    $("#objekti").html(html);
           	});

        }).change();
    });
    </script>
</body>
</html>
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

    <title>Ocjene</title>

    <!-- Bootstrap core CSS -->
    <link href="<c:url value="/resources/css/bootstrap.min.css" />" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="<c:url value="/resources/css/navbar.css" />" rel="stylesheet">
    
    <link href="<c:url value="/resources/css/jquery-ui.css" />" rel="stylesheet">
    
    <link href="<c:url value="/resources/jqgrid/css/ui.jqgrid.css" />" rel="stylesheet">

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
              <li><a href='<spring:url value="/instanca"></spring:url>'>Instanca</a></li>
              <li class="active"><a href='<spring:url value="/ocjene"></spring:url>'>Ocjene</a></li>
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
	      	<div class="col-lg-8">
	      		<div id="mysearch"><br/></div>
			    <br/>   
			
			    <div>
				<table id="list"></table> 
				</div>
				<div id="pager"></div>
	       	</div>
	       	<div class="col-lg-4">
		       	<ul class="nav nav-pills nav-stacked pull-right">
				  <li class="active"><a href='<spring:url value="/ocjene"></spring:url>'>Popis Ocjena</a></li>
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
    <script src="<c:url value="/resources/js/jquery-ui.min.js" />"></script>
    <script src="<c:url value="/resources/jqgrid/js/i18n/grid.locale-en.js" />"></script>
    <script src="<c:url value="/resources/jqgrid/js/jquery.jqGrid.min.js" />"></script>
    <script src="<c:url value="/resources/jqgrid/plugins/grid.addons.js" />"></script>
    <script src="<c:url value="/resources/jqgrid/plugins/jquery.searchFilter.js" />"></script>
    <script type="text/javascript">
    $(function(){      
        $("#list").jqGrid({
          url:'/mobile/ocjene/listgrid',
          datatype: 'json',
          mtype: 'POST',
          colNames:['#', 'Komentari', 'Rating', 'Naziv objekta','Datum',''],
          colModel :[ 
            {name:'id', index:'id', width:35, align:'center'},
            {name:'comment', index:'comment', width:250, sortable:false}, 
            {name:'rating', index:'rating', width:35}, 
            {name:'objekt.name', index:'objekt.name', width:70},
            {name:'date', index:'date', width:70},
            {name : 'actions', index: 'actions', width:35, editable: false, sortable:false, formatter:'actions',
            	formatoptions: {
            	    keys: true,
            	    editbutton: false,
            	    delOptions: { url: '/mobile/ocjene/del' }
            	               }}
          ],
          jsonReader : {
              root:"ocjeneData",
              page: "currentPage",
              total: "totalPages",
              records: "totalRecords",
              repeatitems: false,
              id: "id"
          },      
          pager: '#pager',
          rowNum:10,
          rowList:[10,20,30],
          sortname: 'id',
          sortorder: 'asc',
          viewrecords: true,
          gridview: true,
          height: 220,
          width: 700,
          caption: 'Ocjene',
        });   
        
        $('#mysearch').jqGrid('filterGrid', '#list', { 
      	  filterModel: [
      	    {label: 'Komentar : ', name: 'comment'},
      	    {label: 'Naziv Objekta :', name: 'objektName'}
      	  ],
      	  formtype: 'vertical',
      	  enableSearch: true,
      	  enableClear: true,
      	  autosearch: false,
        });   
         
      });
    </script>
</body>
</html>
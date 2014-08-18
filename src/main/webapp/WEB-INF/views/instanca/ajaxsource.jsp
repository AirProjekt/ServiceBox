<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<c:forEach items="${ requestScope[ 'listaInstanca' ] }" var="data">
	<tr>
		<td>${ data.id }</td>
		<td>${ data.name }</td>
		<td>${ data.telefon }</td>
		<td>${ data.adresa }</td>
		<td>${ data.grad }</td>
		<td>${ data.web }</td>
		<td>${ data.opis }</td>
		<td>${ data.latitude }</td>
		<td>${ data.longitude }</td>
		<td>${ data.objekt.name }</td>
		<td><a href='<spring:url value="/instanca/${ data.id }?form"></spring:url>'><span class="glyphicon glyphicon-edit"></span></a></td>
		<td><a class="confirm" id=${ data.id } href="#"><span class="glyphicon glyphicon-remove"></span></a></td>
	</tr>
</c:forEach>
<script type="text/javascript">
$(document).ready(function(){
    $('.confirm').click(function(){
        var answer = confirm("Jeste li sigurni da želite pobrisati ovaj element?");
        if (answer){
        	var str = $(this).attr("id");
        	 $.ajax({
            		type: "POST",
            	    url: "instanca?delete",
            	    data: { id: str }
            	}).done(function( html ) {
            	    $("#instance").html(html);
            	});
        } else {
            return false;
        }
    });
});
</script>
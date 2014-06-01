<!DOCTYPE html>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<html>
	<head>
		<meta charset="utf-8">
		<title>Welcome</title>
		<link href="<c:url value="/resources/css/bootstrap.min.css" />" rel="stylesheet" media="screen">
		<script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.7.1/jquery.min.js"></script>
		<script type="text/javascript" src="<c:url value="/resources/js/bootstrap.min.js" />"></script>
	 	<script src="http://connect.facebook.net/en_US/all.js"></script>  
	</head> 
	<body>
		<div class="content">
			<div id="fb-root"></div>	
			<div class="container">
					<%@include file="../includes/header.jsp" %>
					<div class="row">
						<div class="panel panel-default">
						  <div class="panel-body">
						    <h3>Disciplina - ${disciplinaWrapper.disciplina.nome}</h3>
						  </div>
						</div>
						
						<h5>Temas</h5>
						<table class="table table-striped">
							<c:forEach var="tema" items="${disciplinaWrapper.temas }">							
								<div class="row span8">
									<tr>
										<td>
											<span>${tema.nome}</span>
										</td>
										<td>
											<div class="btn-group">
											  <button type="button" class="btn btn-default dropdown-toggle" data-toggle="dropdown">
											    Links <span class="caret"></span>
											  </button>
											  <ul class="dropdown-menu" role="menu">
											  	<c:forEach var="prova" items="${tema.provas}">
											    	<li><a href="${context}/provas/prova?provaId=${prova.id}">Prova ${prova.ano}/${prova.periodo} (${prova.nomeProfessor})</a></li>
											    </c:forEach>								    
											  </ul>
											</div>
										</td>										
									</tr>
								</div>
							</c:forEach>	
						</table>														
					</div>
			</div>
		</div>		
	</body>
</html>

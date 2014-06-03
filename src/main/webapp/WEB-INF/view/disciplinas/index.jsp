<!DOCTYPE html>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<html>
	<head>
		<meta charset="utf-8">
		<title>Welcome</title>
		<script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.3/jquery.min.js"></script>
		<link href="<c:url value="/resources/css/bootstrap.min.css" />" rel="stylesheet" media="screen">
		<script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.7.1/jquery.min.js"></script>
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
						    <h3>Disciplinas</h3>
						  </div>
						</div>
						
						<table class="table table-striped">
							<tr>
								<th>Disciplina</th>
								<td></td>
								<td></td>
							</tr>
							<c:forEach var="disciplina" items="${disciplinas}">
								<tr>								
									<td>${disciplina.nome }</td>
									<td><a href="${context}/disciplinas/temas?disciplinaId=${disciplina.disciplinaId}">Temas</a></td>
									<td><a href="${context}/disciplinas/avaliacoes?disciplinaId=${disciplina.disciplinaId}">Avaliações</a></td>
								</tr>
							</c:forEach>
						</table>						
					</div>
			</div>
		</div>
	  
		
		
	</body>
</html>

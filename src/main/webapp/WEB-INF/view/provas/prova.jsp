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
	 	<script src="http://connect.facebook.net/en_US/all.js"></script>  
	</head> 
	<body>
		<div class="content">
			<div id="fb-root"></div>
			<script>(function(d, s, id) {
			  var js, fjs = d.getElementsByTagName(s)[0];
			  if (d.getElementById(id)) return;
			  js = d.createElement(s); js.id = id;
			  js.src = "//connect.facebook.net/en_US/sdk.js#xfbml=1&appId=252774131593896&version=v2.0";
			  fjs.parentNode.insertBefore(js, fjs);
			}(document, 'script', 'facebook-jssdk'));</script>
			<div class="container">
				<%@include file="../includes/header.jsp" %>
				
				<div class="panel panel-default">
					<div class="panel-body">
				    	<h3>${provaWrapper.disciplina.nome}</h3>
				    	<h5>Professor ${provaWrapper.prova.nomeProfessor} ${provaWrapper.prova.ano}/${provaWrapper.prova.periodo }</h5>
					</div>
				</div>
				<div class="row">
					<div class="col-md-7">
						<iframe src="http://docs.google.com/gview?url=http://infolab.stanford.edu/pub/papers/google.pdf&embedded=true" style="width:600px; height:500px;" frameborder="0"></iframe>
					</div>
					<div class="col-md-4">
						<span>Tags</span>
						<ul>
							<c:forEach var="tema" items="${provaWrapper.temas}">
								<li class="badge">${tema.nome}</li>
							</c:forEach>
						</ul>
					</div>					
				</div>	
				<div class="row col-md-5 fb-comments" data-href="http://www.dcc-colab.com:8080/tesi/provas/prova?provaId=${provaWrapper.prova.id}" data-numposts="5" data-colorscheme="light"></div>			
			</div>			
		</div>	
	</body>
</html>

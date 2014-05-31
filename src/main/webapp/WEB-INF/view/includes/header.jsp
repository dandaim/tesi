<!DOCTYPE html>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<c:set var="context" value="${pageContext.request.contextPath}" />
<div class="row">
	<nav class="navbar navbar-default" role="navigation">
		<div class="container-fluid">
			<div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
				
				<ul class="nav navbar-nav">					
					<li>
						<a href="${context}/prova/view">Provas</a>
					</li>
					<li>
						<a href="${context}/professores/view">Professores</a>
					</li>
				</ul>
				<ul class="nav navbar-nav navbar-right">
					<li>
						<a class="">Bem-Vindo(a) ${usuario.nomeFace}</a>
					</li>
				</ul>
			</div>
		</div>
	</nav>	
</div>

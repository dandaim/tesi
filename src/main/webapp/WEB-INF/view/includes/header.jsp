<!DOCTYPE html>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<c:set var="context" value="${pageContext.request.contextPath}" />
<div class="row">
	<span>Bem-Vindo(a) ${usuario.nomeFace}</span>
	<ul>
		<li>
			<a href="${context}/prova/view">Provas</a>
		</li>
		<li>
			<a href="${context}/professores/view">Professores</a>
		</li>
	</ul>
</div>

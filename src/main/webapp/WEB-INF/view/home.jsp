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
	</head> 
	<body>
		<div id='fb-root'></div>
		  <script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.7.1/jquery.min.js"></script>
		  <script src="http://connect.facebook.net/en_US/all.js"></script>
		<script>
		
			$(function(){
			      FB.init({ apiKey: '252774131593896', status: true });
			 
			      FB.getLoginStatus(function(response) {
			        if (response.status === 'connected') {
			          console.log(response);
			        } else if (response.status === 'not_authorized') {
			          console.log('not connected to app');
			        } else {
			          console.log('not logged in to fb');
			        }
			      });
		    });
			  
		</script>
		
		<form:form id="form" action="/tesi/index" modelAttribute="indexForm" >
			<input type="hidden" name="accessToken" id="accessToken" />
		</form:form>
	</body>
</html>

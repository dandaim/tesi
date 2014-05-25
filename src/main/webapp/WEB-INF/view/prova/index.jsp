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
		<div id="fb-root"></div>
		<script>
		
		window.fbAsyncInit = function() {
			  FB.init({
			    appId      : '252774131593896',
			    status     : true, // check login status
			    cookie     : true, // enable cookies to allow the server to access the session
			    xfbml      : true  // parse XFBML
			  });

			  FB.Event.subscribe('auth.authResponseChange', function(response) {
				    			    
				    if (response.status === 'connected') {
				      login( response.authResponse.accessToken  );
				    } else if (response.status === 'not_authorized') {
				      FB.login();
				    } else {
				      FB.login();
				    }
				  });
			  };
			  
			  function login( authToken ) {
				  
				  $("#accessToken").val(authToken);
				  $("#form").submit();
			  }			  

			  // Load the SDK asynchronously
			  (function(d){
			   var js, id = 'facebook-jssdk', ref = d.getElementsByTagName('script')[0];
			   if (d.getElementById(id)) {return;}
			   js = d.createElement('script'); js.id = id; js.async = true;
			   js.src = "//connect.facebook.net/en_US/all.js#xfbml=1&appId=252774131593896";
			   ref.parentNode.insertBefore(js, ref);
			  }(document));		

		</script>
		
		<div class="fb-login-button" data-max-rows="1" data-size="large" data-show-faces="false" data-auto-logout-link="false"></div>
		<form:form id="form" action="/tesi/index" modelAttribute="indexForm" >
			<input type="hidden" name="accessToken" id="accessToken" />
		</form:form>
	</body>
</html>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1"></meta>
	<meta name="viewport" content="width=device-width, initial-scale=1"></meta>
	
	<title>Show</title>

</head>
<body>

	<div class="container">
    <h1>Hi</h1>
	    
	    <c:forEach var="question" items="${leadingQ}">
			    <div class="stage">${question.stage}</div>
			    <div class="description">${question.description}</div>
			    <c:forEach var="sub" items="${question.subQuestions}">
			        <div>subQ: ${sub.ID} ${sub.description}</div>
			    </c:forEach>
			    <p></p>
	    </c:forEach>

	</div>

</body>
</html>
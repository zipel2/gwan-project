<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	${board.title} ${board.contents}
	<img src="/images/${board.fileName}">


	
	<c:forEach items="${board.getComments()}" var="board"> 
	    ${board.contents}<br />
		<hr />

	</c:forEach>

	<form name="comment" method="post" action="/board/${board.id}/comments">
		<textarea name="contents" rows="5" cols="60"></textarea>
		<input type="submit" value="reply">
	</form> 

</body>
</html>
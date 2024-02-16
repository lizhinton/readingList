<%@ page language="java" contentType="text/html; charset=UTF-8"pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Create a new list</title>
</head>
<body>
	<form action ="createNewListServlet" method="post">
		List Name: <input type ="text" name ="listName"><br />
		reader Name: <input type ="text" name ="readerName"><br />
		Available Books:<br />
		<select name="allBooksToAdd" multiple size="6">
			<c:forEach items="${requestScope.allItems}" var="currentBook">
				<option value ="${currentBook.id}">${currentBook.title} |${currentitem.author}</option>
			</c:forEach>
		</select>
		<br />
		<input type ="submit" value="Create List and Add Items">
	</form>
	<a href ="index.html">Go add new items instead.</a>
</body>
</html>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Home</title>
    </head>
    <body>
        <div align="center">
	        <h1>Users List</h1>
	        <h2><a href="new">New User</a>&nbsp;&nbsp;&nbsp;&nbsp;<a href="search">Search User</a></h2>
	        
        	<table border="1">
	        	<th>No</th>
	        	<th>Username</th>
	        	<th>Age</th>
				<th>IsAdmin</th>
				<th>CreatedDate</th>
	        	<th>Actions</th>
	        	
				<c:forEach var="user" items="${userList}" varStatus="status">
	        	<tr>
	        		<td>${user.id}</td>
					<td>${user.name}</td>
					<td>${user.age}</td>
					<td>${user.isisAdmin}</td>
					<td>${user.createDate}</td>
					<td>
						<a href="edit?id=${user.id}">Edit</a>
						&nbsp;&nbsp;&nbsp;&nbsp;
						<a href="delete?id=${user.id}">Delete</a>
					</td>
	        	</tr>
				</c:forEach>	        	
        	</table>

			<div id="pagination">

				<c:url value="/" var="prev">
					<c:param name="page" value="${page-1}"/>
				</c:url>
				<c:if test="${page > 1}">
					<a href="<c:out value="${prev}" />" class="pn prev">Prev</a>
				</c:if>

				<c:forEach begin="1" end="${maxPages}" step="1" varStatus="i">
					<c:choose>
						<c:when test="${page == i.index}">
							<span>${i.index}</span>
						</c:when>
						<c:otherwise>
							<c:url value="/" var="url">
								<c:param name="page" value="${i.index}"/>
							</c:url>
							<a href='<c:out value="${url}" />'>${i.index}</a>
						</c:otherwise>
					</c:choose>
				</c:forEach>
				<c:url value="/" var="next">
					<c:param name="page" value="${page + 1}"/>
				</c:url>
				<c:if test="${page + 1 <= maxPages}">
					<a href='<c:out value="${next}" />' class="pn next">Next</a>
				</c:if>
			</div>
        </div>
    </body>
</html>

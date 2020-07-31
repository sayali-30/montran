<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>User Home</title>
	</head>
	<body>
		<%! String name; %>
		<h3>User Home</h3>
		<hr>
		
		<% name = session.getAttribute("Name").toString();  %>
					
		<h3><font color = blue>Welcome, <%= name %> !!</font></h3>
				
		<br><br><br><br>
		
		<a href="LogoutServlet">Logout</a>

	</body>
</html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>User Creation Status</title>
	</head>
	<body>
		<%!  String regName, regLoginId, regPassword; %>
		<h3>Registration Status</h3>
		<hr>
		
		<%
			regName =  request.getParameter("txtRegName");
			regLoginId =  request.getParameter("txtRegLoginId");
			regPassword =  request.getParameter("txtRegPassword");
			
			if (regName.isEmpty() || regLoginId.isEmpty() || regPassword.isEmpty() || regPassword.length()<8)
			{ %>
				<h4><font color = red>User Creation Failed.. <br><br>Password should be minimum 8 characters</font></h4>
		<% 	}
			else
			{ %>
				<h4><font color = green>User Created Successfully..!!</font></h4>
		<% 		session.setAttribute("Name", regName);	
				session.setAttribute("LoginId", regLoginId);
				session.setAttribute("Password", regPassword);
			} 
			
		%>
		
		<br><br><br><br>
		
		<a href="login.html">Login Again</a>
	
	</body>
</html>
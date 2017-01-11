<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="Validator" method="post">
<h1>
USER LOGIN......!
</h1>
<br/>
<br/>
Enter UserName:<input type="text" placeholder="UserID" name="userid"><br/>
<br/>
Enter Password:<input type="password" placeholder="Password" name="password"><br/>
<br/>
<input type="submit" name="Login">
<a  href="http://localhost:8083/AppointmentManagementSystem/Register.jsp">Register</a>
<br/>
<br/>
<h1>
ADMIN LOGIN......!
</h1>
<br/>
<br/>
Admin:<input type="text" placeholder="Admin" name="userid"><br/>
<br/>
Enter Password:<input type="password" placeholder="Password" name="apassword"><br/>
<br/>
<input type="submit" name="Login">
</form>
</body>
</html>
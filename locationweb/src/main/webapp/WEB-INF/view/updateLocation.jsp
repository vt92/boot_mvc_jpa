<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page isELIgnored="false" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>update Location</title>
</head>
<body>

<form action="updateloc" method="post">
<pre>
ID: <input type="text" name="id" value="${location.id}" readonly/>
CODE: <input type="text" name="code" value="${location.code}"/>
NAME: <input type="text" name="name" value="${location.name}"/>
TYPE: Urban<input type="radio" name="type" value="urban" ${location.type=='urban'?'checked':''}/>
	  Rural<input type="radio" name="type" value="rural" ${location.type=='rural'?'checked':''}/>
	  
<input type="submit" value="save">	 
</pre>
</form>

</body>
</html>
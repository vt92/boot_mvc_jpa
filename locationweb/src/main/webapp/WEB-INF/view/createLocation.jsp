<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>create Location</title>
</head>
<body>

<form action="saveloc" method="post">
<pre>
ID: <input type="text" name="id" />
CODE: <input type="text" name="code" />
NAME: <input type="text" name="name" />
TYPE: Urban<input type="radio" name="type" value="urban"/>
	  Rural<input type="radio" name="type" value="rural"/>
	  
<input type="submit" value="save">	 
</pre>
</form>
${msg}


<a href="displayLocation">View All</a>
</body>
</html>
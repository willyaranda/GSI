<!doctype html>
<html>
<head>
<meta charset="utf-8">
<title>Woop</title>
</head>
<body>
<%! java.util.Date getDate() {
		return new java.util.Date();
	}
	java.util.Date fecha = new java.util.Date();
%>
La hora es (con declaration)
<%= String.valueOf(getDate()) %>
<br />
La hora es (con scriptlet)
<%

	java.util.Date date = new java.util.Date();
	out.println(String.valueOf(date));
	
%>
<br />
La hora con declaration y variable 
<%= String.valueOf(fecha) %>
</body>
</html>
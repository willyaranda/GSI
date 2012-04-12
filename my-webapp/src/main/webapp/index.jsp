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
%>
La hora es (con declaration)
<%= String.valueOf(getDate()) %>

La hora es (con scriptlet)
<%

	java.util.Date date = new java.util.Date();
	out.println(String.valueOf(date)); %>
</body>
</html>
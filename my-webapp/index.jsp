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
La hora es
<%= String.valueOf(getDate()) %>
</body>
</html>
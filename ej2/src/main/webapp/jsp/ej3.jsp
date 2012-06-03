<!DOCTYPE html>
<html>
<head>
	<meta charset='utf-8' />
</head>
<body>
	<%-- Una importación --%>
	<%@ page import="java.util.*" %>
	<jsp:useBean id="suma" scope="page" class="com.willyaranda.gsi.ej2.Suma" />
	<% if (request.getParameter("numero1") != null) {
		Vector vec = new Vector();
		//// Obtenemos los numeros y los introducimos en un vector
		for(Enumeration e = request.getParameterNames(); e.hasMoreElements();) {
			String nombre = (String) e.nextElement();
			String valor = (String) request.getParameter(nombre);
			if (valor.compareTo("Enviar") == 0)
				continue;
			Integer num = Integer.parseInt(valor);
			vec.add(new Integer(num));
			out.println("Número recibido: " + num );
			%><br><%
		}
	  	Integer num1 = (Integer) vec.get(0);
		Integer num2 = (Integer) vec.get(1);
		suma.setNum1(num1);
		suma.setNum2(num2);
		//Comparamos y mostramos mensaje
		if (!suma.isCorrect()) {
			out.println("No has adivinado el número");
		} else {
			out.println("<h2>Adivinaste el número, congrats!</h2>");
		}
	} else {
		%>
		<h2>Guess me!</h2>
		<form action='' method='GET' >
		    <input type='text' name='numero1' />
		    <input type='text' name='numero2' />
		    <input type='submit' value='Enviar' />
		</form>
	<% } %>
</body>
</html>
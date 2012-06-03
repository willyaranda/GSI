$ cd /path/to/project
$ mvn clean compile
$ sudo cp target/ej2.war /var/lib/tomcat6/webapps/

Ejercicio 1:
	- sendRedirect(): Se hace una redirección del flujo de salida al nuevo servlet, por lo que es el que toma el control y la dirección que ve el usuario en el navegador corresponde a la URL de este segundo servlet.
	- forward() e include(): La petición es controlada desde el primer servlet, aunque la gestión la realice otro servlet secundario. En este caso, el usuario ve la URL del primer servlet y no la del segundo, como ocurre en sendRedirect(), se podría considerar como una redirección interna del servidor VS. una redirección del cliente como es el sendRedirect()
		- La diferencia entre forward() e include(), es que en forward(), el control del servlet se pasa a otro secundario, sin volver al primero. Todo lo que haya hecho el primero (como escribir en la salida), es descartado.
		- Mientras que en include() el control pasa a un secundario pero al final vuelve al servlet inicial, por lo que se "incluye" el contenido del secundario en el primario.
	
Ejercicio 2:
	- Funcionan en la ruta /ej2/jsp/ej2.jsp, que se llama a sí mismo dependiendo de si es un GET con parámetros o sin ellos.
	
Ejercicio 3:
	- 
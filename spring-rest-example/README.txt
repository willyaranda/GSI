Esqueleto de aplicación para introducir al alumno a Spring y REST

= Contenido =
	La aplicación contiene:
	.- El contenido de la aplicación spring-app anteriormente usado en la asignatura.
	.- web.xml con un único servlet especificado que responde a las peticiones sobre URLs
		[nombre-de-la-app]/rest/*
	.- index.jsp con una lista de ejemplos de llamadas a realizar por consola con "curl"
	.- application-context.xml y similares. Describen la carga automática de los controladores
		mediante anotaciones.
	.- dependencias apropiadas en pom.xml (revisar versiones vigentes).
	.- Controlador de pruebas HelloWorldController.java. Permite realizar los ejemplos que
		se proponen en index.jsp
	.- JUnitTest HelloWorldControllerTest.java para probar desde java el comportamiento del controlador
		anterior HelloWorldController.java
	.- Controladores CustomerController.java y ProductController.java para ofrecer la funcionalidad
		asociada a Customer y a Product.

= Tareas pendientes =

	== Ejercicio 1 ==

	.- Probar cada uno de los ejemplos dados en index.jsp

	== Ejercicio 2 ==

	.- Generar un juego de URLs para que la aplicación ofrecerca servicios REST para todas
		las funciones disponibles de Customer y de Product.
	.- Implementar dichos servicios en los controladores correspondientes.

= Referencias =
	Creación de RESTful services en Spring
		http://blog.springsource.com/2009/03/08/rest-in-spring-3-mvc/
	Para trabajar con REST Templates de Spring
		http://blog.springsource.org/2009/03/27/rest-in-spring-3-resttemplate/

Esqueleto de aplicación para introducir al alumno a Spring IOC

= Contenido =
	La aplicación contiene:
	.- ConnectionDaoMySql.java de conexión a una DB mysql "telecom" usando usuario "root" y clave "".
	.- TestConnectionDaoMySqlSpring.java: JUnitTest con funciones para inicializar setup,
		finalizar y ejecutar un test.
	.- ficheros Data y DAO para Customer y Product.
	.- ficheros fuente de ProductDaoMySql.java y CustomerDaoMySql.java para el acceso a los datos desde MySql
	.- application-context.xml con la configuración spring de la aplicación.
	.- dependencias apropiadas en pom.xml (revisar versiones vigentes).

= Tareas pendientes =

	== Ejercicio 1 ==

	.- Parametrizar ConnectionDaoMySql.java en un nuevo ConnectionDaoMySqlSpring.java
		Deben añadirse atributos para el nombre de la DB, el usuario y la contraseña.
		No olvidar añadir las funciones de get/set pertinentes.
	.- Añadir el bean correspondiente al application-context.xml
	.- Probar el bean desde el JUnitTest.

	== Ejercicio 2 ==

	.- Crear un nuevo CustomerDaoMySqlSpring.java y ProductDaoMySqlSpring.java.
		Deben implementar CustomerDao y ProductDao respectivamente y NO
		heredar de ConnectionDaoMySql.
	.- Tendran un atributo de tipo javax.sql.DataSource. Deben usarlo correctamente
		para acceder a la base de datos.
	.- Añadir los beans myDataSource, customerDao y productDao (estos dos últimos con referencia
		al anterior). El bean myDataSource debe se de la clase "org.apache.commons.dbcp.BasicDataSource"
	.- Probar los beans anteriores desde un JUnitTest.

= Referencias =
	Del manual Spring 3.1.1.RELEASE:
		.- p33 (pdf 59)
		.- p63 (pdf 90)

		.- p394 (pdf 368) - DataSource

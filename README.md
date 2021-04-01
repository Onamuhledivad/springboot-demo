# springboot-demo
API Rest CRUD en Java Spring Boot
-Get All products
-Post a new product
-Update product
-Delete a product by id
-Find product by sku and model

Iniciar la aplicación
Tener Java 11 +

#Configuracion previa en sistema
1- Descargar Maven (http://maven.apache.org/download.cgi#Installation) Binary zip archive
2- Descomprime el archivo y copia la carpeta en el disco C
3- Añadir a las variables de entorno a Maven:
  3.1- Nueva variables del sistema->Nueva->Nombre de la vairable: MAVEN_HOME ->Valor de la variable: ruta donde esta la carpeta de maven.
  3.2- Editar la variable de entorno llamado path y añade-> %MAVEN_HOME%\bin
  3.3 Probar comando "mvn -v" en consola.
4- Instalar el JDK (https://www.oracle.com/java/technologies/javase/javase-jdk8-downloads.html) 
  4.1- Añadir JDK en las variables de entorno->variables del sistema->Nueva->Nombre de la vairable: JAVA_HOME ->Valor de la variable: ruta donde esta la carpeta de instalacion de java.
  4.2- Editar la variable de entorno llamado path y añade-> %JAVA_HOME%\bin
  4.3 Probar comando "java -version"  en consola.


#Configuracion de variable
1- Configurar la base en applicacitons.properties (/src/main/resources/application.properties) para conexion a la DB en MySQL
    1.1- URL -> name -> password
    
    
#Ejecutalo
Usar comando mvn para ejecutar en consola
mvnw.cmd spring-boot:run

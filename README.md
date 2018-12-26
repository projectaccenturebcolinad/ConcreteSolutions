# Caracteristicas Generales
Gradle 4.10.3

Tomcat 9.0.14

HSQLDB 2.4.1

IntelliJ IDEA 1.8.0_152

Java 8

Sprint Boot 2.0.4

JWT 0.9.1

Encryptación Bcrypt para Token y Password

JDK 1.8

# Apis Expuestas
# singUp
Descripción: Creación de Usuario - Permitida a todos

Metodo:Post

URI:/auth/signUp

Cuerpo:{"name":"","email":"","password":"","phones":[{}]}

respuesta:{"name":"","email":"","password":"","phones":[{}]}

Restricciones: seguir el formato del cuerpo indicado, el email es unico, phones es un lista de n objetos.

# singIn
Descripción: Inicio de Sesion - Permitida a todos, agrega token y actualiza el campo last_login del usuario.

Metodo:Post

URI:/auth/signIn

Cuerpo:{"email":"","password":""}

respuesta:{"message":"token para ese usuario"}

Restricciones: seguir el formato del cuerpo indicado.

# getUsers
Descripción: Lista de Usuarios Registrados - acceso restringido por token.

Metodo:GET

URI:/protectApis/getUsers

Cuerpo: Es neceseario enviar por Beer el token generado en la API singIn

respuesta:[{"id":,"name": "","email": "","password": "","phones": "","created": "","modified": "","last_login": "","token": "","roles": []}]

Restricciones: seguir el formato del cuerpo indicado.

# Consulta Literaria - Proyecto en Java

## Descripción

Consulta Literaria es una aplicación en Java que permite realizar búsquedas literarias a partir de datos obtenidos de la API de [Gutendex](https://gutendex.com/), que ofrece acceso a una vasta colección de libros gratuitos. La aplicación está construida con **Spring Boot** y utiliza **JPA** para la persistencia de datos.

## Funcionalidades

La aplicación permite realizar las siguientes operaciones:

1. **Búsqueda de libro por título**: Permite buscar libros por su título.
2. **Lista de todos los libros**: Muestra una lista de todos los libros almacenados en la base de datos.
3. **Lista de autores**: Muestra la lista de todos los autores de los libros registrados.
4. **Exhibir cantidad de libros en un determinado idioma**: Permite filtrar los libros por idioma.
5. **Listar autores vivos en determinado año**: Permite consultar autores que estuvieron vivos en un año específico.

## Tecnologías

- **Java 17** (o superior)
- **Spring Boot**
- **JPA** (Java Persistence API) con **Hibernate**
- **MySQL** (base de datos)
- **Jackson** para manejo de JSON
- **API Gutendex** para obtener datos de libros

## Estructura del Proyecto

La estructura del proyecto está organizada de la siguiente manera:

### Paquete `com.CFCM.ConsultaLiteral.Modelo`

Contiene las clases que representan las entidades del sistema:

- **Libro**: Representa un libro, con su título, autores e idiomas.
- **Autor**: Representa un autor, con su nombre, año de nacimiento y, si está disponible, su año de fallecimiento.
- **Idioma**: Enum que contiene los idiomas disponibles para los libros (Español, Inglés, Portugués, Francés).
- **DatosLibro, DatosAutor, DatosResultados**: Clases utilizadas para mapear los datos de la respuesta JSON de la API Gutendex.

### Paquete `com.CFCM.ConsultaLiteral.Repository`

Contiene los repositorios para interactuar con la base de datos utilizando **Spring Data JPA**:

- **LibrosRepository**: Proporciona métodos para buscar libros y autores basados en varios criterios, como idioma y año de vida de los autores.

### Paquete `com.CFCM.ConsultaLiteral.Service`

Contiene servicios para el manejo de datos y consumo de la API externa:

- **IConvierteDatos**: Interfaz para convertir datos de JSON a objetos Java.
- **ConvierteDatos**: Implementación que usa **Jackson** para la conversión de JSON a objetos.
- **ConsumoApi**: Servicio para consumir la API de Gutendex.

### Paquete `com.CFCM.ConsultaLiteral.Principal`

Contiene la lógica principal de la aplicación, que maneja la interacción con el usuario:

- **Principal**: Clase principal que muestra el menú y maneja la lógica de las opciones disponibles.

## Instalación y Uso

### Requisitos Previos

1. Tener **Java 17** o superior instalado.
2. Tener **MySQL** o cualquier otra base de datos configurada.
3. Configurar las credenciales de la base de datos en el archivo `application.properties`.

### Instrucciones de Instalación

1. Clona este repositorio:
   ```bash
   git clone https://github.com/tu_usuario/consulta-literaria.git
   cd consulta-literaria
   ```
2.  Asegúrate de tener las dependencias de Maven instaladas.

3. Configura la base de datos en el archivo src/main/resources/application.properties:
  ```bash
  spring.datasource.url=jdbc:mysql://localhost:3306/consulta_literaria
  spring.datasource.username=tu_usuario
  spring.datasource.password=tu_contraseña
  spring.jpa.hibernate.ddl-auto=update
  ```
4. Ejecuta la aplicación:
  ```bash
   mvn spring-boot:run
   ```
  La aplicación estará disponible en http://localhost:8080.
  
## Ejemplo de Uso
Cuando inicies la aplicación, se te presentará un menú en la consola con las siguientes opciones:

1. Búsqueda de libro por título.
2. Lista de todos los libros.
3. Lista de autores.
4. Exhibir cantidad de libros en un determinado idioma.
5. Listar autores vivos en determinado año.
0. Salir.
Consultas
Listar libros: Muestra todos los libros en la base de datos.
Filtrar libros por idioma: Introduce el idioma (por ejemplo: "Español") y muestra los libros en ese idioma.
Filtrar autores vivos: Introduce un año para consultar los autores que estuvieron vivos en ese año.

Contribuciones
¡Las contribuciones son bienvenidas! Si tienes alguna sugerencia o mejoras, por favor abre un pull request o crea un issue.

Licencia
Este proyecto está bajo la licencia MIT. Ver el archivo LICENSE para más detalles.

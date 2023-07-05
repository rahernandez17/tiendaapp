
# Tienda USB - Backend

Este proyecto contiene toda la lógica para poder hacer gestión de categorías, clientes, productos, pedidos y detalles de pedidos de la aplicación Tienda USB.

## Tecnologías

- Java 17
- Gradle 7
- Spring Boot 3
- Flyway
- Java Persistence API (JPA)
- PostgreSQL 15
- Docker

![icono java](/icons/java_original_wordmark_logo_icon_146459.png)
![icono gradle](/icons/gradle_logo_icon_171050.png)
![icono spring boot](/icons/spring_logo_icon_144856.png)
![icono flyway](/icons/flyway_logo_icon_248526.png)
![icono postgres](/icons/postgresql_plain_wordmark_logo_icon_146390.png)
![icono docker](/icons/docker_original_wordmark_logo_icon_146557.png)

## Autores

- Raul Hernandez
- Valeria Delgado

## Instalación

Este proyecto utiliza PostgreSQL 15, y para ello vamos a crear un contenedor en docker. Ejecutamos los siguientes comandos en la _raíz del proyecto_ para crear el contenedor con el **puerto 5432** por defecto.

```bash
cd scripts
docker compose up
```
Al ejecutar el script _docker-compose.yml_, se crearón el contenedor de PostgreSQL y otro con PgAdmin como administrador de base de datos.

Para acceder a PgAdmin, debes ingresar a <http://localhost:5050> e ingresar el username **admin@admin.com** y password **root**.

Como paso siguiente, debes crear un usuario de base de datos. Para ello abre el archivo _user.sql_ o copia las siguientes sentencias y ejecutalas en PgAdmin.

```sql
CREATE USER tienda_electronica_usb WITH ENCRYPTED PASSWORD 'TIENDA_ELECTRONICA_USB';

CREATE DATABASE tienda_app WITH OWNER tienda_electronica_usb;
```

Finalmente, se debe crear un esquema en la base de datos. Este esquema debe asignarse al usuario creado anteriormente. 
```sql
CREATE SCHEMA IF NOT EXISTS multi_nivel AUTHORIZATION tienda_electronica_usb;
```

## Ejecución

Para poner en marcha el proyecto, debes abrir una terminal en la _raíz del proyecto_ y ejecutar el siguiente comando:

```bash
gradlew bootRun
```

El proyecto se levantará en el **puerto 9090**, y tiene el context path por defecto _/api-tienda-app_. La URL base es <http://localhost:9090/api-tienda-app/>

***Nota: El proyecto creará automáticamente las tablas y algunos inserts en el esquema multi_nivel***.

## API Documentación

La documentación de la API se construyó con OpenAPI ySwagger. Para visualizarla, ingresa a <http://localhost:9090/api-tienda-app/swagger-ui/index.html>

![icono swagger](/icons/file_type_swagger_icon_130134.png)

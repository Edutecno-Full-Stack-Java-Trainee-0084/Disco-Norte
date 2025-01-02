Aquí está el contenido preparado para un archivo .md:

markdown
Copiar código
# Sistema de Gestión de Inventarios y Ventas - DistribuSoft

## Introducción

DistribuSoft es un sistema de gestión diseñado para optimizar la administración de inventarios y ventas en pequeñas y medianas empresas. Permite gestionar de manera eficiente miembros, álbumes, compras y sucursales utilizando una interfaz web moderna e intuitiva.

## Objetivos del Proyecto

Desarrollar una aplicación web para:

- Gestionar operaciones CRUD para las principales entidades: miembros, álbumes, compras y sucursales.
- Proveer un endpoint API para consultas externas utilizando herramientas como Postman.
- Normalizar el esquema de la base de datos para mantener la integridad y consistencia de los datos.

## Requisitos Técnicos

### Tecnologías Requeridas

- **Java**
- **Spring Boot 3.2+**
- **MySQL**
- **Thymeleaf**
- **Maven**
- **Bootstrap**

### Dependencias Principales

```xml
<dependencies>
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-web</artifactId>
    </dependency>
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-data-jpa</artifactId>
    </dependency>
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-thymeleaf</artifactId>
    </dependency>
    <dependency>
        <groupId>com.mysql</groupId>
        <artifactId>mysql-connector-j</artifactId>
        <scope>runtime</scope>
    </dependency>
    <dependency>
        <groupId>org.projectlombok</groupId>
        <artifactId>lombok</artifactId>
        <optional>true</optional>
    </dependency>
</dependencies>
```

## Estructura del Proyecto

### 1. Modelo de Datos

1. **Sucursal**
    - `branch_id` (Clave Primaria)
    - `branch_description` (Cadena de texto)

2. **Tipo de Membresía**
    - `membership_type_id` (Clave Primaria)
    - `membership_type_description` (Cadena de texto)

3. **Género**
    - `gender_id` (Clave Primaria)
    - `gender_description` (Cadena de texto)

4. **Miembro**
    - `member_id` (Clave Primaria)
    - `first_name` (Cadena de texto)
    - `last_name` (Cadena de texto)
    - `email` (Cadena de texto)
    - `birth_date` (Fecha)
    - Relaciones: `branch_id`, `membership_type_id`, `gender_id`

5. **Álbum**
    - `album_id` (Clave Primaria)
    - `artist_name` (Cadena de texto)
    - `album_title` (Cadena de texto)
    - `duration` (Cadena de texto)
    - `music_genre` (Cadena de texto)
    - `label` (Cadena de texto)
    - `stock` (Entero)
    - `price` (Entero)

6. **Compra de Miembro**
    - `member_purchase_id` (Clave Primaria)
    - Relaciones: `member_id`, `album_id`, `branch_id`
    - `quantity` (Entero)

7. **Vendedor**
    - `seller_id` (Clave Primaria)
    - `first_name` (Cadena de texto)
    - `last_name` (Cadena de texto)
    - Relación: `branch_id`

---

### 2. Desarrollo Frontend (Thymeleaf)

#### 2.1 Vistas Requeridas

1. **Panel de Compras** (`/purchases`)
    - Resumen de todas las compras:
        - Nombre del miembro.
        - Tipo de membresía.
        - Título del álbum.
        - Cantidad comprada.
        - Precio total de la compra.
        - Sucursal donde se realizó la compra.
    - Incluye paginación.
    - Botón para crear, actualizar o eliminar compras.

2. **Detalles de Compra** (`/purchases/{id}`)
    - Vista detallada de una compra:
        - Información del miembro:
            - Nombre, correo electrónico y tipo de membresía.
        - Detalles del álbum:
            - Título, artista, precio y género musical.
        - Detalles de la compra:
            - Cantidad, precio total y sucursal.

---

#### 2.2 API REST

1. **Obtener Compras**

```http
GET /api/purchases
Respuesta:
{
    "purchases": [
        {
            "purchaseId": 1,
            "memberName": "Juan Pérez",
            "membershipType": "Premium",
            "albumTitle": "Thriller",
            "quantity": 2,
            "totalPrice": 39.98,
            "branch": "Sucursal Principal"
        }
    ]
}
```
### Obtener Detalles de Compra

```http
GET /api/purchases/{id}
Respuesta:
{
    "purchaseId": 1,
    "member": {
        "name": "John Doe",
        "email": "john.doe@example.com",
        "membershipType": "Premium"
    },
    "album": {
        "title": "Thriller",
        "artist": "Michael Jackson",
        "price": 19.99,
        "musicGenre": "Pop"
    },
    "details": {
        "quantity": 2,
        "totalPrice": 39.98,
        "branch": "Main Branch"
    }
}
```

### 3. Consultas SQL

1. **Análisis de Compras**
    - Total de compras e ingresos por sucursal.

2. **Álbumes Más Comprados**
    - Álbumes más comprados con ingresos totales.

3. **Historial de Compras de Miembros**
    - Lista de todas las compras realizadas por cada miembro, agrupadas por tipo de membresía.

4. **Ventas de Álbumes por Sucursal**
    - Cantidad de álbumes vendidos por sucursal, agrupados por álbum.

5. **Ingresos por Tipo de Membresía**
    - Ingresos totales generados por cada tipo de membresía.

---

## Entregables

1. Código fuente de la aplicación.
2. Esquema de la base de datos y datos de prueba.
3. Documentación de la API.
4. Guía de usuario para despliegue y uso.





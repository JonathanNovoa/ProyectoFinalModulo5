# Proyecto Final - Módulo 5: Final Drilling

## Descripción del Proyecto

Este proyecto consiste en desarrollar un sistema web en Java utilizando **JSP** y **Servlets**, el cual permite a los usuarios consultar el signo del horóscopo chino según su fecha de nacimiento. Los usuarios deberán registrarse para acceder a esta funcionalidad.

## Características del Sistema

El sistema debe incluir las siguientes funcionalidades:

1. **Inicio de sesión**: Página de inicio de sesión para usuarios registrados.
2. **Registro de usuarios**: Página para la creación de usuarios nuevos.
3. **Gestión de usuarios**:
   - Modificación de usuarios.
   - Eliminación de usuarios.
   - Listado de usuarios.
4. **Consulta del horóscopo chino**:
   - Cálculo del signo del horóscopo basado en la fecha de nacimiento.
   - Asociación del signo calculado al usuario.
5. **Mensajes informativos**: Retroalimentación clara e intuitiva para el usuario.

## Tecnologías y Herramientas

- **Java EE**: JSP, Servlets.
- **JDBC**: Manejo de conexión y consultas a la base de datos.
- **Base de datos Oracle**: Persistencia de datos.
- **Servidor Tomcat**: Implementación de la aplicación web.
- **HTML/CSS/JavaScript**: Interfaz de usuario.

## Arquitectura del Proyecto

La implementación se divide en dos hitos:

### Hito 1: Capa de Cliente
- **Modelo de datos**:
  - Tabla `HOROSCOPO`:
    ```sql
    CREATE TABLE HOROSCOPO(
      ANIMAL VARCHAR2(30 BYTE),
      FECHA_INICIO DATE,
      FECHA_FIN DATE
    );
    ```
  - Tabla `USUARIOS`:
    ```sql
    CREATE TABLE USUARIOS(
      ID NUMBER,
      NOMBRE VARCHAR2(30 BYTE),
      USERNAME VARCHAR2(30 BYTE),
      EMAIL VARCHAR2(30 BYTE),
      FECHA_NACIMIENTO DATE,
      PASSWORD VARCHAR2(30 BYTE),
      ANIMAL VARCHAR2(30 BYTE)
    );
    ```
- Creación de páginas JSP:
  - Inicio de sesión.
  - Registro de usuario.
  - Consulta del horóscopo chino.
  - Modificación, eliminación y listado de usuarios.

### Hito 2: Capa de Negocio y Persistencia
- **Paquetes del Proyecto**:
  - `com.edutecno.servlets`: Servlets para las operaciones del sistema.
  - `com.edutecno.dao`: Acceso a la base de datos.
  - `com.edutecno.modelo`: Clases de entidad para `Usuario` y `Horóscopo`.
  - `com.edutecno.procesaconexion`: Clase para manejar la conexión con la base de datos.
- **Conexión a la base de datos**:
  - Implementación de métodos para gestionar conexiones con JDBC, incluyendo un pool de conexiones.
- **Consultas SQL**:
  - Ejemplo de consulta para obtener los signos del horóscopo:
    ```java
    public List<Horoscopo> obtenerHoroscopo() {
        List<Horoscopo> horoscopo = new ArrayList<>();
        String consultaSql = "SELECT * FROM horoscopo";
        Connection conn = generaPoolConexion();

        try {
            PreparedStatement pstm = conn.prepareStatement(consultaSql);
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                Horoscopo h = new Horoscopo(rs.getString("animal"), rs.getDate("fecha_inicio"), rs.getDate("fecha_fin"));
                horoscopo.add(h);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return horoscopo;
    }
    ```

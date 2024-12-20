<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="org.example.horoscopo.dto.UsuarioResponseDto" %>
<%@ page import="org.example.horoscopo.model.Usuario" %>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Actualizar Alumno</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<nav class="navbar navbar-expand-lg bg-primary data-bs-theme=white">
    <div class="container-fluid">
        <a class="navbar-brand text-white">Horóscopo Chino</a>
        <div class="collapse navbar-collapse" id="navbarNav">
            <ul class="navbar-nav ms-auto"> <!-- ms-auto: Alinea al lado derecho -->
                <li class="nav-item">
                    <a class="btn btn-danger" href="bienvenida.jsp" role="button">Perfil</a>
                </li>
            </ul>
        </div>
    </div>
</nav>
<div class="container mt-5">
    <h1 class="mb-4">Actualizar Usuario</h1>
    <% UsuarioResponseDto usuario = (UsuarioResponseDto) request.getAttribute("usuario"); %>
    <form action="${pageContext.request.contextPath}/edit" method="post">
        <input type="hidden" name="id" value="<%= usuario.getId() %>">
        <div class="mb-3">
            <label for="nombre" class="form-label">Nombre</label>
            <input type="text" class="form-control" id="nombre" name="nombre" value="<%= usuario.getNombre() %>"
                   required>
        </div>
        <div class="mb-3">
            <label for="username" class="form-label">Username</label>
            <input type="text" class="form-control" id="username" name="username" value="<%= usuario.getUsername() %>"
                   required>
        </div>
        <div class="mb-3">
            <label for="email" class="form-label">Email</label>
            <input type="email" class="form-control" id="email" name="email" value="<%= usuario.getEmail() %>" required>
        </div>
        <div class="mb-3">
            <label for="fecha" class="form-label">Fecha</label>
            <input type="date" class="form-control" id="fecha" name="fecha" value="<%= usuario.getFechaNacimiento() %>"
                   required>
        </div>
        <button type="submit" class="btn btn-primary">Actualizar</button>
        <a href="${pageContext.request.contextPath}/bienvenida.jsp" class="btn btn-secondary">Cancelar</a>
    </form>
</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
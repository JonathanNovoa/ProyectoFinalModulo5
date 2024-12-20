<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="es">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Inicio Sesión</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
</head>

<body class="bg-light">
<nav class="navbar navbar-expand-lg <%--navbar-dark bg-dark--%>bg-primary data-bs-theme=white">
    <div class="container-fluid">
        <a class="navbar-brand text-white">Horóscopo Chino</a>
        <div class="collapse navbar-collapse" id="navbarNav">
            <ul class="navbar-nav ms-auto"> <!-- ms-auto: Alinea al lado derecho -->
            </ul>
        </div>
    </div>
</nav>
<div class="container">
    <div class="row justify-content-center mt-5">
        <div class="col-md-6">
            <div class="card">
                <div class="card-body">
                    <h2 class="card-title text-center mb-4">Inicio Sesión</h2>

                    <% if ("1".equals(request.getParameter("error"))) { %>
                    <div class="alert alert-danger" role="alert">
                        Usuario o contraseña incorrectos. Inténtalo de nuevo.
                    </div>
                    <% } %>

                    <% if ("success".equals(request.getParameter("logout"))) { %>
                    <div class="alert alert-success" role="alert">
                        La sesión se ha cerrado correctamente.
                    </div>
                    <% } %>

                    <form action="login" method="post">
                        <div class="mb-3">
                            <label for="usuario" class="form-label">Usuario</label>
                            <input type="text" class="form-control" id="usuario" name="usuario" required>
                        </div>
                        <div class="mb-3">
                            <label for="password" class="form-label">Contraseña</label>
                            <input type="password" class="form-control" id="password" name="password" required>
                        </div>
                        <div class="d-grid">
                            <button type="submit" class="btn btn-primary">Ingresar</button>
                        </div>
                        <div class="text-center mt-3">
                            <p>¿No tienes una cuenta? <a href="index.jsp" class="text-decoration-none">Registrate</a>
                            </p>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz"
        crossorigin="anonymous"></script>
</body>
</html>

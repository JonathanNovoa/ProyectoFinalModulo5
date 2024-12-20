package org.example.horoscopo.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.horoscopo.dto.UsuarioCreateDto;
import org.example.horoscopo.service.UsuarioService;
import org.example.horoscopo.service.UsuarioServiceImpl;

import java.io.IOException;
import java.sql.Date;

@WebServlet(name = "RegisterServlet", value = "/register")
public class RegisterServlet extends HttpServlet {
    private final UsuarioService usuarioService;

    public RegisterServlet() {
        this.usuarioService = new UsuarioServiceImpl();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String nombre = req.getParameter("nombre");
        String username = req.getParameter("username");
        String email = req.getParameter("email");
        Date fechaNacimiento = Date.valueOf((req.getParameter("fechaNacimiento")));
        String password = req.getParameter("password");
        String confirmPassword = req.getParameter("confirmPassword");

        UsuarioCreateDto usuario = new UsuarioCreateDto(nombre, username, email, fechaNacimiento, password);
        if (usuarioService.registarUsuario(usuario, confirmPassword)) {
            resp.sendRedirect("login.jsp");
        } else {
            resp.sendRedirect("index.jsp?error=1");
        }
    }
}

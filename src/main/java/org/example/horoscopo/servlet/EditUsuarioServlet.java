package org.example.horoscopo.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.example.horoscopo.dto.UsuarioResponseDto;
import org.example.horoscopo.model.Usuario;
import org.example.horoscopo.repository.HoroscopoRepositoryImpl;
import org.example.horoscopo.service.UsuarioService;
import org.example.horoscopo.service.UsuarioServiceImpl;

import java.io.IOException;
import java.sql.Date;
import java.util.List;
import java.util.Optional;

@WebServlet(name = "EditUsuarioServlet", value = "/edit")
public class EditUsuarioServlet extends HttpServlet {

    private final UsuarioService usuarioService;
    HoroscopoRepositoryImpl horoscopoRepository = new HoroscopoRepositoryImpl();

    public EditUsuarioServlet() {
        this.usuarioService = new UsuarioServiceImpl();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        Optional<UsuarioResponseDto> usuario = usuarioService.findUsuarioByUsername(username);
        req.setAttribute("usuario", usuario.get());
        System.out.println(usuario);
        req.getRequestDispatcher("edit.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        String nombre = req.getParameter("nombre");
        String username = req.getParameter("username");
        String email = req.getParameter("email");
        System.out.println(req.getParameter("fecha"));

        Date fechaNacimiento = java.sql.Date.valueOf((req.getParameter("fecha")));
        System.out.println(fechaNacimiento + " " + fechaNacimiento.getClass());
        //String password = req.getParameter("password");

        System.out.println("animal: " + horoscopoRepository.getAnimalByFechaDeNacimiento(fechaNacimiento));

        Usuario usuario = new Usuario();
        usuario.setId(id);
        usuario.setNombre(nombre);
        usuario.setUsername(username);
        usuario.setEmail(email);
        usuario.setFechaNacimiento(fechaNacimiento);
        usuario.setAnimal(horoscopoRepository.getAnimalByFechaDeNacimiento(fechaNacimiento));
        //usuario.setPassword(password);

        usuarioService.edit(usuario);
        System.out.println(usuario + "Revisar");
        List<UsuarioResponseDto> usuarios = usuarioService.findAll();
        System.out.println(usuarioService.findUsuarioByUsername(usuario.getUsername()) + "Antes");
        Optional<UsuarioResponseDto> usuarioResponseDtoOptional = usuarioService.findUsuarioByUsername(usuario.getUsername());

        System.out.println(usuarioResponseDtoOptional.get() + "Despues");

        HttpSession session = req.getSession();
        session.setAttribute("username", usuarioResponseDtoOptional.get().getUsername());
        System.out.println(usuarioResponseDtoOptional.get().getUsername());
        session.setAttribute("ListaUsuarios", usuarios);
        session.setAttribute("usuarioActual", usuarioResponseDtoOptional);


        resp.sendRedirect(req.getContextPath() + "bienvenida.jsp");
    }
}

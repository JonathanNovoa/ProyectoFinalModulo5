package org.example.horoscopo.service;

import org.example.horoscopo.dto.UsuarioCreateDto;
import org.example.horoscopo.dto.UsuarioResponseDto;
import org.example.horoscopo.model.Usuario;

import java.util.List;
import java.util.Optional;

public interface UsuarioService {
    boolean registarUsuario(UsuarioCreateDto usuario, String confirmPassword);

    boolean autentificarUsuario(String username, String password);

    Optional<UsuarioResponseDto> findUsuarioByUsername(String username);

    List<UsuarioResponseDto> findAll();

    public void eliminarUsuario(int id);

    public void edit(Usuario usuario);
}

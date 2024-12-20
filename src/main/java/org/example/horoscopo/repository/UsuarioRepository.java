package org.example.horoscopo.repository;

import org.example.horoscopo.model.Usuario;

import java.util.List;
import java.util.Optional;

public interface UsuarioRepository {
    boolean save(Usuario usuario);

    Optional<Usuario> findByUsername(String username);

    Optional<Usuario> findByEmail(String username);

    List<Usuario> findAll();

    Optional<Usuario> findById(int id);

    public void delete(int id);

    public void edit(Usuario usuario);
}

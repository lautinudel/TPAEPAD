package isi.aepad.tp01.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import isi.aepad.tp01.domain.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, String> {

}

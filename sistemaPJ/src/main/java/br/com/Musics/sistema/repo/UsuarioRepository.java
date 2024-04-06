package br.com.Musics.sistema.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.Musics.sistema.models.Usuario;


public interface UsuarioRepository extends JpaRepository<Usuario, Long>{

}

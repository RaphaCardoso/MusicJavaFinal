package br.com.Musics.sistema.service;

import java.util.List;

import br.com.Musics.sistema.models.Usuario;


public interface IUsuarioService {

	public Usuario salvarUsuario(Usuario user);
	
	public List<Usuario> buscarTodosUsuarios();
	
	public Usuario buscarUsuarioUnico(Long id);
	
	public void deletarUsuario(long id);
	
	public void atualizarUsuario (Usuario usuario);
	
}

package br.com.Musics.sistema.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.Musics.sistema.exception.UsuarioNotFoundException;
import br.com.Musics.sistema.models.Usuario;
import br.com.Musics.sistema.repo.UsuarioRepository;
import br.com.Musics.sistema.service.IUsuarioService;

@Service
public class UsuarioServiceImpl implements IUsuarioService {

	@Autowired
	private UsuarioRepository repo;

	@Override
	public Usuario salvarUsuario(Usuario user) {
		return repo.save(user);
	}

	@Override
	public List<Usuario> buscarTodosUsuarios() {
		return repo.findAll();
	}

	@Override
	public Usuario buscarUsuarioUnico(Long id) {
		Optional<Usuario> opt = repo.findById(id);
		if (opt.isPresent()) {
			return opt.get();
		} else {
			throw new UsuarioNotFoundException("o ID: " + id + " não encontrado");
		}
	}

	@Override
	public void deletarUsuario(long id) {
		repo.delete(buscarUsuarioUnico(id));
	}

	@Override
	public void atualizarUsuario(Usuario user) {
		repo.save(user);
	}

}

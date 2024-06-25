package br.com.Musics.sistema.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.ModelAttribute;
//import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.Musics.sistema.exception.UsuarioNotFoundException;
import br.com.Musics.sistema.models.Usuario;
import br.com.Musics.sistema.service.IUsuarioService;

@Controller
@RequestMapping("/usuario")
public class UsuarioController {

	@Autowired
	private IUsuarioService service;

	@GetMapping("/")
	public String paginaInicial() {
		return "login";
	}

	/*
	 * @PostMapping("/listarUser")
	 * public String salvarUsuario(@ModelAttribute Usuario user, Model model) {
	 * // @ModelAttribute víncula as informações do formulário a um objeto
	 * 
	 * service.salvarUsuario(user);
	 * // Salva novamente (redundante) retorna o id do nosso pagamento
	 * Long id = service.salvarUsuario(user).getId();
	 * // mensagem para o usuário
	 * String mensagem = "Salvo com o id: " + id + " com sucesso!";
	 * // adiconando mensagem na resposta
	 * model.addAttribute(mensagem);
	 * 
	 * return "redirect:listar";
	 * }
	 */

	@GetMapping("/adicionar")
	public String adicionarUser() {
		return "cadastro";
	}

	@GetMapping("/principal")
	public String paginaPrincipal() {
		return "main";
	}

	@GetMapping("/editar")
	public String editarUsuario(Model model, RedirectAttributes attributes, @RequestParam Long id) {
		String page;

		try {
			Usuario user = service.buscarUsuarioUnico(id);
			model.addAttribute("Usuario", user);
			page = "editarUsuario";

		} catch (UsuarioNotFoundException e) {

			e.printStackTrace();
			attributes.addAttribute("message", e.getMessage());
			page = "redirect:listarUsuario";
		}

		return page;
	}

	@GetMapping("/listar")
	public String listarUsuario(@RequestParam(value = "message", required = false) String message, Model model) {
		// /user/lista? message = hello%Word

		// Lista os usuários
		List<Usuario> user = service.buscarTodosUsuarios();
		model.addAttribute("lista", user);

		// mensagem caso exista
		model.addAttribute("Mensagem", message);

		return "redirect:listarUsuario";
	}

	/*
	 * @PostMapping("/atualizar")
	 * public String atualizarPagamento(@ModelAttribute Usuario user,
	 * RedirectAttributes attributes) {
	 * 
	 * service.atualizarUsuario(user);
	 * Long id = user.getId();
	 * 
	 * attributes.addAttribute("message", "Usuário com o id : " + id +
	 * " foi atualizado");
	 * 
	 * return "redirect:listarUsuario";
	 * }
	 */

	@GetMapping("/deletar")
	public String deletarPagamento(@RequestParam Long id, RedirectAttributes attributes) {
		try {
			service.deletarUsuario(id);
			attributes.addAttribute("message", "O Usuario foi deletado, id : " + id);
		} catch (UsuarioNotFoundException e) {
			e.printStackTrace();
			attributes.addAttribute("message", e.getMessage());
		}

		return "redirect:listarUsuario";
	}
}

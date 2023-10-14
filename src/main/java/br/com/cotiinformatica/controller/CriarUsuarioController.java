package br.com.cotiinformatica.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import br.com.cotiinformatica.entities.Usuario;
import br.com.cotiinformatica.helpers.EncryptHelper;
import br.com.cotiinformatica.repositories.UsuarioRepository;

@Controller
public class CriarUsuarioController {

	// mapeamento da rota da página de criação de usuário
	@RequestMapping(value = "/criar-usuario")
	public ModelAndView criarUsuario() {

		// definindo a página que será aberta no navegador:
		// WEB-INF/views/criar-usuario.jsp
		ModelAndView modelAndView = new ModelAndView("criar-usuario");
		return modelAndView;
	}

	// método para receber o SUBMIT POST do formulário
	@RequestMapping(value = "/criar-usuario-post", method = RequestMethod.POST)
	public ModelAndView criarUsuarioPost(HttpServletRequest request) {

		// WEB-INF/views/criar-usuario.jsp
		ModelAndView modelAndView = new ModelAndView("criar-usuario");

		try {
			
			Usuario usuario = new Usuario();
			
			usuario.setNome(request.getParameter("nome"));
			usuario.setEmail(request.getParameter("email"));
			usuario.setSenha(EncryptHelper.encryptToSHA1(request.getParameter("senha")));
			
			//gravar no banco de dados
			UsuarioRepository usuarioRepository = new UsuarioRepository();
			if(usuarioRepository.find(usuario.getEmail()) == null) {
				usuarioRepository.create(usuario);
				
				//enviando mensagem de sucesso para página
				modelAndView.addObject("mensagem_sucesso", "Usuário cadastrado com sucesso!");
				
			}
			else {
				throw new Exception("O email informado já está cadastrado para outro usuário.");
			}
			
			
		} catch (Exception e) {
			//enviando mensagem de erro para página
			modelAndView.addObject("mensagem_erro", e.getMessage());
		}

		return modelAndView;

	}

}

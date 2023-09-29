package br.com.cotiinformatica.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class CriarUsuarioController {


	// mapeamento da rota da página de criação de usuário
	@RequestMapping(value = "/criar-usuario")
	public ModelAndView criarUsuario() {


		// definindo a página que será aberta no navegador:
		// WEB-INF/views/criar-usuario.jsp
		ModelAndView modelAndView 
= new ModelAndView("criar-usuario");
		return modelAndView;
	}
}


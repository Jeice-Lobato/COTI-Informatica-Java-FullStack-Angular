package br.com.cotiinformatica.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class RecuperarSenhaController {


	// mapeamento da rota da página de criação de usuário
	@RequestMapping(value = "/recuperar-senha")
	public ModelAndView recuperarSenha() {


		// definindo a página que será aberta no navegador:
		// WEB-INF/views/recuperar-senha.jsp
		ModelAndView modelAndView 
= new ModelAndView("recuperar-senha");
		return modelAndView;
	}
}

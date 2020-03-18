package br.vmcorrea.teste_api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.vmcorrea.teste_api.model.Perfil;
import br.vmcorrea.teste_api.service.PerfilService;

/**
 * <h1>PerfilController</h1>
 * <p>
 * Classe responsável pelos enpoints relacionados a entidade Perfil
 * </p>
 * 
 * 
 * @author Victor Corrêa
 *
 */
@RestController()
public class PerfilController {

	@Autowired
	private PerfilService perfilService;

	/**
	 * Método que recebe um perfil via JSON, por requisição HTTP, desserializa e
	 * envia para o cadastro no banco de dados.
	 * 
	 * @param perfil Perfil que será persistido
	 * @return String com a resposta da requisição
	 */
	@PostMapping("/perfis")
	public String criaPerfil(@RequestBody Perfil perfil) {
		return perfilService.criaPerfil(perfil);
	}

	/**
	 * Método que recebe uma requisição HTTP e solicita uma lista de todos os
	 * perfis.
	 * 
	 * @return (1) String em formato Json com a lista de Perfil ou (2) String com a
	 *         mensagem de erro
	 */
	@GetMapping("/perfis")
	public String listaPerfil() {
		return perfilService.listaPerfis();
	}
}

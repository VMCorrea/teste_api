package br.vmcorrea.teste_api.service;

import br.vmcorrea.teste_api.model.Perfil;

/**
 * <h1>PerfilService</h1>
 * <p>
 * Interface da Service de Perfil.
 * </p>
 * 
 * 
 * @author Victor Corrêa
 *
 */
public interface PerfilService {

	/**
	 * Método que configura a busca de uma lista de Perfil no banco de dados.
	 * 
	 * @return (1) String em formato Json com a lista de Perfil ou (2) String com
	 *         mensagem de erro
	 */
	String listaPerfis();

	/**
	 * Método que configura o cadastro de um Perfil no banco de dados.
	 * 
	 * @param perfil Perfil que será persistido.
	 * @return String com mensagem de sucesso ou falha
	 */
	String criaPerfil(Perfil perfil);
}
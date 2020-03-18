package br.vmcorrea.teste_api.service;

import com.querydsl.core.types.Predicate;

import br.vmcorrea.teste_api.model.Usuario;

/**
 * <h1>UsuarioService</h1>
 * <p>
 * Interface da Service de Usuario.
 * </p>
 * 
 * 
 * @author Victor Corrêa
 *
 */
public interface UsuarioService {

	/**
	 * Método que configura a busca de uma lista de Usuario no banco de dados.
	 * 
	 * @return (1) String em formato Json com a lista de Usuario ou (2) String com
	 *         mensagem de erro
	 */
	String listaUsuarios();

	/**
	 * Método que configura o cadastro de um Usuario no banco de dados.
	 * 
	 * @param usuario Usuario que será persistido.
	 * @return String com mensagem de sucesso ou falha
	 */
	String criaUsuario(Usuario usuario);

	/**
	 * Método que configura a atualização de um Usuario no banco de dados.
	 * 
	 * @param usuario Usuario que será atualizado.
	 * @return String com mensagem de sucesso ou falha
	 */
	String atualizaUsuario(Usuario usuario, Long id);

	/**
	 * Método que configura a busca por um Usuario no banco de dados.
	 * 
	 * @param id Identificador do Usuario
	 * @return (1) String em formato Json com o Usuario encontrado ou (2) String com
	 *         mensagem de erro
	 */
	String buscaUsuario(Long id);

	/**
	 * Método que configura a remoção de um Usuario do banco de dados.
	 * 
	 * @param id Identificador do Usuario
	 * @return String com mensagem de sucesso ou falha
	 */
	String deletaUsuario(Long id);

	/**
	 * Método utilizado para mudar o status de um Usuario do banco de dados para
	 * INATIVO.
	 * 
	 * @param id Identificador do Usuario
	 * @return String com mensagem de sucesso ou falha
	 */
	String inativarUsuario(Long id);

	/**
	 * Método que configura a busca de uma lista de Usuario no banco de dados,
	 * utilizando a classe Predicate para configurar uma query com filtros.
	 * 
	 * @param predicate Predicate com os filtros configurados
	 * @return (1) String em formato Json com a lista de Usuario ou (2) String com
	 *         mensagem de erro
	 */
	String listaUsuarios(Predicate predicate);

}

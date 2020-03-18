package br.vmcorrea.teste_api.service;

import br.vmcorrea.teste_api.model.Cargo;

/**
 * <h1>CargoService</h1>
 * <p>
 * Interface da Service de Cargo.
 * </p>
 * 
 * 
 * @author Victor Corrêa
 *
 */
public interface CargoService {

	/**
	 * Método que configura a busca de uma lista de Cargos no banco de dados.
	 * 
	 * @return (1) String em formato Json com a lista de Cargo ou (2) String com
	 *         mensagem de erro
	 */
	String listaCargos();

	/**
	 * Método que configura o cadastro de um Cargo no banco de dados.
	 * 
	 * @param cargo Cargo que será persistido
	 * @return String com mensagem de sucesso ou falha
	 */
	String criaCargo(Cargo cargo);
}

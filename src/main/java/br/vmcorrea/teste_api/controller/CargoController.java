package br.vmcorrea.teste_api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.vmcorrea.teste_api.model.Cargo;
import br.vmcorrea.teste_api.service.CargoService;

/**
 * <h1>CargoController</h1>
 * <p>
 * Classe responsável pelos enpoints relacionados a entidade Cargo
 * </p>
 * 
 * 
 * @author Victor Corrêa
 *
 */
@RestController()
public class CargoController {

	@Autowired
	private CargoService cargoService;

	/**
	 * Método que recebe um cargo via JSON, por requisição HTTP, desserializa e
	 * envia para o cadastro no banco de dados.
	 * 
	 * @param cargo Cargo que será persistido
	 * @return String com a resposta da requisição
	 */
	@PostMapping("/cargos")
	public String criaCargo(@RequestBody Cargo cargo) {
		return cargoService.criaCargo(cargo);
	}

	/**
	 * Método que recebe uma requisição HTTP e solicita uma lista de todos os
	 * cargos.
	 * 
	 * @return (1) String em formato Json com a lista de Cargo ou (2) String com a
	 *         mensagem de erro
	 */
	@GetMapping("/cargos")
	public String listaCargo() {
		return cargoService.listaCargos();
	}
}

package br.vmcorrea.teste_api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.vmcorrea.teste_api.model.Cargo;
import br.vmcorrea.teste_api.service.CargoService;

@RestController()
public class CargoController {

	@Autowired
	private CargoService cargoService;

	@PostMapping("/cargos")
	public String criaCargo(@RequestBody Cargo cargo) {
		return cargoService.criaCargo(cargo);
	}

	@GetMapping("/cargos")
	public String listaCargo() {
		return cargoService.listaCargos();
	}
}

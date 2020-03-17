package br.vmcorrea.teste_api.service;

import br.vmcorrea.teste_api.model.Cargo;

public interface CargoService {

	String listaCargos();

	String criaCargo(Cargo cargo);
}

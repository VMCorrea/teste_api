package br.vmcorrea.teste_api.dao;

import org.springframework.data.repository.CrudRepository;

import br.vmcorrea.teste_api.model.Cargo;

public interface CargoDao extends CrudRepository<Cargo, String> {

}

package br.vmcorrea.teste_api.dao;

import org.springframework.data.repository.CrudRepository;

import br.vmcorrea.teste_api.model.Perfil;

public interface PerfilDao extends CrudRepository<Perfil, String> {

}

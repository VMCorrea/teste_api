package br.vmcorrea.teste_api.dao;

import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.repository.CrudRepository;

import br.vmcorrea.teste_api.model.Usuario;

public interface UsuarioDao extends CrudRepository<Usuario, Long>, QuerydslPredicateExecutor<Usuario> {

}

package br.vmcorrea.teste_api.service;

import com.querydsl.core.types.Predicate;

import br.vmcorrea.teste_api.model.Usuario;

public interface UsuarioService {

	String listaUsuarios();

	String criaUsuario(Usuario usuario);

	String atualizaUsuario(Usuario usuario, Long id);

	String buscaUsuario(Long id);

	String deletaUsuario(Long id);

	String inativarUsuario(Long id);

	String listaUsuarios(Predicate predicate);

}

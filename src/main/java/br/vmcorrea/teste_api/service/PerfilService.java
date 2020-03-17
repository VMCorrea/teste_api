package br.vmcorrea.teste_api.service;

import br.vmcorrea.teste_api.model.Perfil;

public interface PerfilService {

	String listaPerfis();

	String criaPerfil(Perfil perfil);
}
package br.vmcorrea.teste_api.utils;

import br.vmcorrea.teste_api.model.Usuario;

public class UsuarioUtils {

	public static final String STATUS_ATIVO = "ATIVO";
	public static final String STATUS_INATIVO = "INATIVO";

	public static void merge(Usuario usuarioDB, Usuario usuario) {

		if (usuario.getCargo() == null)
			usuario.setCargo(usuarioDB.getCargo());

		if (usuario.getCPF() == null || usuario.getCPF().isBlank())
			usuario.setCPF(usuarioDB.getCPF());

		if (usuario.getDataDeNascimento() == null)
			usuario.setDataDeNascimento(usuarioDB.getDataDeNascimento());

		if (usuario.getNome() == null || usuario.getNome().isBlank())
			usuario.setNome(usuarioDB.getNome());

		if (usuario.getPerfil() == null)
			usuario.setPerfil(usuarioDB.getPerfil());

		if (usuario.getSexo() == null || usuario.getSexo().isBlank())
			usuario.setSexo(usuarioDB.getSexo());

		if (usuario.getStatus() == null || !usuario.getStatus().equals("INATIVO"))
			usuario.setStatus("ATIVO");
	}

	public static boolean hasNull(Usuario usuario) {

		if (usuario.getCargo() == null || usuario.getCargo().getTitulo() == null
				|| usuario.getCargo().getTitulo().isBlank())
			return true;

		if (usuario.getCPF() == null || usuario.getCPF().isBlank())
			return true;

		if (usuario.getDataDeNascimento() == null)
			return true;

		if (usuario.getNome() == null || usuario.getNome().isBlank())
			return true;

		if (usuario.getPerfil() == null || usuario.getPerfil().getTitulo() == null
				|| usuario.getPerfil().getTitulo().isBlank())
			return true;

		if (usuario.getSexo() == null || usuario.getSexo().isBlank())
			return true;

		if (usuario.getStatus() == null || usuario.getStatus().isBlank())
			return true;

		return false;
	}
}

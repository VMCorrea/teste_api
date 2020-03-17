package br.vmcorrea.teste_api.service;

import java.util.NoSuchElementException;

import javax.persistence.EntityNotFoundException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import br.vmcorrea.teste_api.dao.CargoDao;
import br.vmcorrea.teste_api.dao.PerfilDao;
import br.vmcorrea.teste_api.dao.UsuarioDao;
import br.vmcorrea.teste_api.model.Usuario;
import br.vmcorrea.teste_api.utils.ValidaCPF;

@Service
public class UsuarioServiceImpl implements UsuarioService {

	private static final Logger LOG = LogManager.getLogger(UsuarioServiceImpl.class);
	private static final ObjectMapper MAPPER = new ObjectMapper();

	@Autowired
	private UsuarioDao usuarioDao;

	@Autowired
	private CargoDao cargoDao;

	@Autowired
	private PerfilDao perfilDao;

	@Override
	public String listaUsuarios() {

		Iterable<Usuario> list = usuarioDao.findAll();

		try {
			return MAPPER.writeValueAsString(list);
		} catch (JsonProcessingException e) {

			LOG.error(e.getMessage());
			return "Erro na serialização dos dados";
		}
	}

	@Override
	public String criaUsuario(Usuario usuario) {

		try {

			String cpf = usuario.getCPF().replaceAll("[^0-9]", "");

			if (ValidaCPF.valida(cpf)) {
				usuario.setCPF(cpf);
			} else {
				return "CPF Inválido!";
			}

			usuarioDao.save(usuario);

			return "Usuário criado";
		} catch (EntityNotFoundException e) {

			LOG.error(e.getMessage());
			return "Cargo e/ou Perfil não existem!";
		} catch (NullPointerException e) {

			LOG.error(e.getMessage());
			e.printStackTrace();
			return "Erro ao criar usuario. Nenhum dado pode ser nulo!";
		} catch (Exception e) {
			LOG.error(e.getMessage());
			return "Erro ao criar usuario. Verifique os dados.";
		}
	}

	@Override
	public String atualizaUsuario(Usuario usuario, Long id) {
		try {

			Usuario usuarioDB = usuarioDao.findById(id).orElseThrow();

			merge(usuarioDB, usuario);

			String cpf = usuario.getCPF().replaceAll("[^0-9]", "");

			if (ValidaCPF.valida(cpf)) {
				usuario.setCPF(cpf);
			} else {
				return "CPF Inválido!";
			}

			usuario.setId(id);

			usuarioDao.save(usuario);

			return "Usuário atualizado";
		} catch (EntityNotFoundException e) {

			LOG.error(e.getMessage());
			return "Cargo e/ou Perfil não existem!";
		} catch (NoSuchElementException e) {

			return "Usuário não existe";
		} catch (NullPointerException e) {

			LOG.error(e.getMessage());
			e.printStackTrace();
			return "Erro ao atualizar usuario. Nenhum dado pode ser nulo!";
		} catch (Exception e) {
			LOG.error(e.getMessage());
			return "Erro ao atualizar usuario. Verifique os dados.";
		}
	}

	private void merge(Usuario usuarioDB, Usuario usuario) {

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

		if (usuario.getStatus() == null || usuario.getStatus().isBlank())
			usuario.setStatus(usuarioDB.getStatus());
	}

	@Override
	public String buscaUsuario(Long id) {

		try {
			Usuario usuarioDB = usuarioDao.findById(id).orElseThrow();

			return MAPPER.writeValueAsString(usuarioDB);
		} catch (NoSuchElementException e) {

			return "Usuário não encontrado!";
		} catch (Exception e) {

			LOG.error(e.getMessage());
			return "Erro ao buscar usuário!";
		}
	}

	@Override
	public String deletaUsuario(Long id) {

		try {

			usuarioDao.deleteById(id);

			return "Usuário removido.";
		} catch (Exception e) {

			LOG.error(e.getMessage());
			return "Erro ao deletar usuário";
		}
	}

}

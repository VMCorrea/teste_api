package br.vmcorrea.teste_api.service;

import java.util.NoSuchElementException;

import javax.persistence.EntityNotFoundException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.querydsl.core.types.Predicate;

import br.vmcorrea.teste_api.dao.UsuarioDao;
import br.vmcorrea.teste_api.model.Usuario;
import br.vmcorrea.teste_api.utils.UsuarioUtils;
import br.vmcorrea.teste_api.utils.ValidaCPF;

/**
 * <h1>UsuarioServiceImpl</h1>
 * <p>
 * Implementação da Service de Usuario, com os métodos que aplicam possíveis
 * regras de negócio e operações que se comunicam com o banco de dados.
 * </p>
 * 
 * 
 * @author Victor Corrêa
 *
 */
@Service
public class UsuarioServiceImpl implements UsuarioService {

	private static final Logger LOG = LogManager.getLogger(UsuarioServiceImpl.class);
	private static final ObjectMapper MAPPER = new ObjectMapper();

	@Autowired
	private UsuarioDao usuarioDao;

	@Override
	public String listaUsuarios() {

		Iterable<Usuario> list = usuarioDao.findAll();

		try {

			String response = MAPPER.writeValueAsString(list);
			LOG.info("Lista de usuario configurada.");
			return response;
		} catch (JsonProcessingException e) {

			LOG.error(e.getMessage());
			return "Erro na serialização dos dados";
		}
	}

	@Override
	public String listaUsuarios(Predicate predicate) {

		Iterable<Usuario> list = usuarioDao.findAll(predicate);

		try {

			String response = MAPPER.writeValueAsString(list);
			LOG.info("Lista de usuario configurada.");
			return response;
		} catch (JsonProcessingException e) {

			LOG.error(e.getMessage());
			return "Erro na serialização dos dados";
		}
	}

	@Override
	public String criaUsuario(Usuario usuario) {

		try {

			if (UsuarioUtils.hasNull(usuario))
				throw new NullPointerException("Campos nulos!");

			if (!usuario.getStatus().equals(UsuarioUtils.STATUS_INATIVO))
				usuario.setStatus(UsuarioUtils.STATUS_ATIVO);

			String cpf = usuario.getCPF().replaceAll("[^0-9]", "");

			if (ValidaCPF.valida(cpf)) {
				usuario.setCPF(cpf);
			} else {
				return "CPF Inválido!";
			}

			usuarioDao.save(usuario);

			LOG.info("Usuário " + usuario.getNome() + " criado com sucesso.");
			return "Usuário criado";
		} catch (EntityNotFoundException e) {

			LOG.error(e.getMessage());
			return "Cargo e/ou Perfil não existem!";
		} catch (NullPointerException e) {

			LOG.error(e.getMessage());
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

			UsuarioUtils.merge(usuarioDB, usuario);

			String cpf = usuario.getCPF().replaceAll("[^0-9]", "");

			if (ValidaCPF.valida(cpf)) {
				usuario.setCPF(cpf);
			} else {
				return "CPF Inválido!";
			}

			usuario.setId(id);

			usuarioDao.save(usuario);

			LOG.info("Usuário " + usuario.getNome() + " atualizado com sucesso.");
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

	@Override
	public String buscaUsuario(Long id) {

		try {
			Usuario usuarioDB = usuarioDao.findById(id).orElseThrow();

			String response = MAPPER.writeValueAsString(usuarioDB);
			LOG.info("Usuário " + usuarioDB.getNome() + " encontrado com sucesso");
			return response;
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

			LOG.info("Usuário de id '" + id + "' removido com sucesso.");
			return "Usuário removido.";
		} catch (Exception e) {

			LOG.error(e.getMessage());
			return "Erro ao deletar usuário";
		}
	}

	@Override
	public String inativarUsuario(Long id) {

		try {

			Usuario usuario = usuarioDao.findById(id).orElseThrow();

			if (usuario.getStatus().equals(UsuarioUtils.STATUS_INATIVO))
				throw new IllegalArgumentException("Usuário já está inativo!");
			else
				usuario.setStatus(UsuarioUtils.STATUS_INATIVO);

			usuarioDao.save(usuario);

			LOG.info("Usuário " + usuario.getNome() + " inativado.");
			return "Usuário inativado!";

		} catch (IllegalArgumentException e) {

			LOG.error(e.getMessage());
			return "Usuário já está inativo!";
		} catch (NoSuchElementException e) {

			LOG.error(e.getMessage());
			return "Usuario não encontrado";
		} catch (Exception e) {

			LOG.error(e.getMessage());
			return "Erro ao inativar usuário!";
		}
	}
}

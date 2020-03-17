package br.vmcorrea.teste_api.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import br.vmcorrea.teste_api.dao.PerfilDao;
import br.vmcorrea.teste_api.model.Perfil;

@Service
public class PerfilServiceImpl implements PerfilService {

	private static final Logger LOG = LogManager.getLogger(PerfilServiceImpl.class);
	private static final ObjectMapper MAPPER = new ObjectMapper();

	@Autowired
	private PerfilDao perfilDao;

	@Override
	public String listaPerfis() {

		Iterable<Perfil> list = perfilDao.findAll();

		try {
			return MAPPER.writeValueAsString(list);
		} catch (JsonProcessingException e) {

			LOG.error(e.getMessage());
			return "Erro na serialização dos dados";
		}
	}

	@Override
	public String criaPerfil(Perfil perfil) {

		try {

			String nome = perfil.getTitulo().toUpperCase();

			perfil.setTitulo(nome);

			perfilDao.save(perfil);

			return "Cargo criado";
		} catch (Exception e) {
			LOG.error(e.getMessage());
			return "Erro ao criar cargo. Verifique os dados.";
		}
	}
}

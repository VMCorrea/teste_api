package br.vmcorrea.teste_api.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import br.vmcorrea.teste_api.dao.CargoDao;
import br.vmcorrea.teste_api.model.Cargo;

/**
 * <h1>CargoServiceImpl</h1>
 * <p>
 * Implementação da Service de Cargo, com os métodos que aplicam possíveis
 * regras de negócio e operações que se comunicam com o banco de dados.
 * </p>
 * 
 * 
 * @author Victor Corrêa
 *
 */
@Service
public class CargoServiceImpl implements CargoService {

	private static final Logger LOG = LogManager.getLogger(CargoServiceImpl.class);
	private static final ObjectMapper MAPPER = new ObjectMapper();

	@Autowired
	private CargoDao cargoDao;

	@Override
	public String listaCargos() {

		Iterable<Cargo> list = cargoDao.findAll();

		try {
			return MAPPER.writeValueAsString(list);
		} catch (JsonProcessingException e) {

			LOG.error(e.getMessage());
			return "Erro na serialização dos dados";
		}
	}

	@Override
	public String criaCargo(Cargo cargo) {

		try {

			String nome = cargo.getTitulo().toUpperCase();

			cargo.setTitulo(nome);

			cargoDao.save(cargo);

			return "Cargo criado";
		} catch (Exception e) {

			LOG.error(e.getMessage());
			return "Erro ao criar cargo. Verifique os dados.";
		}
	}
}

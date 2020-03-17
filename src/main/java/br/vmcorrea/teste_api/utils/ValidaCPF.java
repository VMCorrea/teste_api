package br.vmcorrea.teste_api.utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import br.com.caelum.stella.validation.CPFValidator;
import br.com.caelum.stella.validation.InvalidStateException;

public class ValidaCPF {

	private static final Logger LOG = LogManager.getLogger(ValidaCPF.class);

	public static Boolean valida(String cpf) {

		CPFValidator cpfValidator = new CPFValidator();

		try {

			cpfValidator.assertValid(cpf);
			return true;
		} catch (InvalidStateException e) {

			LOG.error("CPF inválido: " + e.getMessage());
			return false;
		}
	}
}

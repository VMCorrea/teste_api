package br.vmcorrea.teste_api.testes;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import br.vmcorrea.teste_api.utils.ValidaCPF;

class TesteUsuario {

	@Test
	public void testValidacaoDeCPF() {

		String cpfValido = "62154146031";
		String cpfInvalido = "12354979641";
		
		assertTrue(ValidaCPF.valida(cpfValido));
		assertFalse(ValidaCPF.valida(cpfInvalido));
	}

}

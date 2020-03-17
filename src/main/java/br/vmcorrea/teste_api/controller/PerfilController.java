package br.vmcorrea.teste_api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.vmcorrea.teste_api.model.Perfil;
import br.vmcorrea.teste_api.service.PerfilService;

@RestController()
public class PerfilController {

	@Autowired
	private PerfilService perfilService;

	@PostMapping("/perfis")
	public String criaPerfil(@RequestBody Perfil perfil) {
		return perfilService.criaPerfil(perfil);
	}

	@GetMapping("/perfis")
	public String listaPerfil() {
		return perfilService.listaPerfis();
	}
}

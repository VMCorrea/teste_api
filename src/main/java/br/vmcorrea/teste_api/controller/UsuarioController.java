package br.vmcorrea.teste_api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.vmcorrea.teste_api.model.Usuario;
import br.vmcorrea.teste_api.service.UsuarioService;

@RestController()
public class UsuarioController {

	@Autowired
	private UsuarioService usuarioService;

	@PostMapping("/usuarios")
	public String criaUsuario(@RequestBody Usuario usuario) {
		return usuarioService.criaUsuario(usuario);
	}

	@PutMapping("/usuarios/{id}")
	public String atualizaUsuario(@RequestBody Usuario usuario, @PathVariable Long id) {
		return usuarioService.atualizaUsuario(usuario, id);
	}

	@GetMapping("/usuarios/{id}")
	public String buscaUsuario(@PathVariable Long id) {
		return usuarioService.buscaUsuario(id);
	}

	@GetMapping("/usuarios")
	public String listaUsuarios() {
		return usuarioService.listaUsuarios();
	}

	@DeleteMapping("/usuarios/{id}")
	public String deletaUsuario(@PathVariable Long id) {
		return usuarioService.deletaUsuario(id);
	}
	
	@PostMapping("/usuarios/{id}/inativar")
	public String inativarUsuario(@PathVariable Long id) {
		return usuarioService.inativarUsuario(id);
	}
}

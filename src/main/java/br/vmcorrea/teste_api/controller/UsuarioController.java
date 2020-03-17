package br.vmcorrea.teste_api.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.querydsl.core.types.dsl.BooleanExpression;

import br.vmcorrea.teste_api.model.QUsuario;
import br.vmcorrea.teste_api.model.Usuario;
import br.vmcorrea.teste_api.service.UsuarioService;
import br.vmcorrea.teste_api.utils.DataUtil;

@RestController()
public class UsuarioController {

	private static final Logger LOG = LogManager.getLogger(UsuarioController.class);

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
	public String listaUsuarios(@RequestParam(required = false) String nome, @RequestParam(required = false) String cpf,
			@RequestParam(required = false) String cargo, @RequestParam(required = false) String perfil,
			@RequestParam(required = false) String status) {

		BooleanExpression exp = QUsuario.usuario.isNotNull();

		if (nome != null && !nome.isBlank())
			exp = exp.and(QUsuario.usuario.nome.like(nome));

		if (cpf != null && !cpf.isBlank())
			exp = exp.and(QUsuario.usuario.cpf.like(cpf));

		if (cargo != null && !cargo.isBlank())
			exp = exp.and(QUsuario.usuario.cargo.titulo.like(cargo));

		if (perfil != null && !perfil.isBlank())
			exp = exp.and(QUsuario.usuario.perfil.titulo.like(perfil));

		if (status != null && !status.isBlank())
			exp = exp.and(QUsuario.usuario.status.like(status));

		return usuarioService.listaUsuarios(exp);
	}

	@GetMapping("/usuarios/mulheres-adultas")
	public String listaMulheresAdultas() {

		BooleanExpression exp = QUsuario.usuario.sexo.like("FEMININO")
				.and(QUsuario.usuario.dataDeNascimento.before(DataUtil.anosAtras(18)));

		return usuarioService.listaUsuarios(exp);
	}

	@GetMapping("/usuarios/cpf-inicio-zero")
	public String listaCpfInicioZero() {

		BooleanExpression exp = QUsuario.usuario.cpf.startsWith("0");

		return usuarioService.listaUsuarios(exp);
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

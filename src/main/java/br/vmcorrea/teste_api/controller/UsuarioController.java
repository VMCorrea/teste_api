package br.vmcorrea.teste_api.controller;

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

/**
 * <h1>UsuarioController</h1>
 * <p>
 * Classe responsável pelos enpoints relacionados a entidade Usuario
 * </p>
 * 
 * 
 * @author Victor Corrêa
 *
 */
@RestController()
public class UsuarioController {

	@Autowired
	private UsuarioService usuarioService;

	/**
	 * Método que recebe um usuário via JSON por requisição HTTP, desserializa e
	 * envia para o cadastro no banco de dados.
	 * 
	 * @param usuario Usuario que será persistido
	 * @return String com a resposta da requisição
	 */
	@PostMapping("/usuarios")
	public String criaUsuario(@RequestBody Usuario usuario) {
		return usuarioService.criaUsuario(usuario);
	}

	/**
	 * Método que recebe um usuário via JSON e um id ,por requisição HTTP,
	 * desserializa e envia para a atualização no banco de dados.
	 * 
	 * @param usuario Usuario com as informações que serão atualizadas
	 * @param id      Identificador do usuario no banco de dados
	 * @return String com a resposta da requisição
	 */
	@PutMapping("/usuarios/{id}")
	public String atualizaUsuario(@RequestBody Usuario usuario, @PathVariable Long id) {
		return usuarioService.atualizaUsuario(usuario, id);
	}

	/**
	 * Método que recebe um id por parâmetro, por requisição HTTP, e o envia para
	 * buscar um usuário.
	 * 
	 * @param id Identificador que será usado na busca do Usuario
	 * @return (1) String em formato Json com o Usuario encontrado ou (2) String com
	 *         a mensagem de erro
	 */
	@GetMapping("/usuarios/{id}")
	public String buscaUsuario(@PathVariable Long id) {
		return usuarioService.buscaUsuario(id);
	}

	/**
	 * Método que pode ou não receber parametros, por requisição HTTP, e pede uma
	 * lista de usuários com os parâmetros recebidos, ou todos caso não tenha
	 * parâmetros.
	 * 
	 * @param nome
	 * @param cpf
	 * @param cargo
	 * @param perfil
	 * @param status
	 * @return (1) String em formato Json com a lista de Usuario ou (2) String com a
	 *         mensagem de erro
	 */
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

	/**
	 * Método que recebe uma requisiçao HTTP e solicita uma listagem de usuario
	 * femininos com mais de 18 anos.
	 * 
	 * @return (1) String em formato Json com a lista de Usuario ou (2) String com a
	 *         mensagem de erro
	 */
	@GetMapping("/usuarios/mulheres-adultas")
	public String listaMulheresAdultas() {

		BooleanExpression exp = QUsuario.usuario.sexo.like("FEMININO")
				.and(QUsuario.usuario.dataDeNascimento.before(DataUtil.anosAtras(18)));

		return usuarioService.listaUsuarios(exp);
	}

	/**
	 * Método que recebe uma requisiçao HTTP e solicita uma listagem de usuario que
	 * o cpf inicie com o digito 0.
	 * 
	 * @return (1) String em formato Json com a lista de Usuario ou (2) String com a
	 *         mensagem de erro
	 */
	@GetMapping("/usuarios/cpf-inicio-zero")
	public String listaCpfInicioZero() {

		BooleanExpression exp = QUsuario.usuario.cpf.startsWith("0");

		return usuarioService.listaUsuarios(exp);
	}

	/**
	 * 
	 * Método que recebe um id via parâmetro, por requisição HTTP, e solicita a
	 * remoção do usuário correspondente.
	 * 
	 * @param id Identificador do usuario que será removido
	 * @return String com a resposta da requisição
	 */
	@DeleteMapping("/usuarios/{id}")
	public String deletaUsuario(@PathVariable Long id) {
		return usuarioService.deletaUsuario(id);
	}

	/**
	 * 
	 * Método que recebe um id via parâmetro, por requisição HTTP, e solicita a
	 * atualização do campo status, do usuario correspondente, para INATIVO.
	 * 
	 * @param id Identificador do usuario que será inativado
	 * @return String com a resposta da requisição
	 */
	@PostMapping("/usuarios/{id}/inativar")
	public String inativarUsuario(@PathVariable Long id) {
		return usuarioService.inativarUsuario(id);
	}
}

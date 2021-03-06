package br.vmcorrea.teste_api.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * <h1>Usuario</h1>
 * <p>
 * Classe que representa a entidade Usuario
 * </p>
 * 
 * 
 * @author Victor Corrêa
 *
 */
@Entity
@Table(name = "USUARIO")
public class Usuario {

	private @Id @GeneratedValue(strategy = GenerationType.IDENTITY) Long id;
	@Column(nullable = false, unique = true)
	private String nome;
	@Column(nullable = false, unique = true)
	private String cpf;
	@Column(nullable = false)
	private String sexo;

	@Column(nullable = false)
	@JsonFormat(pattern = "dd/MM/yyyy", timezone = "America/Sao_Paulo")
	private Date dataDeNascimento;

	@ManyToOne(optional = false)
	private Cargo cargo;

	@ManyToOne(optional = false)
	private Perfil perfil;

	@Column(nullable = false)
	private String status;

	/* Getters & Setters */

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCPF() {
		return this.cpf;
	}

	public void setCPF(String cpf) {
		this.cpf = cpf;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public Date getDataDeNascimento() {
		return dataDeNascimento;
	}

	public void setDataDeNascimento(Date dataDeNascimento) {
		this.dataDeNascimento = dataDeNascimento;
	}

	public Cargo getCargo() {
		return cargo;
	}

	public void setCargo(Cargo cargo) {
		this.cargo = cargo;
	}

	public Perfil getPerfil() {
		return perfil;
	}

	public void setPerfil(Perfil perfil) {
		this.perfil = perfil;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

}

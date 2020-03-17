package br.vmcorrea.teste_api.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "PERFIL")
public class Perfil {

	private @Id String nome;

	public String getNome() {
		return nome;
	}

	public void setName(String nome) {
		this.nome = nome;
	}
}

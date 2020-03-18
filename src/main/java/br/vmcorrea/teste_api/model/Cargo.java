package br.vmcorrea.teste_api.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * <h1>Cargo</h1>
 * <p>
 * Classe que representa a entidade Cargo
 * </p>
 * 
 * 
 * @author Victor Corrêa
 *
 */
@Entity
@Table(name = "CARGO")
public class Cargo {

	private @Id String titulo;

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
}

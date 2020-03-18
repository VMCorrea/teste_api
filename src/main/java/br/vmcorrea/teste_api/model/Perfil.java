package br.vmcorrea.teste_api.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * <h1>Perfil</h1>
 * <p>
 * Classe que representa a entidade Perfil
 * </p>
 * 
 * 
 * @author Victor Corrêa
 *
 */
@Entity
@Table(name = "PERFIL")
public class Perfil {

	private @Id String titulo;

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
}

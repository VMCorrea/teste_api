package br.vmcorrea.teste_api.model;

import static com.querydsl.core.types.PathMetadataFactory.forVariable;

import javax.annotation.Generated;

import com.querydsl.core.types.Path;
import com.querydsl.core.types.PathMetadata;
import com.querydsl.core.types.dsl.EntityPathBase;
import com.querydsl.core.types.dsl.StringPath;

/**
 * QPerfil is a Querydsl query type for Perfil
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QPerfil extends EntityPathBase<Perfil> {

	private static final long serialVersionUID = 537433794L;

	public static final QPerfil perfil = new QPerfil("perfil");

	public final StringPath titulo = createString("titulo");

	public QPerfil(String variable) {
		super(Perfil.class, forVariable(variable));
	}

	public QPerfil(Path<? extends Perfil> path) {
		super(path.getType(), path.getMetadata());
	}

	public QPerfil(PathMetadata metadata) {
		super(Perfil.class, metadata);
	}

}

package br.vmcorrea.teste_api.model;

import static com.querydsl.core.types.PathMetadataFactory.forVariable;

import javax.annotation.Generated;

import com.querydsl.core.types.Path;
import com.querydsl.core.types.PathMetadata;
import com.querydsl.core.types.dsl.EntityPathBase;
import com.querydsl.core.types.dsl.StringPath;

/**
 * QCargo is a Querydsl query type for Cargo
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QCargo extends EntityPathBase<Cargo> {

	private static final long serialVersionUID = -548977658L;

	public static final QCargo cargo = new QCargo("cargo");

	public final StringPath titulo = createString("titulo");

	public QCargo(String variable) {
		super(Cargo.class, forVariable(variable));
	}

	public QCargo(Path<? extends Cargo> path) {
		super(path.getType(), path.getMetadata());
	}

	public QCargo(PathMetadata metadata) {
		super(Cargo.class, metadata);
	}

}

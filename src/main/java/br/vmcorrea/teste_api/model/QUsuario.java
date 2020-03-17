package br.vmcorrea.teste_api.model;

import static com.querydsl.core.types.PathMetadataFactory.forVariable;

import javax.annotation.Generated;

import com.querydsl.core.types.Path;
import com.querydsl.core.types.PathMetadata;
import com.querydsl.core.types.dsl.DateTimePath;
import com.querydsl.core.types.dsl.EntityPathBase;
import com.querydsl.core.types.dsl.NumberPath;
import com.querydsl.core.types.dsl.PathInits;
import com.querydsl.core.types.dsl.StringPath;

/**
 * QUsuario is a Querydsl query type for Usuario
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QUsuario extends EntityPathBase<Usuario> {

	private static final long serialVersionUID = 26567928L;

	private static final PathInits INITS = PathInits.DIRECT2;

	public static final QUsuario usuario = new QUsuario("usuario");

	public final QCargo cargo;

	public final StringPath cpf = createString("cpf");

	public final DateTimePath<java.util.Date> dataDeNascimento = createDateTime("dataDeNascimento",
			java.util.Date.class);

	public final NumberPath<Long> id = createNumber("id", Long.class);

	public final StringPath nome = createString("nome");

	public final QPerfil perfil;

	public final StringPath sexo = createString("sexo");

	public final StringPath status = createString("status");

	public QUsuario(String variable) {
		this(Usuario.class, forVariable(variable), INITS);
	}

	public QUsuario(Path<? extends Usuario> path) {
		this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
	}

	public QUsuario(PathMetadata metadata) {
		this(metadata, PathInits.getFor(metadata, INITS));
	}

	public QUsuario(PathMetadata metadata, PathInits inits) {
		this(Usuario.class, metadata, inits);
	}

	public QUsuario(Class<? extends Usuario> type, PathMetadata metadata, PathInits inits) {
		super(type, metadata, inits);
		this.cargo = inits.isInitialized("cargo") ? new QCargo(forProperty("cargo")) : null;
		this.perfil = inits.isInitialized("perfil") ? new QPerfil(forProperty("perfil")) : null;
	}

}

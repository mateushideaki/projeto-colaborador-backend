package br.net.mirante.colaborador.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import br.net.mirante.colaborador.model.Usuario;

public interface UsuarioRepository extends MongoRepository<Usuario, String> {

	public abstract Optional<Usuario> findByLogin(String login);

}

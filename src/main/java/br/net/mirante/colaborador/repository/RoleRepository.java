package br.net.mirante.colaborador.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import br.net.mirante.colaborador.model.Role;

public interface RoleRepository extends MongoRepository<Role, String> {

	public abstract Optional<Role> findByName(String name);


}

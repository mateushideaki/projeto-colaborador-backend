package br.net.mirante.colaborador.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import br.net.mirante.colaborador.model.Cargo;

public interface CargoRepository extends MongoRepository<Cargo, String> {
}

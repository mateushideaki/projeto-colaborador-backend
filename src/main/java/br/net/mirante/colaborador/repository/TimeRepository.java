package br.net.mirante.colaborador.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import br.net.mirante.colaborador.model.Time;

public interface TimeRepository extends MongoRepository<Time, String> {
}

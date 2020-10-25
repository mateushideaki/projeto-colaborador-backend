package br.net.mirante.colaborador.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;

import br.net.mirante.colaborador.model.Colaborador;

public interface ColaboradorRepository extends MongoRepository<Colaborador, String> {
	public Page<Colaborador> findByNomeContainingIgnoreCase(String nome, Pageable pageable);
}

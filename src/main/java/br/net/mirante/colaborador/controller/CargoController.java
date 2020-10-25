package br.net.mirante.colaborador.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.server.ResponseStatusException;

import br.net.mirante.colaborador.auxiliares.annotations.RestApiController;
import br.net.mirante.colaborador.model.Cargo;
import br.net.mirante.colaborador.repository.CargoRepository;

@RestApiController("/cargos")
public class CargoController {

	@Autowired
	private CargoRepository cargoRepository;

	@GetMapping
	@ResponseStatus(HttpStatus.CREATED)
	public List<Cargo> listarCargos() throws ResponseStatusException {
		return cargoRepository.findAll();
	}

}

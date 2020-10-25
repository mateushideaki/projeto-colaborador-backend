package br.net.mirante.colaborador.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.server.ResponseStatusException;

import br.net.mirante.colaborador.auxiliares.annotations.RestApiController;
import br.net.mirante.colaborador.model.Time;
import br.net.mirante.colaborador.repository.TimeRepository;

@RestApiController("/times")
public class TimeController {

	@Autowired
	private TimeRepository timeRepository;

	@GetMapping
	@ResponseStatus(HttpStatus.CREATED)
	public List<Time> listarTimes() throws ResponseStatusException {
		return timeRepository.findAll();
	}

}

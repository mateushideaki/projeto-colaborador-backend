package br.net.mirante.colaborador.service;

import java.io.IOException;
import java.util.Optional;

import org.bson.BsonBinarySubType;
import org.bson.types.Binary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.server.ResponseStatusException;

import br.net.mirante.colaborador.model.Cargo;
import br.net.mirante.colaborador.model.Colaborador;
import br.net.mirante.colaborador.model.Time;
import br.net.mirante.colaborador.repository.CargoRepository;
import br.net.mirante.colaborador.repository.ColaboradorRepository;
import br.net.mirante.colaborador.repository.TimeRepository;

@Service
public class ColaboradorService {

	@Autowired
	private TimeRepository timeRepository;
	@Autowired
	private CargoRepository cargoRepository;
	@Autowired
	private ColaboradorRepository colaboradorRepository;

	public void validaInformacoesColaborador(Colaborador colaborador) {
		Optional<Time> time = timeRepository.findById(colaborador.getTime().getId());
		if (!time.isPresent()) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Time não encontrado");
		}

		Optional<Cargo> cargo = cargoRepository.findById(colaborador.getCargo().getId());
		if (!cargo.isPresent()) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Cargo não encontrado");
		}
	}

	public void validaIdColaborador(String id) {
		Optional<Colaborador> colaborador = colaboradorRepository.findById(id);
		if (!colaborador.isPresent()) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Colaborador não encontrado");
		}
	}

	public Colaborador getColaborador(String id) {
		Optional<Colaborador> colaborador = colaboradorRepository.findById(id);
		if (!colaborador.isPresent()) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Colaborador não encontrado");
		}

		return colaborador.get();
	}

	public Colaborador salvar(Colaborador colaborador) {
		validaInformacoesColaborador(colaborador);
		return colaboradorRepository.save(colaborador);
	}

	public Colaborador alterar(String id, Colaborador colaborador) {
		validaInformacoesColaborador(colaborador);
		Colaborador colaboradorBanco = getColaborador(id);
		colaborador.setId(id);
		colaborador.setFoto(colaboradorBanco.getFoto());
		return colaboradorRepository.save(colaborador);
	}

	public void uploadFoto(String id, MultipartFile file) throws IOException {
		Colaborador colaborador = getColaborador(id);
		colaborador.setFoto(new Binary(BsonBinarySubType.BINARY, file.getBytes()));
		colaboradorRepository.save(colaborador);
	}

	public void excluirColaborador(String id) {
		Colaborador colaborador = getColaborador(id);
		colaboradorRepository.delete(colaborador);
	}

	public Page<Colaborador> buscarColaboradores(String nome, Pageable pageable) {
		return colaboradorRepository.findByNomeContainingIgnoreCase(nome, pageable);
	}
}

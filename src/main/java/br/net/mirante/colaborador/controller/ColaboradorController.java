package br.net.mirante.colaborador.controller;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.server.ResponseStatusException;

import br.net.mirante.colaborador.auxiliares.annotations.RestApiController;
import br.net.mirante.colaborador.enums.TipoContato;
import br.net.mirante.colaborador.model.Colaborador;
import br.net.mirante.colaborador.service.ColaboradorService;

@RestApiController("/colaboradores")
public class ColaboradorController {

	@Autowired
	private ColaboradorService colaboradorService;

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Colaborador adicionar(@Valid @RequestBody Colaborador colaborador) throws ResponseStatusException {
		return colaboradorService.salvar(colaborador);
	}

	@PutMapping("/{id}")
	public Colaborador atualizar(@Valid @RequestBody Colaborador colaborador, @PathVariable String id) {
		return colaboradorService.alterar(id, colaborador);
	}

	@GetMapping
	public Page<Colaborador> buscarColaboradores(@RequestParam(name = "nome", defaultValue = "") String nome,
			@RequestParam(name = "pagina", defaultValue = "0") Integer pagina,
			@RequestParam(name = "qtd", defaultValue = "3") Integer qtd/**,
			@RequestParam("idCargo") String idCargo, @RequestParam("idTime") String idTime,
			@RequestParam("idCompetencia") String idCompetencia**/) {
		Pageable pageable = PageRequest.of(pagina, qtd, Sort.by("nome").ascending().and(Sort.by("id")));
		return colaboradorService.buscarColaboradores(nome, pageable);
	}
	
	@GetMapping("/tiposContato")
	public List<TipoContato> getTiposContato() {
		return Arrays.asList(TipoContato.values());
	}
	
	@GetMapping("/{id}")
	public Colaborador getColaboradorById(@PathVariable String id) {
		return colaboradorService.getColaborador(id);
	}

	@PostMapping("/{id}/foto")
	public void uploadFoto(@PathVariable String id, @RequestParam("image") MultipartFile file) throws IOException {
		colaboradorService.uploadFoto(id, file);
	}

	@DeleteMapping("/{id}")
	public void deletar(@PathVariable String id) {
		colaboradorService.excluirColaborador(id);
	}

}

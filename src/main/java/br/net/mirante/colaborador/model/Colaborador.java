package br.net.mirante.colaborador.model;

import java.util.List;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.bson.types.Binary;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode
@Document
public class Colaborador {
	@Id
	private String id;
	@NotBlank(message = "O campo nome deve ser preenchido")
	private String nome;
	@NotBlank(message = "O campo endereço deve ser preenchido")
	private String endereco;
	@DBRef
	@NotNull(message = "O campo cargo deve ser preenchido")
	private Cargo cargo;
	@DBRef
	@NotNull(message = "O campo time deve ser preenchido")
	private Time time;
	@NotEmpty(message = "O campo contatos deve haver ao menos um registro")
	private List<Contato> contatos;
	private List<String> competencias;
	private Binary foto;

}

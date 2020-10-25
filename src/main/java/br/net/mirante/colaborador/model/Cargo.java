package br.net.mirante.colaborador.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode
@Document
public class Cargo {
	@Id
	private String id;
	private String nome;
	
	public Cargo(String nome) {
		this.nome = nome;
	}
}

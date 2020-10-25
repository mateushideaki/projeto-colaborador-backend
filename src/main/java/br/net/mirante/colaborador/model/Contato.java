package br.net.mirante.colaborador.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import br.net.mirante.colaborador.enums.TipoContato;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode
@Document
public class Contato {
	@Id
	private String id;
	private TipoContato tipoContato;
	private String contato;
}

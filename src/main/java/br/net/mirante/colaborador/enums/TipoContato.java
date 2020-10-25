package br.net.mirante.colaborador.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum TipoContato {

	FIXO("Telefone Fixo"), CELULAR("Telefone Celular"), EMPRESA("Telefone Empresa"), EMAIL("Email"),
	FACEBOOK("Facebook"), LINKEDIN("Linked-in"),;

	private String codigo;

	private TipoContato(String codigo) {
		this.codigo = codigo;
	}

	@JsonCreator
	public static TipoContato getByCodigo(final String codigo) {
		for (final TipoContato itemEnum : TipoContato.values()) {
			if (itemEnum.getCodigo().equals(codigo)) {
				return itemEnum;
			}
		}
		return null;
	}

	@JsonValue
	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

}

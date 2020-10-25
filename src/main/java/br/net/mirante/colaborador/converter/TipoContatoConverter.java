package br.net.mirante.colaborador.converter;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

import br.net.mirante.colaborador.enums.TipoContato;

@Converter(autoApply = true)
public class TipoContatoConverter implements AttributeConverter<TipoContato, String> {

	@Override
	public String convertToDatabaseColumn(TipoContato tipo) {
		if (tipo == null) {
			return null;
		}
		return tipo.getCodigo();
	}

	@Override
	public TipoContato convertToEntityAttribute(String codigo) {
		if (codigo == null) {
			return null;
		}

		return TipoContato.getByCodigo(codigo);
	}
}
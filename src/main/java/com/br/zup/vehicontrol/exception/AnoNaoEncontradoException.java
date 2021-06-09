package com.br.zup.vehicontrol.exception;

import com.br.zup.vehicontrol.model.Combustivel;

public class AnoNaoEncontradoException extends NegocioException{
	
	private static final long serialVersionUID = 1L;

	public AnoNaoEncontradoException(Integer ano, Combustivel combustivel) {
		super("Ano " + ano.toString() + " não encontrado para o combustível " 
				+ combustivel.toString() + "! Verifique o ano e o combustível solicitado.");
	}

}

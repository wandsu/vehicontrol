package com.br.zup.vehicontrol.exception;

public class MarcaNaoEncontradaException extends NegocioException{

	private static final long serialVersionUID = 1L;

	public MarcaNaoEncontradaException(String marca) {
		super("Marca " + marca + " não encontrada! Verifique a marca inserida.");
		
	}

}

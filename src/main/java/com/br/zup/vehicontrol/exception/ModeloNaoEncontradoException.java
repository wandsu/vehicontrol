package com.br.zup.vehicontrol.exception;


public class ModeloNaoEncontradoException extends NegocioException{
	
	private static final long serialVersionUID = 1L;

	public ModeloNaoEncontradoException(String modelo) {
		super("Modelo " + modelo + " não encontrado! Verifique a modelo inserida.");
	}

}
